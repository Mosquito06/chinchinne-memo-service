package com.chinchinne.memoservice;

import com.chinchinne.memoservice.annotation.MemoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MemoTest
class MemoServiceApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void DBConnectionTest()
    {
        try
        {
            Connection con = dataSource.getConnection();
            assertNotNull(con);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
