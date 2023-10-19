package com.ebidar.minioms.domain.project2;

import com.ebidar.minioms.base.BaseEntity;
import com.ebidar.minioms.enumeration.project2.InstrumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "tbl_portfolio", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "instrument_type"}))
@SequenceGenerator(sequenceName = "TBL_PORTFOLIO_SEQ", name = "id")
public class Portfolio extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 6196562868668446382L;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "instrument_type")
    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;

    @Column(name = "count")
    private Integer count;
}

