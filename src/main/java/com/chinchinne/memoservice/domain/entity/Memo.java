package com.chinchinne.memoservice.domain.entity;

import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.model.Common;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "MEMO")
@Access( AccessType.FIELD )
public class Memo
{
    @Id
    @Column( name = "SEQ" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private BigInteger memoId;

    @Embedded
    private UserId userId;

    @Column( name = "MEMO" )
    private String memo;

    @Column( name = "COMPLETE_YN")
    private Common completeYn;

    @Column( name = "REG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column( name = "DEL_YN")
    private Common delYn;

    public Memo(UserId userId, String memo, Common completeYn, Date regDate, Common delYn)
    {
        this.userId = userId;
        this.memo = memo;
        this.completeYn = completeYn;
        this.regDate = regDate;
        this.delYn = delYn;
    }
}
