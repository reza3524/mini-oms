package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.domain.PurchaseOrder;
import com.ebidar.minioms.domain.Stock;
import com.ebidar.minioms.dto.ClientDto;
import com.ebidar.minioms.dto.PurchaseOrderDto;
import com.ebidar.minioms.dto.StockDto;
import com.ebidar.minioms.enumeration.PurchaseStatus;
import com.ebidar.minioms.enumeration.SettlementType;
import com.ebidar.minioms.exception.NotFoundException;
import com.ebidar.minioms.mapper.PurchaseOrderMapper;
import com.ebidar.minioms.repository.PurchaseOrderRepository;
import com.ebidar.minioms.service.facade.ClientService;
import com.ebidar.minioms.service.facade.PurchaseOrderService;
import com.ebidar.minioms.service.facade.StockService;
import com.ebidar.minioms.util.SettlementUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
//TODO Use log for tracking services 18-oct-2023
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderMapper mapper;
    private final PurchaseOrderRepository repository;
    private final ClientService clientService;
    private final StockService stockService;

    @Override
    @Transactional
    public PurchaseOrderDto save(PurchaseOrderDto purchaseOrder) {
        PurchaseOrder entity = mapper.toEntity(purchaseOrder);
        associate(entity, purchaseOrder);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    @Transactional
    public PurchaseOrderDto update(PurchaseOrderDto purchaseOrder) {
        return null;
    }

    @Override
    @Transactional
    public void updateStatus(PurchaseOrderDto purchaseOrder, PurchaseStatus status) {
        PurchaseOrder existEntity = findEntityByClientExchangeCodeAndStockCodeAndStatus(
                purchaseOrder.getClient().getExchangeCode(),
                purchaseOrder.getStock().getCode(),
                purchaseOrder.getStatus());
        existEntity.setStatus(status);
        repository.save(existEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PurchaseOrder> findOptionalEntityByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status) {
        return repository.findByClientExchangeCodeAndStockCodeAndStatus(clientExchangeCode, stockCode, status);
    }

    @Override
    @Transactional(readOnly = true)
    public PurchaseOrder findEntityByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status) {
        return findOptionalEntityByClientExchangeCodeAndStockCodeAndStatus(clientExchangeCode, stockCode, status)
                .orElseThrow(() -> new NotFoundException("{err.purchase-order.not-found}"));
    }

    @Override
    @Transactional(readOnly = true)
    public PurchaseOrderDto findByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status) {
        return mapper.toDto(findEntityByClientExchangeCodeAndStockCodeAndStatus(clientExchangeCode, stockCode, status));
    }


    private void associate(PurchaseOrder entity, PurchaseOrderDto purchaseOrder) {
        entity.setClient(handleClient(purchaseOrder.getClient()));
        entity.setStock(handleStock(purchaseOrder.getStock()));
        entity.setSettlementDate(handleSettlementDate(entity.getStock().getSettlementType()));
        entity.setStatus(PurchaseStatus.REGISTER);
    }

    private Client handleClient(ClientDto client) {
        return clientService.findEntityByExchangeCode(client.getExchangeCode());
    }

    private Stock handleStock(StockDto stock) {
        return stockService.findEntityByCode(stock.getCode());
    }

    private Timestamp handleSettlementDate(SettlementType settlementType) {
        return SettlementUtil.handleType(settlementType);
    }
}
