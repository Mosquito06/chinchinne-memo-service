package com.chinchinne.memoservice.repository;

import com.chinchinne.memoservice.domain.entity.Memo;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface MemoRepository extends Repository<Memo, BigInteger>
{
    void save(Memo memo);
}
