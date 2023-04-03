package com.chinchinne.memoservice.vo;

import com.chinchinne.memoservice.valid.CommonValid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestMemo
{
    private BigInteger memoId;
    private String userId;

    @NotEmpty
    private String memo;

    //@CommonValid
    private String completeYn;
}
