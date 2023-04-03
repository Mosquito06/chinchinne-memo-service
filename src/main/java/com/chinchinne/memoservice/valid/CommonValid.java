package com.chinchinne.memoservice.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention( RetentionPolicy.RUNTIME )
@Constraint( validatedBy = CommonValidator.class )
public @interface CommonValid
{
    String message() default "올바르지 않은 타입입니다(YES or NO)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
