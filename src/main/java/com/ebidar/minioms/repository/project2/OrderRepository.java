package com.ebidar.minioms.repository.project2;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.project2.Credit;
import com.ebidar.minioms.domain.project2.Order;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.enumeration.project2.InstrumentType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

    List<Order> findAllByUserIdAndTypeAndRegisteredDateBetween(String userId, PurchaseType type, Timestamp startDate, Timestamp endDate);
}
