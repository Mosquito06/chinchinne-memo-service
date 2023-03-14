package com.chinchinne.memoservice.annotation;

import com.chinchinne.memoservice.MemoServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootTest
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
@TestPropertySource(locations="classpath:/application.yml")
@ContextConfiguration( classes = MemoServiceApplication.class)
//@Transactional
public @interface MemoTest
{

}
