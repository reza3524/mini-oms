package com.ebidar.minioms.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
public class ApiError {

    private HttpStatus status;
    private String message;
    @JsonIgnore
    private Object[] parameters;
}
