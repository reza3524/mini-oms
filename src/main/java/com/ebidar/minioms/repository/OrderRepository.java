package com.ebidar.minioms.repository;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.Order;
import com.ebidar.minioms.enumeration.PurchaseType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

    List<Order> findAllByUserIdAndTypeAndRegisteredDateBetween(String userId, PurchaseType type, Timestamp startDate, Timestamp endDate);
}
