import styled, { css } from 'styled-components'; //js파일안에 스타일 선언
import { BigButton } from './commons/ButtonsStyle';

const commonStyle = css`
  width: 100%;
`; // 공통 스타일을 변수에 담아 사용 -> 변수사용=${}사용한다!

const OuterBox = styled.div`
  ${commonStyle}
  position: fixed;
  height: 100%;
  left: 0;
  top: 0;
  display: flex;
  align-items: center;
`; // position-좌측상단 기준으로 너비높이 가득 차게 설정
// + flex 이용해서 Formbox 가운데 배치

const FormBox = styled.form`
  width: 420px;
  margin: 0 auto;

  h1 {
    text-align: center;
  }
`;

const InputBox = styled.input`
  ${commonStyle}
  display: block;
  height: 45px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 0 10px;

  & + & {
    margin-top: 5px;
  }
`; //태그함수문법 - 함수명.태그명`스타일(매개변수로 투입)`

const LoginForm = () => {
  return (
    <OuterBox>
      <FormBox autoComplete="off">
        <h1>로그인</h1>

        <InputBox type="text" placeholder="아이디" />
        <InputBox type="password" placeholder="비밀번호" />
        <BigButton type="submit" selected={true}>
          로그인
        </BigButton>
      </FormBox>
    </OuterBox>
  );
};

export default LoginForm;
