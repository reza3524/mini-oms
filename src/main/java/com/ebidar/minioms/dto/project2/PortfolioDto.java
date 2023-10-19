package com.ebidar.minioms.dto.project2;

import com.ebidar.minioms.base.BaseDto;
import com.ebidar.minioms.base.BaseTransfer;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.enumeration.project2.InstrumentType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Setter
@Accessors(chain = true)
public class PortfolioDto extends BaseDto<Long> {

    @Serial
    private static final long serialVersionUID = 6824425943880407092L;

    private String userId;

    private InstrumentType instrumentType;

    private Integer count;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class PortfolioTransfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = 4444318285009671515L;

        private String userId;
        private InstrumentType instrumentId;
        private Integer count;
    }
}
