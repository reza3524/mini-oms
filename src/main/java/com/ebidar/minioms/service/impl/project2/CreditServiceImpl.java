package com.ebidar.minioms.service.impl.project2;

import com.ebidar.minioms.dto.project2.CreditDto;
import com.ebidar.minioms.exception.NotFoundException;
import com.ebidar.minioms.mapper.project2.CreditMapper;
import com.ebidar.minioms.repository.project2.CreditRepository;
import com.ebidar.minioms.service.facade.project2.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository repository;
    private final CreditMapper mapper;

    @Override
    @Transactional
    public CreditDto save(CreditDto credit) {
        return mapper.toDto(repository.save(mapper.toEntity(credit)));
    }

    @Override
    @Transactional(readOnly = true)
    public CreditDto findByUserId(String userId) {
        return mapper.toDto(repository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("err.project2.credit.not-found")));
    }
}
