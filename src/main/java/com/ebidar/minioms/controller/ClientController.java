package com.ebidar.minioms.controller;

import com.ebidar.minioms.dto.ClientDto;
import com.ebidar.minioms.mapper.ClientMapper;
import com.ebidar.minioms.service.facade.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;
    private final ClientMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<ClientDto.Transfer> save(@RequestBody @Valid ClientDto.Transfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.save(mapper.toDto(transfer))));
    }

    @PutMapping("v1")
    public ResponseEntity<ClientDto.Transfer> update(@RequestBody @Valid ClientDto.Transfer transfer) {
        return ResponseEntity.ok(mapper.toTransfer(service.update(mapper.toDto(transfer))));
    }

    @GetMapping("v1/{exchangeCode}")
    public ResponseEntity<ClientDto.Transfer> getByExchangeCode(@PathVariable("exchangeCode") String exchangeCode) {
        return ResponseEntity.ok(mapper.toTransfer(service.findByExchangeCode(exchangeCode)));
    }

    @DeleteMapping("v1/{exchangeCode}")
    public ResponseEntity<ClientDto.Transfer> deleteByExchangeCode(@PathVariable("exchangeCode") String exchangeCode) {
        service.deleteByExchangeCode(exchangeCode);
        return ResponseEntity.ok().build();
    }
}
