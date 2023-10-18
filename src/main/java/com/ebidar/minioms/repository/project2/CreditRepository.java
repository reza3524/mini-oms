package com.ebidar.minioms.repository.project2;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.project2.Credit;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditRepository extends BaseRepository<Credit, Long> {

    Optional<Credit> findByUserId(String userId);
}
