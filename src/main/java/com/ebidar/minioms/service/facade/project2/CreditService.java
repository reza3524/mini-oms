package com.ebidar.minioms.service.facade.project2;

import com.ebidar.minioms.domain.project2.Credit;
import com.ebidar.minioms.dto.project2.CreditDto;
import com.ebidar.minioms.enumeration.PurchaseType;

import java.util.Optional;

public interface CreditService {

    CreditDto save(CreditDto credit);

    Optional<Credit> findOptionalEntityByUserId(String userId);

    Credit findEntityByUserId(String userId);

    CreditDto findByUserId(String userId);

    CreditDto updateAmount(CreditDto credit, PurchaseType type);
}
