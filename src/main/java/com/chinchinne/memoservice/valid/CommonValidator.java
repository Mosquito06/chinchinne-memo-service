package com.chinchinne.memoservice.valid;

import com.chinchinne.memoservice.model.Common;
import org.apache.commons.lang.ArrayUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CommonValidator implements ConstraintValidator<CommonValid, String>
{
    private final String[] ALLOW_ARRAY = new String[]{ Common.YES.name(), Common.NO.name() };

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext)
    {
        if (value == null)
        {
            return false;
        }

        if (ArrayUtils.contains(ALLOW_ARRAY, value))
        {
            return true;
        }

        return false;
    }
}
