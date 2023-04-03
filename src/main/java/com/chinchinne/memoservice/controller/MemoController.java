package com.chinchinne.memoservice.controller;

import com.chinchinne.memoservice.dao.MemoDao;
import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.model.Common;
import com.chinchinne.memoservice.model.MemoDto;
import com.chinchinne.memoservice.repository.MemoRepository;
import com.chinchinne.memoservice.service.MemoService;
import com.chinchinne.memoservice.spec.MemoSpecs;
import com.chinchinne.memoservice.vo.RequestMemo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    MemoRepository memoRepository;

    @Autowired
    public MemoController(MemoDao memoDao, ModelMapper modelMapper, MemoService memoService, MemoRepository memoRepository)
    {
        this.memoDao = memoDao;
        this.modelMapper = modelMapper;
        this.memoService = memoService;
        this.memoRepository = memoRepository;
    }

    @GetMapping("/{userId}/memo")
    public ResponseEntity<List<MemoDto>> getMemo(@PathVariable String userId)
    {
        Optional<List<Memo>> memo = memoRepository.findAll(MemoSpecs.UserId(new UserId(userId)).and(MemoSpecs.DelYn(Common.NO)), Sort.by("memoId").ascending());

        List<MemoDto> res = memo.orElseGet(ArrayList::new).stream().map( m -> modelMapper.map(m, MemoDto.class)).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/{userId}/memo")
    public ResponseEntity<MemoDto> addMemo(@PathVariable String userId, @RequestBody @Valid RequestMemo requestMemo)
    {
        requestMemo.setUserId(userId);

        MemoDto memoDto = modelMapper.map(requestMemo, MemoDto.class);

        MemoDto res = memoService.createMemo(memoDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("/{userId}/memo")
    public ResponseEntity<MemoDto> updateMemo(@PathVariable String userId, @RequestBody @Valid RequestMemo requestMemo)
    {
        requestMemo.setUserId(userId);

        MemoDto memoDto = modelMapper.map(requestMemo, MemoDto.class);

        MemoDto res = memoService.changeMemo(memoDto);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{userId}/memo/complete")
    public ResponseEntity<MemoDto> updateComplete(@PathVariable String userId, @RequestBody RequestMemo requestMemo)
    {
        requestMemo.setUserId(userId);

        MemoDto memoDto = modelMapper.map(requestMemo, MemoDto.class);

        MemoDto res = memoService.changeComplete(memoDto);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{userId}/memo")
    public ResponseEntity<MemoDto> deleteMemo(@PathVariable String userId, @RequestBody RequestMemo requestMemo)
    {
        requestMemo.setUserId(userId);

        MemoDto memoDto = modelMapper.map(requestMemo, MemoDto.class);

        MemoDto res = memoService.removeMemo(memoDto);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
