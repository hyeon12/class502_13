package exam01.member.services;

import exam01.member.dao.MemberDao;
import exam01.member.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class InfoService {
    private MemberDao memberDao;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");

    @Autowired
    public void setMemberDao(Optional<MemberDao> opt) {
        this.memberDao = opt.get();
    }

    @Autowired // DateTimeFormatter @Bean 이 없으면 -> 호출 X
    public void setFormatter(Optional<DateTimeFormatter> opt){
        System.out.println("호출!");// Bean X 상태에서는 호출X
        if(opt.isPresent()) {
            this.formatter = opt.get();
        }else{
            this.formatter = null;
        }
    }

//    @Autowired
//    public void setFormatter(@Nullable DateTimeFormatter formatter){
//        System.out.println("호출!");
//        this.formatter = formatter;
//    }

    public void printList(){
        List<Member> members = memberDao.getList();
        members.forEach(m -> {
            System.out.println(m);
            LocalDateTime regDt = m.getRegDt();
            if (formatter != null) {
                System.out.println(formatter.format(regDt));
            }
        });
    }
}
