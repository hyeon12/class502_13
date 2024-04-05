import { useState, useRef } from 'react';

import AddTodo from '../components/AddTodo';
import TodoList from '../components/TodoList';

const intialValue = [
  { id: 1, title: '할일1', done: true },
  { id: 2, title: '할일2', done: false },
  { id: 3, title: '할일3', done: false },
];

const TodoContainer = () => {
  //상태변화
  const [items, setItems] = useState(intialValue);
  const [todo, setTodo] = useState('');
  const [message, setMessage] = useState('');

  let id = useRef(4); //할일 id (추가할때마다 증가됨)

  //할일 등록 처리
  const onSubmit = (e) => {
    e.preventDefault();

    if (!todo.trim()) {
      // if(!todo.trim()) : todo 값이 없다면
      setMessage('할일을 입력하세요.');
      return; // 함수 종료 (Submit 종료)
    }

    const newItems = items.concat({
      //배열메서드(기존주소값으로 감지x), concat(새로운 배열/주소값)
      id: id.current,
      title: todo.trim(), //추가될 때 공백제거(trim)
      done: false,
    });

    setItems(newItems);

    id.current++; //렌더링을 계속하기 때문에 useRef-current 써서 값을 증가시킴

    setTodo(''); //페이지가 바뀌면서 빈 항목이 출력되도록! 값만 변경
    setMessage(''); //???..
  };

  //할일 입력시 todo 상태값 변경, onchage**
  const onChange = (e) => setTodo(e.currentTarget.value);

  //할일 목록 완료 여부 토글(true -> false, false -> true)
  const onToggle = (id) => {
    const newItems = items.map((item) => //*map : 새로운 배열객체로 반환값 나옴
      item.id === id ? { ...item, done: !item.done } : item,
    ); //id가 같지 않으면 3항조건---이해하기..ㅠㅠ 여기에서 item은 ........뭘까..?
    setItems(newItems);
  };

  //할일 목록 제거
  const onRemove = (id) => {
    const newItems = items.filter((item) => item.id !== id); //조건식-id가 아닌것만 가져온다!?
    setItems(newItems);
  };

  return (
    <>
      <AddTodo
        onSubmit={onSubmit} //{}:props, 기능을 정의했던 부분을 props 통해 넘김
        onChange={onChange}
        todo={todo}
        message={message}
      />
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
    </>
  );
};

export default TodoContainer;
