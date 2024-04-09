import styled, { css } from 'styled-components';

export const BigButton = styled.button`
  width: 100%;
  height: 45px;
  border: 0;
  font-size: 1.5rem;
  font-weight: bold;
  background: ${({ bgcolor }) => bgcolor ?? 'orange'};

  ${({ selected, bgcolor }) =>
    selected &&
    css`
      border: 1px solid ${bgcolor ?? 'orange'};
      background: #fff;
    `}
`; 
//styled.button의 매개변수로 함수를 가지고 옴.
//조건식 필요할때, 삼항조건/&& 많이 사용됨.
//추가할 속성 많을 때, css`` 사용해서 속성값 구현

// ${(props) => props.bgcolor ?? 'orange;}를 비구조화할당
