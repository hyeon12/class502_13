import { useState, useRef, useCallback } from 'react';

import AddTodo from '../components/AddTodo';
import TodoList from '../components/TodoList';

const intialValue = [
  { id: 1, title: '할일1', done: true },
  { id: 2, title: '할일2', done: false },
  { id: 3, title: '할일3', done: false },
];

let submitFunc; //함수밖에 있기 때문에, 한번만 정의됨!

const TodoContainer = () => {
  //업데이트 시, 매번 함수 호출(기존날리고,교체!)
  //상태변화
  const [items, setItems] = useState(intialValue);
  const [todo, setTodo] = useState('');
  const [message, setMessage] = useState('');

  let id = useRef(4); //할일 id (추가할때마다 증가됨)

  //할일 등록 처리
  const onSubmit = useCallback(
    //useCallback = 함수 재사용!
    (e) => {
      e.preventDefault();

      if (!todo.trim()) {
        // if(!todo.trim()) : todo 값이 없다면
        setMessage('할일을 입력하세요.');
        return; // 함수 종료 (Submit 종료)
      }

      setItems((prevItems) => {
        return prevItems.concat({
          id: id.current,
          title: todo.trim(), //추가될 때 공백제거(trim)
          done: false,
        });
      });

      id.current++; //렌더링을 계속하기 때문에 useRef-current 써서 값을 증가시킴

      setTodo(''); //페이지가 바뀌면서 빈 항목이 출력되도록! 값만 변경
      setMessage(''); //???..
    },
    [todo],
  );

  console.log('같은 함수 : ?', submitFunc === onSubmit); //기존값과 비교.. false
  submitFunc = onSubmit; //??? 함수객체의 주소값 대입되어... 값이 바뀐다! 매번 정의되기 때문!! -> 함수가 매번 정의되어 데이터가 낭비됨..성능저하 -> 이러한 문제 때문에 Hook을 사용하는것
  //할일 입력시 todo 상태값 변경, onchage**
  const onChange = useCallback((e) => setTodo(e.currentTarget.value), []);

  //할일 목록 완료 여부 토글(true -> false, false -> true)
  const onToggle = useCallback((id) => {
    /*
      const newItems = items.map(
        (
          item, //*map : 새로운 배열객체로 반환값 나옴
        ) => (item.id === id ? { ...item, done: !item.done } : item),
      ); //id가 같지 않으면 3항조건---이해하기..ㅠㅠ 여기에서 item은 ........뭘까..?
      setItems(newItems);
      */

    setItems((prevItems) => {
      return prevItems.map((item) =>
        item.id === id ? { ...item, done: !item.done } : item,
      );
    });
  }, []);

  //할일 목록 제거
  const onRemove = useCallback((id) => {
    /*
    const newItems = items.filter((item) => item.id !== id); //조건식-id가 아닌것만 가져온다!?
    setItems(newItems);
    */

    //useCallback + 함수형 업데이트를 써서 한 번만 만들어지도록!
    setItems((prevItems) => {
      return prevItems.filter((item) => item.id !== id);
    });
  }, []);

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
