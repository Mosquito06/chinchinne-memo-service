package com.chinchinne.memoservice.controller;

import com.chinchinne.memoservice.dao.MemoDao;
import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.model.Common;
import com.chinchinne.memoservice.model.MemoDto;
import com.chinchinne.memoservice.service.MemoService;
import com.chinchinne.memoservice.spec.UserSpecs;
import com.chinchinne.memoservice.vo.RequestMemo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class MemoController
{
    MemoDao memoDao;

    ModelMapper modelMapper;

    MemoService memoService;

    @Autowired
    public MemoController(MemoDao memoDao, ModelMapper modelMapper, MemoService memoService)
    {
        this.memoDao = memoDao;
        this.modelMapper = modelMapper;
        this.memoService = memoService;
    }

    @GetMapping("/{userId}/memo")
    public ResponseEntity<List<MemoDto>> getMemo(@PathVariable String userId)
    {
        Optional<List<Memo>> memo = memoDao.findAll(UserSpecs.UserId(new UserId(userId)).and(UserSpecs.DelYn(Common.NO)));

        List<MemoDto> res = memo.orElseGet(ArrayList::new).stream().map( m -> modelMapper.map(m, MemoDto.class)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/{userId}/memo")
    public ResponseEntity<MemoDto> setMemo(@PathVariable String userId, @RequestBody RequestMemo requestMemo)
    {
        // validation 작성 및 테스트 필요

        requestMemo.setUserId(userId);

        MemoDto memoDto = modelMapper.map(requestMemo, MemoDto.class);

        MemoDto res = memoService.createMemo(memoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
