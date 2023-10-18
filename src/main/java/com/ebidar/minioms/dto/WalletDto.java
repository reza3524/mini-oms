package com.ebidar.minioms.dto;

import com.ebidar.minioms.base.BaseDto;
import com.ebidar.minioms.base.BaseTransfer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Setter
@Accessors(chain = true)
public class WalletDto extends BaseDto<Long> {
    
    @Serial
    private static final long serialVersionUID = 6327365413041870003L;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Transfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = 5361012077188638158L;
    }
}
