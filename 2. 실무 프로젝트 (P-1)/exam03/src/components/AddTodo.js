import { useEffect } from 'react';
import { MdOutlineAdd } from 'react-icons/md';

const AddTodo = ({ onSubmit, onChange, todo, message }) => {
  //props
  useEffect(() => {
    // componentDidMount(), componentDidUpdate() = todo 값의 변화에 의한 렌더링일때 호출!
    console.log('todo, message 값 변경 - 렌더링 후'); // (2)

    return () => {
      console.log('뒷정리 함수... /update시 호출'); // (1)
    };

  }, [todo, message]); // [...] // 변화 감지 기준

  useEffect(() => {
    console.log('마운트시 한번만 호출'); //componentDidMount()
    // DOMContentLoaded 와 비슷 (동일x)
  }, []); //변화감지기준이 없음!
  /*
  useEffect(() => {
    console.log('message 값 변경'); // componentDidMount(), componentDidUpdate() - message 값의 변화 [변화감지기준 =message]
  }, [message]);
  */
  return (
    <form onSubmit={onSubmit} autoComplete="off">
      <input
        type="text"
        value={todo ?? ''}
        onChange={onChange} //처리는 컨테이너컴포넌트에서 하고, 사용하기 위해 값만 가져온 것!
      />
      <button type="submit">
        <MdOutlineAdd />
      </button>

      {message && <div>{message}</div>}
    </form>
  );
};

export default AddTodo;
