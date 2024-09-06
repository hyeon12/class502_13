'use client';
import React, { useEffect, useState, useRef, useCallback } from 'react';
import { produce } from 'immer';
import TodoForm from '../components/TodoForm';
import TodoList from '../components/TodoList';

// 컴포넌트 밖에 있는 함수 -> 한 번 만들어지면 변경X
function func1() {

}

const TodoContainer = () => {
  const [items, setItems] = useState([]);
  const [form, setForm] = useState({});
  const [errors, setErrors] = useState({});

  // 컴포넌트 내부에 있는 함수로, 컴포넌트 로딩될 때마다 변경
  function func2() {

  }

  const titleRef = useRef();

  /*
  useEffect(() => {
    //if (titleRef) {
    //  titleRef.current.focus();
    //}
    console.log('useEffect() 호출');
    return () => {
      console.log('뒷정리 함수 - 2번째부터 처음 호출 - 정리 작업');
    };
  }, [form]);*/

  useEffect(() => {
    if (titleRef) {
      titleRef.current.focus();
    }
  }, [titleRef]);

  const onToggle = useCallback((id) => {
    /*
    const newItems = items.map((item) =>
      id === item.id ? { ...item, done: !item.done } : item,
    );
    setItems(newItems);
  };

  // 기존객체의 불변성을 유지, 새로운 객체를 만들어줘야 변경됨!
  // 즉, 리액트는 주소가 바뀌어야 변경을 감지한다
    */

    setItems(
      produce((draft) => {
        draft
          .filter((item) => item.id === id)
          .forEach((item) => {
            item.done = !item.done;
          });
      }),
    );
  }, []);

  const onRemove = useCallback((id) => {
    // filter 메서드
    setItems((items) => items.filter((item) => item.id !== id));
  }, []);

  const onChange = useCallback((e) => {
    /**
     * 이벤트 객체의 중요한 속성 2가지!
     * e.target - 이벤트가 발생한 요소
     * e.currentTarget - 이벤트가 바인딩된, 실제 부여된 요소
     */

    const name = e.target.name;
    const value = e.target.value;
    setForm((form) => ({ ...form, [name]: value }));
    //setForm({...form, [name] : value});
  }, []);

  const onClick = useCallback((done) => {
    setForm((form) => ({ ...form, done }));
  }, []);

  const onSubmit = useCallback(
    (e) => {
      e.preventDefault(); // 양식 기본 동작 차단

      // 검증 (1)
      const _errors = {};
      let hasErrors = false;

      const requiredFields = {
        title: '제목을 입력하세요',
        content: '내용을 입력하세요',
      };

      // entries : key-value의 쌍
      for (const [field, message] of Object.entries(requiredFields)) {
        if (!form[field] || !form[field].trim()) {
          _errors[field] = _errors[field] ?? []; //없을때는 배열 초기화
          _errors[field].push(message);
          hasErrors = true;
        }
      }

      setErrors(_errors);
      if (hasErrors) {
        //검증실패
        return;
      }

      // 일정 등록 처리 (2)
      const nextId = items ? Math.max(...items.map((item) => item.id)) + 1 : 1;
      setItems((items) => items.concat({ ...form, id: nextId }));

      // 양식 초기화
      setForm({});
      console.log(titleRef);
      titleRef.current.focus();
    },
    [form, items],
  );

  return (
    <>
      <TodoForm
        onSubmit={onSubmit}
        onChange={onChange}
        onClick={onClick}
        form={form}
        titleRef={titleRef}
        errors={errors}
      />
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
    </>
  );
};

export default React.memo(TodoContainer);
