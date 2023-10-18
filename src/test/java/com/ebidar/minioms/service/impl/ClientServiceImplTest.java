package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.repository.ClientRepository;
import com.ebidar.minioms.service.impl.factory.ClientFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

public class ClientServiceImplTest extends UnitTest {

    @InjectMocks
    ClientServiceImpl service;
    @Mock
    private ClientRepository repository;

    ClientFactory client = new ClientFactory();

    @Test
    void save_successScenario() {
        Client entity = repository.save(client.getEntity());
        Assertions.assertEquals(entity.getExchangeCode(), client.getEntity().getExchangeCode());
    }

    @Test
    @Transactional
    void saveAll_successScenario() {
        repository.saveAll(List.of(client.getEntity(), new ClientFactory().getEntity()));
    }
}
