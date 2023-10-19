package com.ebidar.minioms.mapper;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.Order;
import com.ebidar.minioms.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<Order, OrderDto, OrderDto.OrderTransfer> {

    @Override
    @Mapping(source = "instrumentId", target = "instrumentType")
    OrderDto toDto(OrderDto.OrderTransfer transfer);

    @Override
    @Mapping(target = "instrumentId", source = "instrumentType")
    OrderDto.OrderTransfer toTransfer(OrderDto dto);
}
