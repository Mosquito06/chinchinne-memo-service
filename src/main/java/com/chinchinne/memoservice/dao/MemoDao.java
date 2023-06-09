package com.chinchinne.memoservice.dao;

import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

// mapper, respository 겸용으로 사용
@Mapper
public interface MemoDao extends Repository<Memo, BigInteger>
{
    Optional<List<Memo>> findByUserId(UserId userId);

}