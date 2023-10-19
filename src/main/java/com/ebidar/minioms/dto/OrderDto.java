package com.ebidar.minioms.dto;

import com.ebidar.minioms.base.BaseDto;
import com.ebidar.minioms.base.BaseTransfer;
import com.ebidar.minioms.enumeration.PurchaseType;
import com.ebidar.minioms.enumeration.InstrumentType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.sql.Timestamp;

@Getter
@Setter
@Accessors(chain = true)
public class OrderDto extends BaseDto<Long> {

    @Serial
    private static final long serialVersionUID = -2136303433425239571L;

    private String userId;

    private InstrumentType instrumentType;

    private Integer count;

    private Integer countPrice;

    private PurchaseType type;

    private Timestamp registeredDate;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class OrderTransfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = -7468148336711557272L;

        private String userId;
        private InstrumentType instrumentId;
        private Integer count;
    }
}
