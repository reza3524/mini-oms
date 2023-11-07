package ir.hamrahcard.mancala.repository;

import ir.hamrahcard.mancala.base.BaseRepository;
import ir.hamrahcard.mancala.domain.Pit;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PitRepository extends BaseRepository<Pit, Long> {

    List<Pit> findAllByOrderByLocationAsc();
}
