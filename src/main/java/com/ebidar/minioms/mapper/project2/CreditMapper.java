package com.ebidar.minioms.mapper.project2;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.project2.Credit;
import com.ebidar.minioms.dto.project2.CreditDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditMapper extends BaseMapper<Credit, CreditDto, CreditDto.CreditTransfer> {
}
