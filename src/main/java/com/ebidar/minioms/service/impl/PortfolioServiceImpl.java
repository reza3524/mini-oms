package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Portfolio;
import com.ebidar.minioms.dto.PortfolioDto;
import com.ebidar.minioms.enumeration.InstrumentType;
import com.ebidar.minioms.exception.NotFoundException;
import com.ebidar.minioms.mapper.PortfolioMapper;
import com.ebidar.minioms.repository.PortfolioRepository;
import com.ebidar.minioms.service.facade.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final Object lock = new Object();

    private final PortfolioRepository repository;
    private final PortfolioMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public Optional<Portfolio> findOptionalEntityByUserIdAndInstrumentType(String userId, InstrumentType instrumentType) {
        return repository.findByUserIdAndInstrumentType(userId, instrumentType);
    }

    @Override
    @Transactional(readOnly = true)
    public Portfolio findEntityByUserIdAndInstrumentType(String userId, InstrumentType instrumentType) {
        return findOptionalEntityByUserIdAndInstrumentType(userId, instrumentType)
                .orElseThrow(() -> new NotFoundException("err.project2.portfolio.not-found"));
    }

    @Override
    @Transactional(readOnly = true)
    public PortfolioDto findByUserIdAndInstrumentType(String userId, InstrumentType instrumentType) {
        return mapper.toDto(findEntityByUserIdAndInstrumentType(userId, instrumentType));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PortfolioDto> findAllByUserId(String userId) {
        return mapper.toDto(repository.findAllByUserId(userId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PortfolioDto handleBuyPortfolio(PortfolioDto portfolio) {
        synchronized (lock) {
            Portfolio entity;
            Optional<Portfolio> existEntity = findOptionalEntityByUserIdAndInstrumentType(portfolio.getUserId(), portfolio.getInstrumentType());
            if (existEntity.isPresent()) {
                entity = existEntity.get();
                entity.setCount(entity.getCount() + portfolio.getCount());
            } else {
                entity = new Portfolio()
                        .setUserId(portfolio.getUserId())
                        .setInstrumentType(portfolio.getInstrumentType())
                        .setCount(portfolio.getCount());
                repository.save(entity);
            }
            return mapper.toDto(entity);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PortfolioDto handleSellPortfolio(PortfolioDto portfolio) {
        synchronized (lock) {
            Portfolio existEntity = findEntityByUserIdAndInstrumentType(portfolio.getUserId(), portfolio.getInstrumentType());
            existEntity.setCount(existEntity.getCount() - portfolio.getCount());
            return mapper.toDto(repository.save(existEntity));
        }
    }
}
