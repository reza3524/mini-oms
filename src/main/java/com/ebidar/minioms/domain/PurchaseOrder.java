package com.ebidar.minioms.domain;

import com.ebidar.minioms.base.BaseEntity;
import com.ebidar.minioms.enumeration.PurchaseStatus;
import com.ebidar.minioms.enumeration.PurchaseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "tbl_purchase_order", uniqueConstraints = @UniqueConstraint(columnNames = {"client", "stock"}))
public class PurchaseOrder extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 7896390558307058127L;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PurchaseType type;

    @Column(name = "settlement_date")
    private Timestamp settlementDate;

    @Column(name = "status")
    private PurchaseStatus status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client", referencedColumnName = "exchange_code")
    @NotNull(message = "{err.purchase-order.client.null}")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stock", referencedColumnName = "code")
    @NotNull(message = "{err.purchase-order.stock.null}")
    private Stock stock;
}
