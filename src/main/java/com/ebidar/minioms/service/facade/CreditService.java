package com.ebidar.minioms.service.facade;

import com.ebidar.minioms.domain.Credit;
import com.ebidar.minioms.dto.CreditDto;
import com.ebidar.minioms.enumeration.PurchaseType;

import java.util.Optional;

public interface CreditService {

    CreditDto save(CreditDto credit);

    Optional<Credit> findOptionalEntityByUserId(String userId);

    Credit findEntityByUserId(String userId);

    CreditDto findByUserId(String userId);

    CreditDto updateAmount(CreditDto credit, PurchaseType type);
}
