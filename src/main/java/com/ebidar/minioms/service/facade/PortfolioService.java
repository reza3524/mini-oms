package com.ebidar.minioms.service.facade;

import com.ebidar.minioms.domain.Portfolio;
import com.ebidar.minioms.dto.PortfolioDto;
import com.ebidar.minioms.enumeration.InstrumentType;

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
