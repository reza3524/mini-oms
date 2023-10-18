package com.ebidar.minioms.repository;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.PurchaseOrder;
import com.ebidar.minioms.enumeration.PurchaseStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends BaseRepository<PurchaseOrder, Long> {

    Optional<PurchaseOrder> findByClientExchangeCodeAndStockCodeAndStatus(String clientExchangeCode, String stockCode, PurchaseStatus status);
}
