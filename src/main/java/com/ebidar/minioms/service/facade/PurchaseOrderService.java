package com.ebidar.minioms.service.facade;

import com.ebidar.minioms.domain.PurchaseOrder;
import com.ebidar.minioms.dto.PurchaseOrderDto;
import com.ebidar.minioms.enumeration.PurchaseStatus;

import java.util.Optional;

public interface PurchaseOrderService {

    PurchaseOrderDto save(PurchaseOrderDto purchaseOrder);

    PurchaseOrderDto update(PurchaseOrderDto purchaseOrder);

    void updateStatus(PurchaseOrderDto purchaseOrder, PurchaseStatus status);

    Optional<PurchaseOrder> findOptionalEntityByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status);

    PurchaseOrder findEntityByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status);

    PurchaseOrderDto findByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status);
}
