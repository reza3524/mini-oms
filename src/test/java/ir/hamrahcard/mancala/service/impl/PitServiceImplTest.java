package ir.hamrahcard.mancala.service.impl;

import ir.hamrahcard.mancala.domain.Pit;
import ir.hamrahcard.mancala.repository.PitRepository;
import ir.hamrahcard.mancala.service.impl.factory.ClientFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

public class PitServiceImplTest extends UnitTest {

    @InjectMocks
    PitServiceImpl service;
    @Mock
    private PitRepository repository;

    ClientFactory client = new ClientFactory();

    @Test
    void save_successScenario() {
        Pit entity = repository.save(client.getEntity());
        Assertions.assertEquals(entity.getExchangeCode(), client.getEntity().getExchangeCode());
    }

    @Test
    @Transactional
    void saveAll_successScenario() {
        repository.saveAll(List.of(client.getEntity(), new ClientFactory().getEntity()));
    }
}
