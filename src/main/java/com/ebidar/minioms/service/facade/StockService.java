package com.ebidar.minioms.service.facade;

import com.ebidar.minioms.domain.Stock;
import com.ebidar.minioms.dto.StockDto;

import java.util.Optional;

public interface StockService {

    StockDto save(StockDto stock);

    StockDto update(StockDto stock);

    Optional<Stock> findOptionalEntityByCode(String code);

    Stock findEntityByCode(String code);

    StockDto findByCode(String code);

    void deleteByCode(String code);
}
