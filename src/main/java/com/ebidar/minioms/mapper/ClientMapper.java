package com.ebidar.minioms.mapper;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends BaseMapper<Client, ClientDto, ClientDto.Transfer> {
}
