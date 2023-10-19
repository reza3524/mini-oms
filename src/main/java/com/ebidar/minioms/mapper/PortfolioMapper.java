package com.ebidar.minioms.mapper;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.Portfolio;
import com.ebidar.minioms.dto.PortfolioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PortfolioMapper extends BaseMapper<Portfolio, PortfolioDto, PortfolioDto.PortfolioTransfer> {

    @Override
    @Mapping(source = "instrumentId", target = "instrumentType")
    PortfolioDto toDto(PortfolioDto.PortfolioTransfer transfer);

    @Override
    @Mapping(target = "instrumentId", source = "instrumentType")
    PortfolioDto.PortfolioTransfer toTransfer(PortfolioDto dto);
}
