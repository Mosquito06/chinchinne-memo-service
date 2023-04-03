package com.chinchinne.memoservice.repository;

import com.chinchinne.memoservice.domain.entity.Memo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface MemoRepository extends Repository<Memo, BigInteger>
{
    Optional<List<Memo>> findAll(Specification<Memo> spec);
    Optional<List<Memo>> findAll(Specification<Memo> spec, Sort sort);
    void save(Memo memo);
}
