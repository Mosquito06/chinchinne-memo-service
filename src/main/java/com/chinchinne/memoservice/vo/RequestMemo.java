package com.chinchinne.memoservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestMemo
{
    private BigInteger memoId;
    private String userId;
    private String memo;
    private String completeYn;
}
