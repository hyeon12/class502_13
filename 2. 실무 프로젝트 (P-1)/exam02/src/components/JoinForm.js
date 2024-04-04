import { useState, useEffect, useRef } from 'react'; //상태값 변경될때마다 값 입력

const JoinForm = () => {
  const [form, setForm] = useState({});

  let userIdEl = useRef();

  useEffect(() => {
    //userIdEl.focus();
    //console.log(userIdEl.current);
    //userIdEl.current.focus(); // 객체의 current 값을 이용해 접근(focus 적용)
    console.log(userIdEl.current);
  }, [userIdEl]);

  const onChange = (e) => {
    //setForm({...form, [e.currentTarget.name]: e.currentTarget.value});
    //변화감지를 통해 페이지를 로딩! 아래의 함수형 업데이트로도 가능하다!
    const name = e.currentTarget.name;
    const value = e.currentTarget.value;
    setForm((prevForm) => ({ ...prevForm, [name]: value }));
    //함수형 업데이트의 매개변수 = 직전 함수
  };

  const onSubmit = (e) => {
    e.preventDefault(); //기본동작 차단
    //처리 완료

    //양식 값을 비워주기
    setForm({});
  };

  return (
    <form onSubmit={onSubmit}>
      <dl>
        <dt>아이디</dt>
        <dd>
          <input
            type="text"
            name="userId"
            onChange={onChange}
            value={form.userId ?? ''} //값을 모아줌
            //ref={(ref) => (userIdEl = ref )}
            ref={userIdEl}
          />
        </dd>
      </dl>
      <dl>
        <dt>비밀번호</dt>
        <dd>
          <input
            type="password"
            name="userPw"
            onChange={onChange}
            value={form.userPw ?? ''}
          />
        </dd>
      </dl>
      <dl>
        <dt>비밀번호 확인</dt>
        <dd>
          <input
            type="password"
            name="confirmPw"
            onChange={onChange}
            value={form.confirmPw ?? ''}
          />
        </dd>
      </dl>
      <dl>
        <dt>회원명</dt>
        <dd>
          <input
            type="text"
            name="userNm"
            onChange={onChange}
            value={form.userNm ?? ''}
          />
        </dd>
      </dl>
      <button type="submit">가입하기</button>
    </form>
  );
};

export default JoinForm;
