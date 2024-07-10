package configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("member")
@Import(DBConfig.class)
public class MvcConfig implements WebMvcConfigurer {//WebMvcConfigurer - 설정 틀이 담긴 인터페이스
    // 기본경로 '/'에서 기본적인 처리 방식에 대한 설정
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // (1)정적 리소스 요청 처리를 설정(html, css 등 요청을 서블릿 컨테이너가 제공하는 방식으로 처리하도록)
        // (2)컨트롤러가 없는 요청 처리(정적 파일/경로)
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //뷰 리졸버 - 출력할 view 객체를 찾아주는 역할
        //스프링 컨트롤러 쪽에서 반환값이 나오게 되면, ".jsp" 쪽으로 들어가 적절한 view 객체 반환
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
