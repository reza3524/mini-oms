package com.ebidar.minioms.mapper;

import com.ebidar.minioms.base.BaseMapper;
import com.ebidar.minioms.domain.PurchaseOrder;
import com.ebidar.minioms.dto.PurchaseOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, StockMapper.class})
public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder, PurchaseOrderDto, PurchaseOrderDto.Transfer> {

    @Override
    @Mapping(source = "clientExchangeCode", target = "client.exchangeCode")
    @Mapping(source = "stockCode", target = "stock.code")
    PurchaseOrderDto toDto(PurchaseOrderDto.Transfer transfer);

    @Override
    @Mapping(target = "clientExchangeCode", source = "client.exchangeCode")
    @Mapping(target = "stockCode", source = "stock.code")
    PurchaseOrderDto.Transfer toTransfer(PurchaseOrderDto dto);
}
