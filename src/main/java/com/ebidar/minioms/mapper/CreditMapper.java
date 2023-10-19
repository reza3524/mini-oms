package com.ebidar.minioms.mapper;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.Credit;
import com.ebidar.minioms.dto.CreditDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditMapper extends BaseMapper<Credit, CreditDto, CreditDto.CreditTransfer> {
}
