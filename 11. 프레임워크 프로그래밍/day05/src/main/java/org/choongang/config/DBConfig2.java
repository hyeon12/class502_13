package org.choongang.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Slf4j
@Configuration
public class DBConfig2 {
    //설정 클래스를 정적 내부 클래스로도 설정 가능하다 "static" 키워드

    @Profile("dev") //환경변수가 dev이면 DBConfigDev 생성
    @Configuration
    @EnableTransactionManagement
    @MapperScan("org.choongang.member.mappers")
    @EnableJdbcRepositories("org.choongang")
    static class DBConfigDev extends AbstractJdbcConfiguration {
        @Bean(destroyMethod = "close") //스프링 컨테이너가 종료될 때, close() 메서드 호출
        public DataSource dataSource(){//tomcat 쪽 DataSource
            log.info("dev 프로파일!");
            DataSource ds = new DataSource();

            /* 연결 설정 S */
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            ds.setUsername("SPRING");
            ds.setPassword("oracle");
            /* 연결 설정 E */

            /* 커넥션 풀 설정 S */
            ds.setInitialSize(2);
            ds.setMaxActive(10); // 최대 활성화 개수
            ds.setTestWhileIdle(true); // 연결 유효성 검사
            ds.setMinEvictableIdleTimeMillis(1000 * 60); // 기본 설정값 1분 (없으면 기본 값으로)
            ds.setTimeBetweenEvictionRunsMillis(1000 * 5); // 기본 설정값 5초 (없으면 기본 값으로)
            /* 커넥션 풀 설정 E */

            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory()throws Exception{
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());
            return factoryBean.getObject();//getObject() : SqlSessionFactory 객체 반환
        }

        @Bean
        public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource){
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }

    @Profile("prod") //환경변수가 prod이면 DBConfigProd 생성
    @Configuration
    @EnableTransactionManagement
    @MapperScan("org.choongang.member.mappers")
    @EnableJdbcRepositories("org.choongang")
    static class DBConfigProd extends AbstractJdbcConfiguration {

        @Bean(destroyMethod = "close") //스프링 컨테이너가 종료될 때, close() 메서드 호출
        public DataSource dataSource(){//tomcat 쪽 DataSource
            log.info("prod 프로파일!");
            DataSource ds = new DataSource();

            /* 연결 설정 S */
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            ds.setUsername("SPRING");
            ds.setPassword("oracle");
            /* 연결 설정 E */

            /* 커넥션 풀 설정 S */
            ds.setInitialSize(2);
            ds.setMaxActive(10); // 최대 활성화 개수
            ds.setTestWhileIdle(true); // 연결 유효성 검사
            ds.setMinEvictableIdleTimeMillis(1000 * 60); // 기본 설정값 1분 (없으면 기본 값으로)
            ds.setTimeBetweenEvictionRunsMillis(1000 * 5); // 기본 설정값 5초 (없으면 기본 값으로)
            /* 커넥션 풀 설정 E */

            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public PlatformTransactionManager transactionManager(){
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory()throws Exception{
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());
            return factoryBean.getObject();//getObject() : SqlSessionFactory 객체 반환
        }

        @Bean
        public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource){
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }

}
