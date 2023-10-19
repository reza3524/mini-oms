package com.ebidar.minioms.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InstrumentType {
    FMELI(17),
    VBANK(99),
    DALBORZ(25);

    private final Integer price;
}
