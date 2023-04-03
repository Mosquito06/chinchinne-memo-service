package com.chinchinne.memoservice.exception;

import com.chinchinne.memoservice.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException
{
    private final ErrorCode errorCode;
}
