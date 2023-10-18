package com.ebidar.minioms.repository;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {

    Optional<Client> findByExchangeCode(String exchangeCode);

    void deleteByExchangeCode(String exchangeCode);
}
