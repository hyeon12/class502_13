import React, { useState, useCallback, useMemo } from 'react';

function getAverage(nums) {
  console.log('getAverage 함수 호출');
  // 평균 - 합계 / 갯수

  const total = nums.reduce((acc, num) => {
    //첫번째 매개변수(acc)=반환값이 누적된 값
    acc += num;

    return acc;
  }, 0); //0으로 초기값 넣어줌...

  let avg = total / nums.length;
  avg = Math.round(avg * 10) / 10; //소수점 첫째자리까지 표기(반올림)

  return avg;
}

const Average = () => {
  const [nums, setNums] = useState([]);
  const [num, setNum] = useState('');

  const onChange = useCallback(
    (e) =>
      setNum(
        Number(e.currentTarget.value) !== NaN
          ? Number(e.currentTarget.value)
          : 0,
      ),
    [],
  );
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      setNums((nums) => nums.concat(num));
    },
    [num],
  );

 // const avg = getAverage(nums); // 입력중에도 계속 호출됨...nums의 값이 변경될때만 호출될 필요 => 이때 useMemo 사용

 const avg = useMemo(() => getAverage(nums), [nums]); //기준값=nums값이 변경될때만 호출
  return (
    <>
      <form autoComplete="off" onSubmit={onSubmit}>
        <input type="number" value={num} onChange={onChange} />
        <button type="submit">등록</button>
      </form>
      <ul>
        {nums.map((num, i) => (
          <li key={i}>{num}</li>
        ))}
      </ul>
      평균 : {avg}
    </>
  );
};
export default React.memo(Average);
