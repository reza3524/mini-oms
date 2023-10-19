package com.ebidar.minioms.service.impl;

import com.ebidar.minioms.domain.Credit;
import com.ebidar.minioms.dto.CreditDto;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.exception.NotFoundException;
import com.ebidar.minioms.mapper.CreditMapper;
import com.ebidar.minioms.repository.CreditRepository;
import com.ebidar.minioms.service.facade.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private static final Object lock = new Object();

    private final CreditRepository repository;
    private final CreditMapper mapper;

    @Override
    @Transactional
    public CreditDto save(CreditDto credit) {
        return mapper.toDto(repository.save(mapper.toEntity(credit)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Credit> findOptionalEntityByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Credit findEntityByUserId(String userId) {
        return findOptionalEntityByUserId(userId)
                .orElseThrow(() -> new NotFoundException("err.project2.credit.not-found"));
    }

    @Override
    @Transactional(readOnly = true)
    public CreditDto findByUserId(String userId) {
        return mapper.toDto(findEntityByUserId(userId));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CreditDto updateAmount(CreditDto credit, PurchaseType type) {
        synchronized (lock) {
            Credit existEntity = findEntityByUserId(credit.getUserId());
            if (type.equals(PurchaseType.BUY)) {
                existEntity.setAmount(existEntity.getAmount() - credit.getAmount());
            } else {
                existEntity.setAmount(existEntity.getAmount() + credit.getAmount());
            }
            return mapper.toDto(repository.save(existEntity));
        }
    }
}
