package configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    private static SqlSessionFactory factory;

    //클래스만 로드되더라도, 바로 사용가능(정적로딩)
    static {
        try {
            Reader reader = Resources.getResourceAsReader("configs/mybatis-config.xml");
            //맵에서 정보 읽어오도록 리소스 폴더 기준에서 경로 작성! IOException 발생가능
            factory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    //커밋을 수동관리하기위해, 매개변수에 투입 - 필요에 따라 true(자동커밋)/false(수동커밋) 로 변경
    public static SqlSession getSession(boolean autoCommit){
        return factory.openSession(autoCommit);
    }

    public static SqlSession getSession(){
        return getSession(true);
    }
}
