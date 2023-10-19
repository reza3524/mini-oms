package com.ebidar.minioms.domain;


import com.ebidar.minioms.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "tbl_credit", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
@SequenceGenerator(sequenceName = "TBL_CREDIT_SEQ", name = "id")
public class Credit extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -5784315544022582583L;

    @Column(name = "user_id", nullable = false, unique = true)
    @NotBlank(message = "{err.project2.credit.user-id.null}")
    private String userId;

    @Column(name = "amount")
    private Integer amount;
}
