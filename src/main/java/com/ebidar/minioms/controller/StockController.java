package com.ebidar.minioms.controller;

import com.ebidar.minioms.dto.StockDto;
import com.ebidar.minioms.mapper.StockMapper;
import com.ebidar.minioms.service.facade.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService service;
    private final StockMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<StockDto.Transfer> save(@RequestBody @Valid StockDto.Transfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.save(mapper.toDto(transfer))));
    }

    @PutMapping("v1")
    public ResponseEntity<StockDto.Transfer> update(@RequestBody @Valid StockDto.Transfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.update(mapper.toDto(transfer))));
    }

    @GetMapping("v1/{code}")
    public ResponseEntity<StockDto.Transfer> getByExchangeCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(mapper.toTransfer(service.findByCode(code)));
    }

    @DeleteMapping("v1/{code}")
    public ResponseEntity<StockDto.Transfer> deleteByExchangeCode(@PathVariable("code") String code) {
        service.findByCode(code);
        return ResponseEntity.ok().build();
    }
}
