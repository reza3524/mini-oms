package com.ebidar.minioms.base;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<
        E extends BaseEntity<? extends Serializable>,
        D extends BaseDto<? extends Serializable>,
        T extends BaseTransfer<? extends Serializable>> {

    E toEntity(D dto);

    D toDto(E entity);

    D toDto(T transfer);

    T toTransfer(D dto);
}
