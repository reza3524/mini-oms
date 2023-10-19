package com.ebidar.minioms.controller.project2;

import com.ebidar.minioms.dto.project2.OrderDto;
import com.ebidar.minioms.mapper.project2.OrderMapper;
import com.ebidar.minioms.mapper.project2.OrderMapper;
import com.ebidar.minioms.service.facade.project2.OrderService;
import com.ebidar.minioms.service.facade.project2.OrderService;
import jakarta.persistence.criteria.Order;
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
