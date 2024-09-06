import React from 'react';
import { IoMdRadioButtonOff, IoMdRadioButtonOn } from 'react-icons/io';
import classNames from 'classnames/bind';
import MessageBox from '../../commons/components/MessageBox';
import styles from '../todo.module.scss';

const cx = classNames.bind(styles);

const TodoForm = ({ onSubmit, onChange, onClick, form, titleRef, errors }) => {
  const active = true;
  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <button type="button" className={cx({ on: active })}>
        클릭
      </button>

      <dl className={styles.item}>
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
