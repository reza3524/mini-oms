package com.ebidar.minioms.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseDto<I extends Serializable> implements Serializable {
}
