package com.ebidar.minioms.mapper.project2;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.project2.Order;
import com.ebidar.minioms.domain.project2.Portfolio;
import com.ebidar.minioms.dto.project2.OrderDto;
import com.ebidar.minioms.dto.project2.PortfolioDto;
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
