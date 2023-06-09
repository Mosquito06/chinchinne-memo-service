package com.chinchinne.memoservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MemoServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MemoServiceApplication.class, args);
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper();
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

}
