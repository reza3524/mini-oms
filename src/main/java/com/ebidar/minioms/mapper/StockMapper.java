package com.ebidar.minioms.mapper;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.Stock;
import com.ebidar.minioms.dto.StockDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper extends BaseMapper<Stock, StockDto, StockDto.Transfer> {
}
