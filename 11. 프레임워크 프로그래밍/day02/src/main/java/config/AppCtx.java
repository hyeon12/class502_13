package config;

import board.services.BoardService;
import board.services.BoardService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
/*@ComponentScan(basePackages="member",
    excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes= ManualBean.class)
    )
//ManualBean 애노테이션이 포함되어있는 클래스의 경우 배제됨.
*/

/*
@ComponentScan(basePackages = "member",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class, JoinValidator.class}))
//클래스 명을 명시함으로써 해당 클래스를 배제할 수도 있다~!
*/

/*
@ComponentScan(basePackages = "member",
    excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
    pattern="member\\.dao.*Dao")
)
 */
/*
@ComponentScan(basePackages = {"member", "board"},
    excludeFilters = @ComponentScan.Filter(type= FilterType.ASPECTJ, pattern = "member..*Dao")
)*/
@ComponentScan(basePackages = {"member", "board"})
public class AppCtx {

    //외부 클래스 - 수동 등록 해야함.
    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BoardService2 boardService2(){
        return new BoardService2();
    }

}
