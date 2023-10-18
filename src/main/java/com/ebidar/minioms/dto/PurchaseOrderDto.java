package com.ebidar.minioms.dto;

import com.ebidar.minioms.base.BaseDto;
import com.ebidar.minioms.base.BaseTransfer;
import com.ebidar.minioms.domain.Client;
import com.ebidar.minioms.domain.Stock;
import com.ebidar.minioms.enumeration.PurchaseStatus;
import com.ebidar.minioms.enumeration.PurchaseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class PurchaseOrderDto extends BaseDto<Long> {
    
    @Serial
    private static final long serialVersionUID = 6327365413041870003L;

    private Integer count;

    private BigDecimal price;

    private PurchaseType type;

    private PurchaseStatus status;

    @NotNull(message = "{err.purchase-order.client.null}")
    private ClientDto client;

    @NotNull(message = "{err.purchase-order.stock.null}")
    private StockDto stock;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Transfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = 5361012077188638158L;

        private Integer count;
        private BigDecimal price;
        private PurchaseType type;
        private PurchaseStatus status;
        @NotNull(message = "{err.purchase-order.client.null}")
        private String clientExchangeCode;
        @NotNull(message = "{err.purchase-order.stock.null}")
        private String stockCode;
    }
}
