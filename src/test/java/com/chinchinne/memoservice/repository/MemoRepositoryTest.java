package com.chinchinne.memoservice.repository;

import com.chinchinne.memoservice.annotation.MemoTest;
import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.model.Common;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MemoTest
public class MemoRepositoryTest
{
//    @BeforeEach
//    public void setUp()
//    {
//
//    }

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void createTest()
    {
        UserId userId = new UserId("967d6988-a1f0-11ed-a8fc-0242ac120002");

        Memo memo = new Memo(userId, "테스트 입니다.", Common.NO, null, Common.NO);

        memoRepository.save(memo);

        System.out.println(memo.getMemoId());

        assertNotNull(memo.getMemoId());
    }

}
