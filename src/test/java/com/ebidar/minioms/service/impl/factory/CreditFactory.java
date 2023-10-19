package com.ebidar.minioms.service.impl.factory;

import com.ebidar.minioms.domain.Credit;
import com.ebidar.minioms.dto.CreditDto;

public class CreditFactory extends AbstractFactory<Credit, CreditDto, CreditDto.CreditTransfer> {
    @Override
    public Credit getEntity() {
        return new Credit()
                .setUserId(FAKER.name().username())
                .setAmount(randomInt());
    }

    @Override
    public CreditDto getDto() {
        return new CreditDto()
                .setUserId(FAKER.name().username())
                .setAmount(randomInt());
    }

    @Override
    public CreditDto.CreditTransfer getTransferDto() {
        return new CreditDto.CreditTransfer()
                .setUserId(FAKER.name().username())
                .setAmount(randomInt());
    }
}
