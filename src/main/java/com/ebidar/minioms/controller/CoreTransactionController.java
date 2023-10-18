package com.ebidar.minioms.controller;

import com.ebidar.minioms.dto.PurchaseOrderDto;
import com.ebidar.minioms.enumeration.PurchaseStatus;
import com.ebidar.minioms.mapper.PurchaseOrderMapper;
import com.ebidar.minioms.service.facade.PurchaseOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/core-transaction/")
@RequiredArgsConstructor
public class CoreTransactionController {

    private final PurchaseOrderService service;
    private final PurchaseOrderMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<Void> updateStatus(@RequestBody @Valid PurchaseOrderDto.Transfer transfer) {
        service.updateStatus(mapper.toDto(transfer), PurchaseStatus.TRANSACTION_CORE);
        return ResponseEntity.ok().build();
    }
}
