package com.chinchinne.memoservice.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Common implements CodeValue
{
     YES("Y", "예")
    ,NO("N", "아니오");

    private String code;
    private String value;

    @Override
    public String getCode()
    {
        return this.code;
    }

    @Override
    public String getValue()
    {
        return this.value;
    }
}
