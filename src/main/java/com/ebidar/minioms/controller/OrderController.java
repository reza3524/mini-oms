package com.ebidar.minioms.controller;

import com.ebidar.minioms.dto.OrderDto;
import com.ebidar.minioms.mapper.OrderMapper;
import com.ebidar.minioms.service.facade.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderMapper mapper;

    @PostMapping("v1/buy")
    public ResponseEntity<OrderDto.OrderTransfer> buy(@RequestBody @Valid OrderDto.OrderTransfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.buy(mapper.toDto(transfer))));
    }

    @PostMapping("v1/sell")
    public ResponseEntity<OrderDto.OrderTransfer> sell(@RequestBody @Valid OrderDto.OrderTransfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.sell(mapper.toDto(transfer))));
    }
}
