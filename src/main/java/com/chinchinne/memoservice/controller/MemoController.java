package com.chinchinne.memoservice.controller;

import com.chinchinne.memoservice.dao.MemoDao;
import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.spec.UserSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class MemoController
{
    MemoDao memoDao;

    @Autowired
    public MemoController( MemoDao memoDao )
    {
        this.memoDao = memoDao;
    }

    @GetMapping("{userId}/memo")
    public ResponseEntity<List<Memo>> getAccount(@PathVariable String userId)
    {
        Optional<List<Memo>> memo = memoDao.findAll(UserSpecs.UserId(new UserId(userId)));

        return ResponseEntity.status(HttpStatus.OK).body(memo.orElseGet(ArrayList::new));
    }
}
