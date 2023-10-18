package com.ebidar.minioms.service.facade.project2;

import com.ebidar.minioms.dto.project2.CreditDto;

public interface CreditService {

    CreditDto save(CreditDto credit);

    CreditDto findByUserId(String userId);
}
