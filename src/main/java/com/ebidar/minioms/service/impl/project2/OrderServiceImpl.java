package com.ebidar.minioms.service.impl.project2;

import com.ebidar.minioms.domain.project2.Order;
import com.ebidar.minioms.domain.project2.Portfolio;
import com.ebidar.minioms.dto.project2.CreditDto;
import com.ebidar.minioms.dto.project2.OrderDto;
import com.ebidar.minioms.dto.project2.PortfolioDto;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.exception.BadRequestException;
import com.ebidar.minioms.mapper.project2.OrderMapper;
import com.ebidar.minioms.repository.project2.OrderRepository;
import com.ebidar.minioms.service.facade.project2.CreditService;
import com.ebidar.minioms.service.facade.project2.OrderService;
import com.ebidar.minioms.service.facade.project2.PortfolioService;
import com.ebidar.minioms.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final Object lock = new Object();
    @Value("${project.count-minute-restriction}")
    private Integer deal;

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CreditService creditService;
    private final PortfolioService portfolioService;

    @Override
    @Transactional
    public OrderDto buy(OrderDto order) {
        order.setType(PurchaseType.BUY);
        order.setCountPrice(order.getCount() * order.getInstrumentType().getPrice());
        Integer amount = creditService.findByUserId(order.getUserId()).getAmount();
        if (order.getCountPrice() > amount) {
            throw new BadRequestException("err.project2.order.amount.not-valid", new String[]{order.getUserId()});
        }
        Order entity = handleOrder(order);
        creditService.updateAmount(new CreditDto()
                .setUserId(entity.getUserId())
                .setAmount(entity.getCountPrice()), PurchaseType.BUY);
        portfolioService.handleBuyPortfolio(new PortfolioDto()
                .setUserId(entity.getUserId())
                .setInstrumentType(entity.getInstrumentType())
                .setCount(entity.getCount()));
        return mapper.toDto(entity);
    }

    @Override
    @Transactional
    public OrderDto sell(OrderDto order) {
        order.setType(PurchaseType.SELL);
        Portfolio portfolio = portfolioService.findEntityByUserIdAndInstrumentType(order.getUserId(), order.getInstrumentType());
        if (order.getCount() > portfolio.getCount()) {
            throw new BadRequestException("err.project2.order.count-sell.invalid");
        }
        order.setCountPrice(order.getCount() * order.getInstrumentType().getPrice());
        Order entity = handleOrder(order);
        creditService.updateAmount(new CreditDto()
                .setUserId(entity.getUserId())
                .setAmount(entity.getCountPrice()), PurchaseType.SELL);
        portfolioService.handleSellPortfolio(new PortfolioDto()
                .setUserId(entity.getUserId())
                .setInstrumentType(entity.getInstrumentType())
                .setCount(entity.getCount()));
        return mapper.toDto(entity);
    }

    private Order handleOrder(OrderDto order) {
        synchronized (lock) {
            List<Timestamp> current = TimeUtil.getCurrentTimeBetweenOneMinute();
            Integer sum = repository.findAllByUserIdAndTypeAndRegisteredDateBetween(
                            order.getUserId(),
                            order.getType(),
                            current.get(0),
                            current.get(1)).stream()
                    .map(Order::getCountPrice)
                    .reduce(0, Integer::sum);

            if (order.getCountPrice() + sum > deal) {
                throw new BadRequestException("err.project2.order.count-minute-restriction", new Integer[]{deal});
            }
            order.setRegisteredDate(TimeUtil.getCurrent());
            return repository.save(mapper.toEntity(order));
        }
    }
}
