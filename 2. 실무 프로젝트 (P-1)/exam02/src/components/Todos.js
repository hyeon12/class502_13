import {
  MdOutlineCheckBox,
  MdOutlineCheckBoxOutlineBlank,
} from 'react-icons/md'; 
//react-icons 코드 불러오기! {}안에 , 하고 여러가지 넣기 가능

const items = [
  { id: 1, title: '할일1', done: false },
  { id: 2, title: '할일2', done: true },
  { id: 3, title: '할일3', done: false },
];

const Todos = () => {
  return (
    <ul>
      {items.map(({ id, title, done }) => (
        <li key={id}>
            { done ? <MdOutlineCheckBox /> : <MdOutlineCheckBoxOutlineBlank />}
            {title}
        </li>
      ))}
    </ul>
  );
};

export default Todos;
