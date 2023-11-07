package ir.hamrahcard.mancala.controller;

import ir.hamrahcard.mancala.dto.PitDto;
import ir.hamrahcard.mancala.mapper.PitMapper;
import ir.hamrahcard.mancala.service.facade.PitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pit")
@RequiredArgsConstructor
public class PitController {

    private final PitService service;
    private final PitMapper mapper;

    @GetMapping("v1/create_game")
    public ResponseEntity<Void> createGame() {
        service.createGame();
        return ResponseEntity.ok().build();
    }

    @GetMapping("v1/show_board")
    public ResponseEntity<String> showBoard() {
        return ResponseEntity.ok(service.showBoard());
    }
}
