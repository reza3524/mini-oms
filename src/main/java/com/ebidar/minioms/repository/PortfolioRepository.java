package com.ebidar.minioms.repository;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.Portfolio;
import com.ebidar.minioms.enumeration.InstrumentType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends BaseRepository<Portfolio, Long> {

    Optional<Portfolio> findByUserIdAndInstrumentType(String userId, InstrumentType instrumentType);

    List<Portfolio> findAllByUserId(String userId);
}
