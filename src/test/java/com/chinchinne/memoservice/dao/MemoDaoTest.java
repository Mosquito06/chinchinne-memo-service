package com.chinchinne.memoservice.dao;

import com.chinchinne.memoservice.annotation.MemoTest;
import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.spec.MemoSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@MemoTest
public class MemoDaoTest
{
    @Autowired
    MemoDao memoDao;

    @Test
    public void getMemoWithSpecTest()
    {
        //Specification<Memo> spec = new UserIdSpec();

        //Optional<List<Memo>> memo =  memoDao.findByUserId(new UserId("967d6988-a1f0-11ed-a8fc-0242ac120002"));
//        Optional<List<Memo>> memo =   memoDao.findAll(MemoSpecs.UserId(new UserId("967d6988-a1f0-11ed-a8fc-0242ac120002")));
//
//        memo.orElseGet(ArrayList::new).forEach( row ->
//        {
//            System.out.println(row.getMemo());
//        });

    }
}
