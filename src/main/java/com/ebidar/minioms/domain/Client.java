package com.ebidar.minioms.domain;

import com.ebidar.minioms.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "tbl_client", uniqueConstraints = @UniqueConstraint(columnNames = {"exchange_code"}))
@SequenceGenerator(sequenceName = "TBL_CLIENT_SEQ", name = "id")
public class Client extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -2081679222622884732L;

    @Column(name = "exchange_code", unique = true, nullable = false, updatable = false)
    @NotNull(message = "{err.client.exchange-code.null}")
    private String exchangeCode;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
}
