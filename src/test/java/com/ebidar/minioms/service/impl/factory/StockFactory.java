package com.ebidar.minioms.service.impl.factory;

import com.ebidar.minioms.domain.Stock;
import com.ebidar.minioms.dto.StockDto;

public class StockFactory extends AbstractFactory<Stock, StockDto, StockDto.Transfer> {
    @Override
    public Stock getEntity() {
        return new Stock()
                .setCode(FAKER.name().title());
    }

    @Override
    public StockDto getDto() {
        return new StockDto()
                .setCode(FAKER.name().title());
    }

    @Override
    public StockDto.Transfer getTransferDto() {
        return new StockDto.Transfer()
                .setCode(FAKER.name().title());
    }
}
