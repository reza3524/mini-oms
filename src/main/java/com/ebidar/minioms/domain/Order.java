package com.ebidar.minioms.domain;

import com.ebidar.minioms.base.BaseEntity;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.enumeration.InstrumentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "tbl_order")
@SequenceGenerator(sequenceName = "TBL_ORDER_SEQ", name = "id")
public class Order extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -738778313283876134L;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "instrument_type")
    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;

    @Column(name = "count")
    private Integer count;

    @Column(name = "count_price")
    private Integer countPrice;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PurchaseType type;

    @Column(name = "registered_date")
    private Timestamp registeredDate;
}

