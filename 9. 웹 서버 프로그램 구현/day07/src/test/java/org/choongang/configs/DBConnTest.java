package org.choongang.configs;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DBConnTest {

    @Test
    @DisplayName("DB 연결 테스트")
    void dbConnectionTest(){
        //실행 코드 실행 시, 예외가 발생하지 않으면 통과
        assertDoesNotThrow(()->{
            SqlSession session = DBConn.sqlSession();
            System.out.println(session);
        });
    }
}
