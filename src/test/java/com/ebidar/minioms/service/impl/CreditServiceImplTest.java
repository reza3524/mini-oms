package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Credit;
import com.ebidar.minioms.repository.CreditRepository;
import com.ebidar.minioms.service.impl.factory.CreditFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

public class CreditServiceImplTest extends UnitTest {

    @InjectMocks
    CreditServiceImpl service;
    @Mock
    private CreditRepository repository;

    CreditFactory client = new CreditFactory();

    @Test
    void save_successScenario() {
        Credit entity = repository.save(client.getEntity());
        Assertions.assertEquals(entity.getUserId(), client.getEntity().getUserId());
    }

    @Test
    @Transactional
    void saveAll_successScenario() {
        repository.saveAll(List.of(client.getEntity(), new CreditFactory().getEntity()));
    }
}
