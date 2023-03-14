package com.chinchinne.memoservice.spec;

import com.chinchinne.memoservice.domain.entity.Memo;
import com.chinchinne.memoservice.domain.value.UserId;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecs
{
    public static Specification<Memo> UserId(UserId userId)
    {
        return (root, query, builder) -> builder.equal(root.get("userId").get("id"), userId.getId());
    }

}

