import React from 'react';
import { IoMdRadioButtonOff, IoMdRadioButtonOn } from 'react-icons/io';
import MessageBox from '../../commons/components/MessageBox';

const TodoForm = ({ onSubmit, onChange, onClick, form, titleRef, errors }) => {
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <dl>
        <dt>할일</dt>
        <dd>
          <input
            type="text"
            name="title"
            value={form?.title ?? ''} //옵셔널 체이닝으로 객체/속성이 존재X -> 에러방지, undefied 반환
            onChange={onChange}
            ref={titleRef} //DOM 조작이 필요할때 ref 속성 사용
          />
          {errors?.title && <MessageBox>{errors.title}</MessageBox>}
        </dd>
      </dl>
      <dl>
        <dt>내용</dt>
        <dd>
          <textarea
            name="content"
            value={form?.content ?? ''}
            onChange={onChange}
          ></textarea>
          {errors?.content && <MessageBox>{errors.content}</MessageBox>}
        </dd>
      </dl>
      <dl>
        <dt>완료여부</dt>
        <dd>
          <span onClick={() => onClick(true)}>
            {form?.done ? <IoMdRadioButtonOn /> : <IoMdRadioButtonOff />}
            완료
          </span>
          <span onClick={() => onClick(false)}>
            {!form?.done ? <IoMdRadioButtonOn /> : <IoMdRadioButtonOff />}
            비완료
          </span>
        </dd>
      </dl>
      <button type="submit">할일 등록</button>
    </form>
  );
};

export default React.memo(TodoForm);
