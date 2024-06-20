package org.choongang.global.configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//DB 설정파일
public class DBConn {
    private static SqlSessionFactory factory;

    static{
        try {
            //지정된 경로에 있는 xml 파일 읽어들이는 Reader 객체
            Reader reader = Resources.getResourceAsReader("org/choongang/global/configs/mybatis-config.xml");

            factory = new SqlSessionFactoryBuilder().build(reader);
            //SqlSessionFactoryBuilder - 데이터베이스와의 세션을 관리하며,
            //MyBatis 에서 SQL 세션을 실행하고 데이터베이스와의 연결을 관리하는 핵심 객체

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSession getSession(boolean autoCommit){
        //환경변수 가져오는..! System.getenv()
        //mode가 test이면 false로 바꿔주는 로직
        String mode = System.getenv("mode");
        if(mode != null && mode.equals("test")) autoCommit = false;

        return factory.openSession(autoCommit);
    }

    public static SqlSession getSession(){
        return getSession(true);
    }
}
