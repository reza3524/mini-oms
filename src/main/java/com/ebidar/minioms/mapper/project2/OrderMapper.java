package com.ebidar.minioms.mapper.project2;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.project2.Order;
import com.ebidar.minioms.dto.project2.OrderDto;
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
