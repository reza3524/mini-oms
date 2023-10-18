package com.ebidar.minioms.repository;

import com.ebidar.minioms.base.BaseRepository;
import com.ebidar.minioms.domain.Wallet;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends BaseRepository<Wallet, Long> {
}
