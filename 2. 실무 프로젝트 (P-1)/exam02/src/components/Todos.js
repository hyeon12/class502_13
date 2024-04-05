import { useState } from 'react'; //items 값을 바꿀 수 있도록!
import {
  MdOutlineCheckBox,
  MdOutlineCheckBoxOutlineBlank,
} from 'react-icons/md';
//react-icons 코드 불러오기! {}안에 , 하고 여러가지 넣기 가능

const intialValue = [
  { id: 1, title: '할일1', done: false },
  { id: 2, title: '할일2', done: true },
  { id: 3, title: '할일3', done: false },
];

const Todos = () => { //DOM 선택할 필요 없이 값만 바꿔줌!
  const [items, setItems] = useState(intialValue);

  const onToggle = (id) => {
    const newItems = items.map((item) =>
      item.id === id ? { ...item, done: !item.done } : item, // 조건문 ? T : F
    );

    setItems(newItems);
  };

  return (
    <ul>
      {items.map(({ id, title, done }) => (
        <li key={id} onClick={() => onToggle(id)}>
          {done ? <MdOutlineCheckBox /> : <MdOutlineCheckBoxOutlineBlank />}
          {title}
        </li>
      ))}
    </ul>
  );
};

export default Todos;
