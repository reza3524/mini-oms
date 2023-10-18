package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Stock;
import com.ebidar.minioms.dto.StockDto;
import com.ebidar.minioms.exception.BadRequestException;
import com.ebidar.minioms.exception.NotFoundException;
import com.ebidar.minioms.mapper.StockMapper;
import com.ebidar.minioms.repository.StockRepository;
import com.ebidar.minioms.service.facade.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
//TODO Use log for tracking services 18-oct-2023
public class StockServiceImpl implements StockService {

    private final StockMapper mapper;
    private final StockRepository repository;

    @Override
    @Transactional
    public StockDto save(StockDto stock) {
        checkCode(stock.getCode());
        return mapper.toDto(repository.save(mapper.toEntity(stock)));
    }

    @Override
    @Transactional
    public StockDto update(StockDto stock) {
        Stock existEntity = findEntityByCode(stock.getCode());
        existEntity.setSettlementType(stock.getSettlementType());
        return mapper.toDto(repository.save(existEntity));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Stock> findOptionalEntityByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    @Transactional(readOnly = true)
    public Stock findEntityByCode(String code) {
        return findOptionalEntityByCode(code)
                .orElseThrow(() -> new NotFoundException("err.stock.code.not-found"));
    }

    @Override
    @Transactional(readOnly = true)
    public StockDto findByCode(String code) {
        return mapper.toDto(findEntityByCode(code));
    }

    @Override
    @Transactional
    public void deleteByCode(String code) {
        repository.deleteByCode(code);
    }

    private void checkCode(String code) {
        findEntityByCode(code);
    }
}
