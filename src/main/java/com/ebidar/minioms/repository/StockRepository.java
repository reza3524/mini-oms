package com.ebidar.minioms.repository;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.Stock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends BaseRepository<Stock, Long> {

    Optional<Stock> findByCode(String code);

    void deleteByCode(String code);
}
