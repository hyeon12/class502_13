package exam01;

import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Transactional
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test1(){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update(con -> {
                String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME) " + " VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";
                // ? 부분의 값을 PreparedStatement 로 바인딩 할 수 있음

                PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"SEQ"});
                pstmt.setString(1, "user06@test.org");
                pstmt.setString(2, "123456");
                pstmt.setString(3, "사용자06");

                return pstmt;

        }, keyHolder);

        System.out.println(result);
        // 자동 증감된 키 값을 가져올 때 getKey()
        Number key = keyHolder.getKey(); //반환값 Number - 해당하는 반환값 자료형으로 지정
        long seq = key.longValue();
        System.out.println(seq);
    }
}
