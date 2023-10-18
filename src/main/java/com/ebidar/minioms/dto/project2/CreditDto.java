package com.ebidar.minioms.dto.project2;

import com.ebidar.minioms.base.BaseDto;
import com.ebidar.minioms.base.BaseTransfer;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class CreditDto extends BaseDto<Long> {

    @Serial
    private static final long serialVersionUID = 2027115178487241783L;

    @NotBlank(message = "{err.project2.credit.user-id.null}")
    private String userId;

    private BigDecimal amount;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class CreditTransfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = 2855928466053890728L;

        @NotBlank(message = "{err.project2.credit.user-id.null}")
        private String userId;
        private BigDecimal amount;
    }
}
