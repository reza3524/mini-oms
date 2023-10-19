package com.ebidar.minioms.controller.project2;

import com.ebidar.minioms.dto.project2.OrderDto;
import com.ebidar.minioms.dto.project2.PortfolioDto;
import com.ebidar.minioms.mapper.project2.OrderMapper;
import com.ebidar.minioms.mapper.project2.PortfolioMapper;
import com.ebidar.minioms.service.facade.project2.OrderService;
import com.ebidar.minioms.service.facade.project2.PortfolioService;
import jakarta.validation.Valid;
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
