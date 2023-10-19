package com.ebidar.minioms.repository.project2;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.project2.Order;
import com.ebidar.minioms.domain.project2.Portfolio;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.enumeration.project2.InstrumentType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends BaseRepository<Portfolio, Long> {

    Optional<Portfolio> findByUserIdAndInstrumentType(String userId, InstrumentType instrumentType);

    List<Portfolio> findAllByUserId(String userId);
}
