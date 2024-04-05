import { MdOutlineAdd } from 'react-icons/md';

const AddTodo = ({ onSubmit, onChange, todo, message}) => {
  //props
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

      { message && <div>{message}</div>}
    </form>
  );
};

export default AddTodo;
