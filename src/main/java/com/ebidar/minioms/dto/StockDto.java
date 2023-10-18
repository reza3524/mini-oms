package com.ebidar.minioms.dto;

import com.ebidar.minioms.base.BaseDto;
import com.ebidar.minioms.base.BaseTransfer;
import com.ebidar.minioms.enumeration.SettlementType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
public class StockDto extends BaseDto<Long> {
    
    @Serial
    private static final long serialVersionUID = 6327365413041870003L;

    @NotNull(message = "{err.stock.code.null}")
    private String code;

    private SettlementType settlementType;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Transfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = 5361012077188638158L;

        @NotNull(message = "{err.stock.code.null}")
        private String code;
        private SettlementType settlementType;
    }
}
