package com.ebidar.minioms.controller;

import com.ebidar.minioms.dto.PortfolioDto;
import com.ebidar.minioms.mapper.PortfolioMapper;
import com.ebidar.minioms.service.facade.PortfolioService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService service;
    private final PortfolioMapper mapper;

    @GetMapping("v1/{userId}")
    public ResponseEntity<List<PortfolioDto.PortfolioTransfer>> getAllByUserId(@PathVariable("userId") @NotBlank String userId) {
        return ResponseEntity.ok(mapper.toTransfer(service.findAllByUserId(userId)));
    }
}
