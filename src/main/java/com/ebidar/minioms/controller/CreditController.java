package com.ebidar.minioms.controller;

import com.ebidar.minioms.dto.CreditDto;
import com.ebidar.minioms.mapper.CreditMapper;
import com.ebidar.minioms.service.facade.CreditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService service;
    private final CreditMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<CreditDto.CreditTransfer> save(@RequestBody @Valid CreditDto.CreditTransfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.save(mapper.toDto(transfer))));
    }

    @GetMapping("v1/{userId}")
    public ResponseEntity<CreditDto.CreditTransfer> getByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(mapper.toTransfer(service.findByUserId(userId)));
    }
}
