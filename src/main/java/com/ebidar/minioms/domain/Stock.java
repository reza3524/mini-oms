package com.ebidar.minioms.domain;

import com.ebidar.minioms.base.BaseEntity;
import com.ebidar.minioms.enumeration.SettlementType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "tbl_stock", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))
public class Stock extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -6421573200025035230L;

    @Column(name = "code", unique = true, nullable = false, updatable = false)
    @NotNull(message = "{err.stock.code.null}")
    private String code;

    @Column(name = "settlement_type")
    @Enumerated(EnumType.STRING)
    private SettlementType settlementType;
}
