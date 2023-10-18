package com.ebidar.minioms.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
//TODO Add Audit to Base 18-oct-2023
public class BaseEntity<I extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2505435378398121286L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private I id;

    @Version
    @Column(name = "n_version", nullable = false)
    private Integer version;
}
