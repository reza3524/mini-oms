package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.dto.ClientDto;
import com.ebidar.minioms.exception.BadRequestException;
import com.ebidar.minioms.exception.NotFoundException;
import com.ebidar.minioms.mapper.ClientMapper;
import com.ebidar.minioms.repository.ClientRepository;
import com.ebidar.minioms.service.facade.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
//TODO Use log for tracking services 18-oct-2023
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    @Transactional
    public ClientDto save(ClientDto client) {
        checkExchangeCode(client.getExchangeCode());
        return mapper.toDto(repository.save(mapper.toEntity(client)));
    }

    @Override
    @Transactional
    public ClientDto update(ClientDto client) {
        Client existEntity = findEntityByExchangeCode(client.getExchangeCode());
        existEntity.setFirstname(client.getFirstname());
        existEntity.setLastname(client.getLastname());
        return mapper.toDto(repository.save(existEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findOptionalEntityByExchangeCode(String exchangeCode) {
        return repository.findByExchangeCode(exchangeCode);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findEntityByExchangeCode(String exchangeCode) {
        return findOptionalEntityByExchangeCode(exchangeCode)
                .orElseThrow(() -> new NotFoundException("err.client.exchange-code.not-found"));
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto findByExchangeCode(String exchangeCode) {
        return mapper.toDto(findEntityByExchangeCode(exchangeCode));
    }

    @Override
    @Transactional
    public void deleteByExchangeCode(String exchangeCode) {
        repository.deleteByExchangeCode(exchangeCode);
    }

    private void checkExchangeCode(String exchangeCode) {
        findEntityByExchangeCode(exchangeCode);
    }
}
