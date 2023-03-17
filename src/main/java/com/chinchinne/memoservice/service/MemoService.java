package com.chinchinne.memoservice.service;

import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.model.Common;
import com.chinchinne.memoservice.model.MemoDto;
import com.chinchinne.memoservice.repository.MemoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class MemoService
{
    MemoRepository memoRepository;

    ModelMapper modelMapper;

    public MemoService(MemoRepository memoRepository, ModelMapper modelMapper)
    {
        this.memoRepository = memoRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public MemoDto createMemo(MemoDto memoDto)
    {
        Memo memo = new Memo(new UserId(memoDto.getUserId()), memoDto.getMemo(), Common.NO, Timestamp.valueOf(LocalDateTime.now()), Common.NO);
        memoRepository.save(memo);

        return modelMapper.map(memo, MemoDto.class);
    }
}
