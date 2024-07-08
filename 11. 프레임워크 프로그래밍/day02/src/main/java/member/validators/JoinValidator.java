package member.validators;

import global.validators.Validator;
import member.controllers.RequestJoin;
import member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class JoinValidator implements Validator<RequestJoin> {

    private MemberDao memberDao;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public void check(RequestJoin form) {

    }
}
