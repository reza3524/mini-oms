package ir.hamrahcard.mancala.service.facade;

import ir.hamrahcard.mancala.domain.Pit;
import ir.hamrahcard.mancala.dto.PitDto;

import java.util.Optional;

public interface PitService {

//    PitDto save(PitDto client);
//
//    PitDto update(PitDto client);
//
//    Optional<Pit> findOptionalEntityByExchangeCode(String exchangeCode);
//
//    Pit findEntityByExchangeCode(String exchangeCode);
//
//    PitDto findByExchangeCode(String exchangeCode);
//
//    void deleteByExchangeCode(String exchangeCode);

    void createGame();

    String showBoard();
}
