package com.ebidar.minioms.service.facade;

import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.dto.ClientDto;

import java.util.Optional;

public interface ClientService {

    ClientDto save(ClientDto client);

    ClientDto update(ClientDto client);

    Optional<Client> findOptionalEntityByExchangeCode(String exchangeCode);

    Client findEntityByExchangeCode(String exchangeCode);

    ClientDto findByExchangeCode(String exchangeCode);

    void deleteByExchangeCode(String exchangeCode);
}
