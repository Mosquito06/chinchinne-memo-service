package com.chinchinne.memoservice.service;

import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.exception.CustomException;
import com.chinchinne.memoservice.model.Common;
import com.chinchinne.memoservice.model.ErrorCode;
import com.chinchinne.memoservice.model.MemoDto;
import com.chinchinne.memoservice.repository.MemoRepository;
import com.chinchinne.memoservice.spec.MemoSpecs;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

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

    @Transactional
    public MemoDto changeMemo(MemoDto memoDto)
    {
        List<Memo> memos = memoRepository.findAll(MemoSpecs.MemoId(memoDto.getMemoId()).and(MemoSpecs.DelYn(Common.NO)))
                                         .orElseGet(ArrayList::new);

        if( memos.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        Memo memo = memos.get(0);
        memo.changeMemo
        (
             new UserId(memoDto.getUserId())
            ,memoDto.getMemo()
        );

        return modelMapper.map(memo, MemoDto.class);
    }

    @Transactional
    public MemoDto changeComplete(MemoDto memoDto)
    {
        List<Memo> memos = memoRepository.findAll(MemoSpecs.MemoId(memoDto.getMemoId()).and(MemoSpecs.DelYn(Common.NO)))
                                         .orElseGet(ArrayList::new);

        if( memos.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        Memo memo = memos.get(0);
        memo.changeComplete
        (
             new UserId(memoDto.getUserId())
            ,memoDto.getCompleteYn()
        );

        return modelMapper.map(memo, MemoDto.class);
    }

    @Transactional
    public MemoDto removeMemo(MemoDto memoDto)
    {
        List<Memo> memos = memoRepository.findAll(MemoSpecs.MemoId(memoDto.getMemoId()).and(MemoSpecs.DelYn(Common.NO)))
                                         .orElseGet(ArrayList::new);

        if( memos.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        Memo memo = memos.get(0);
        memo.removeMemo
        (
             new UserId(memoDto.getUserId())
            ,Common.YES
        );

        return modelMapper.map(memo, MemoDto.class);
    }
}
