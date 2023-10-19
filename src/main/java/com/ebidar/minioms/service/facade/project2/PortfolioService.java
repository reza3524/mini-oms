package com.ebidar.minioms.service.facade.project2;

import com.ebidar.minioms.domain.project2.Portfolio;
import com.ebidar.minioms.dto.project2.OrderDto;
import com.ebidar.minioms.dto.project2.PortfolioDto;
import com.ebidar.minioms.enumeration.project2.InstrumentType;

import java.util.List;
import java.util.Optional;

public interface PortfolioService {
    Optional<Portfolio> findOptionalEntityByUserIdAndInstrumentType(String userId, InstrumentType instrumentType);

    Portfolio findEntityByUserIdAndInstrumentType(String userId, InstrumentType instrumentType);

    PortfolioDto findByUserIdAndInstrumentType(String userId, InstrumentType instrumentType);

    List<PortfolioDto> findAllByUserId(String userId);

    PortfolioDto handleBuyPortfolio(PortfolioDto portfolio);

    PortfolioDto handleSellPortfolio(PortfolioDto portfolio);
}
