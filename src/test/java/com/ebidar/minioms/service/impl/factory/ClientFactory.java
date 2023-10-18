package com.ebidar.minioms.service.impl.factory;

import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.dto.ClientDto;

public class ClientFactory extends AbstractFactory<Client, ClientDto, ClientDto.Transfer> {
    @Override
    public Client getEntity() {
        return new Client()
                .setFirstname(FAKER.name().firstName())
                .setLastname(FAKER.name().lastName())
                .setExchangeCode(getUniqueString());
    }

    @Override
    public ClientDto getDto() {
        return new ClientDto()
                .setFirstname(FAKER.name().firstName())
                .setLastname(FAKER.name().lastName())
                .setExchangeCode(getUniqueString());
    }

    @Override
    public ClientDto.Transfer getTransferDto() {
        return new ClientDto.Transfer()
                .setFirstname(FAKER.name().firstName())
                .setLastname(FAKER.name().lastName())
                .setExchangeCode(getUniqueString());
    }
}
