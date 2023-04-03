package com.chinchinne.memoservice.domain.entity;

import com.chinchinne.memoservice.domain.value.UserId;
import com.chinchinne.memoservice.model.Common;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

import static java.sql.Timestamp.valueOf;

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

    @Column( name = "MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

    @Embedded
    @AttributeOverrides
    (
        @AttributeOverride( name = "id", column = @Column( name = "MOD_ID"))
    )
    private UserId modId;

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

    public void changeMemo( UserId userId, String memo )
    {
        this.memo = memo;
        this.modDate = valueOf(LocalDateTime.now());
        this.modId = userId;
    }

    public void changeComplete( UserId userId, Common completeYn )
    {
        this.completeYn = completeYn;
        this.modDate = valueOf(LocalDateTime.now());
        this.modId = userId;
    }

    public void removeMemo( UserId userId, Common delYn )
    {
        this.modDate = valueOf(LocalDateTime.now());
        this.modId = userId;
        this.delYn = delYn;
    }
}
