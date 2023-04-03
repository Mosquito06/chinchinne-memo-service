package com.chinchinne.memoservice.controller;

import com.chinchinne.memoservice.dao.MemoDao;
import com.chinchinne.memoservice.repository.MemoRepository;
import com.chinchinne.memoservice.service.MemoService;
import com.chinchinne.memoservice.vo.RequestMemo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemoController.class)
@AutoConfigureMockMvc
public class MemoControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemoDao memoDao;

    @MockBean
    MemoService memoService;

    @MockBean
    MemoRepository memoRepository;

    @MockBean
    JpaMetamodelMappingContext jpaMetamodelMappingContext;

    ObjectMapper objectMapper = new ObjectMapper();

    // Static 지정했으나, User-service 생성 후 변경 필요
    final String userId = "967d6988-a1f0-11ed-a8fc-0242ac120002";

    @Test
    void getMemoTest() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/" + userId +"/memo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
                //.andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void setMemoTest() throws Exception
    {
        RequestMemo requestMemo = new RequestMemo();
        requestMemo.setMemo("테스트 입니다.");


        mockMvc.perform
                (
                    MockMvcRequestBuilders.post("/" + userId +"/memo")
                                          .contentType(MediaType.APPLICATION_JSON_VALUE)
                                          .content(objectMapper.writeValueAsString(requestMemo))
                )
                .andExpect(status().isCreated());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
        //.andExpect(jsonPath("$", hasSize(2)));
    }


}
