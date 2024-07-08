package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

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

@ComponentScan(basePackages = "member",
    excludeFilters = @ComponentScan.Filter(type= FilterType.ASPECTJ, pattern = "member..*Dao")
)
public class AppCtx {


}
