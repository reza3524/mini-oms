package ir.hamrahcard.mancala.domain;

import ir.hamrahcard.mancala.base.BaseEntity;
import ir.hamrahcard.mancala.enumeration.PitName;
import ir.hamrahcard.mancala.enumeration.PitSide;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "tbl_pit")
@SequenceGenerator(sequenceName = "TBL_PIT_SEQ", name = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Pit extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -2081679222622884732L;

    @Column(name = "location")
    @Min(value = 0)
    @Max(value = 13)
    private Integer location;

    @Column(name = "size")
    @Min(value = 0)
    @Max(value = 72)
    private Integer size;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private PitName name;

    @Column(name = "side")
    @Enumerated(EnumType.STRING)
    private PitSide side;

    @Column(name = "is_main")
    private boolean isMain;
}
