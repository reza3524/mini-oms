package com.ebidar.minioms.domain;

import com.ebidar.minioms.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "tbl_wallet")
public class Wallet extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -892371409843550533L;

    private BigDecimal buyingPowerT0;

    private BigDecimal buyingPowerT1;

    private BigDecimal buyingPowerT2;

    private BigDecimal buyingPowerT3;

    private Client client;
}
