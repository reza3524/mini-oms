package ir.hamrahcard.mancala.dto;

import ir.hamrahcard.mancala.base.BaseDto;
import ir.hamrahcard.mancala.base.BaseTransfer;
import ir.hamrahcard.mancala.enumeration.PitName;
import ir.hamrahcard.mancala.enumeration.PitSide;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Setter
@Accessors(chain = true)
public class PitDto extends BaseDto<Long> {

    @Serial
    private static final long serialVersionUID = 6327365413041870003L;

    @Min(value = 0)
    @Max(value = 13)
    private Integer location;

    @Min(value = 0)
    @Max(value = 72)
    private Integer size;

    private PitName name;

    private PitSide side;

    private boolean isMain;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Transfer extends BaseTransfer<Long> {

        @Serial
        private static final long serialVersionUID = 5361012077188638158L;

        @Min(value = 0)
        @Max(value = 13)
        private Integer location;
        @Min(value = 0)
        @Max(value = 72)
        private Integer size;
        private PitName name;
        private PitSide side;
        private boolean isMain;
    }
}
