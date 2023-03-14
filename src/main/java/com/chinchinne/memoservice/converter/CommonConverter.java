package com.chinchinne.memoservice.converter;

import com.chinchinne.memoservice.model.Common;

import javax.persistence.Converter;

@Converter( autoApply = true )
public class CommonConverter extends CodeValueConverter<Common>
{
    public CommonConverter()
    {
        super(Common.class);
    }
}
