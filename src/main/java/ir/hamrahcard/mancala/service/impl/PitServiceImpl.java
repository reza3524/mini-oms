package ir.hamrahcard.mancala.service.impl;

import ir.hamrahcard.mancala.domain.Pit;
import ir.hamrahcard.mancala.dto.PitDto;
import ir.hamrahcard.mancala.enumeration.PitName;
import ir.hamrahcard.mancala.enumeration.PitSide;
import ir.hamrahcard.mancala.exception.NotFoundException;
import ir.hamrahcard.mancala.mapper.PitMapper;
import ir.hamrahcard.mancala.repository.PitRepository;
import ir.hamrahcard.mancala.service.facade.PitService;
import ir.hamrahcard.mancala.util.BoardUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PitServiceImpl implements PitService {

    private static final Integer DEFAULT_SIZE = 6;

    private final PitRepository repository;
    private final PitMapper mapper;

//    @Override
//    @Transactional
//    public PitDto save(PitDto client) {
//        checkExchangeCode(client.getExchangeCode());
//        return mapper.toDto(repository.save(mapper.toEntity(client)));
//    }
//
//    @Override
//    @Transactional
//    public PitDto update(PitDto client) {
//        Pit existEntity = findEntityByExchangeCode(client.getExchangeCode());
//        existEntity.setFirstname(client.getFirstname());
//        existEntity.setLastname(client.getLastname());
//        return mapper.toDto(repository.save(existEntity));
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<Pit> findOptionalEntityByExchangeCode(String exchangeCode) {
//        return repository.findByExchangeCode(exchangeCode);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Pit findEntityByExchangeCode(String exchangeCode) {
//        return findOptionalEntityByExchangeCode(exchangeCode)
//                .orElseThrow(() -> new NotFoundException("err.client.exchange-code.not-found"));
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public PitDto findByExchangeCode(String exchangeCode) {
//        return mapper.toDto(findEntityByExchangeCode(exchangeCode));
//    }
//
//    @Override
//    @Transactional
//    public void deleteByExchangeCode(String exchangeCode) {
//        repository.deleteByExchangeCode(exchangeCode);
//    }

    @Override
    @Transactional
    public void createGame() {
        deleteAll();
        initNewGame();
    }

    @Override
    @Transactional(readOnly = true)
    public String showBoard() {
        String template = BoardUtil.getTemplate();
        List<Integer> pits = repository.findAllByOrderByLocationAsc().stream().map(Pit::getSize).toList();

        return String.format(template
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
                , pits.get(8)
        );
    }

    private void deleteAll() {
        repository.deleteAll();
    }

    private void initNewGame() {
        List<Pit> pits = List.of(
                new Pit(0, DEFAULT_SIZE, PitName.A, PitSide.PLAYER_A, false),
                new Pit(1, DEFAULT_SIZE, PitName.B, PitSide.PLAYER_A, false),
                new Pit(2, DEFAULT_SIZE, PitName.C, PitSide.PLAYER_A, false),
                new Pit(3, DEFAULT_SIZE, PitName.D, PitSide.PLAYER_A, false),
                new Pit(4, DEFAULT_SIZE, PitName.E, PitSide.PLAYER_A, false),
                new Pit(5, DEFAULT_SIZE, PitName.F, PitSide.PLAYER_A, false),
                new Pit(6, 0, PitName.G, PitSide.PLAYER_A, true),
                new Pit(7, DEFAULT_SIZE, PitName.A, PitSide.PLAYER_B, false),
                new Pit(8, DEFAULT_SIZE, PitName.B, PitSide.PLAYER_B, false),
                new Pit(9, DEFAULT_SIZE, PitName.C, PitSide.PLAYER_B, false),
                new Pit(10, DEFAULT_SIZE, PitName.D, PitSide.PLAYER_B, false),
                new Pit(11, DEFAULT_SIZE, PitName.E, PitSide.PLAYER_B, false),
                new Pit(12, DEFAULT_SIZE, PitName.F, PitSide.PLAYER_B, false),
                new Pit(13, 0, PitName.G, PitSide.PLAYER_B, true)
        );
        repository.saveAll(pits);
    }

//    private void checkExchangeCode(String exchangeCode) {
//        findEntityByExchangeCode(exchangeCode);
//    }
}
