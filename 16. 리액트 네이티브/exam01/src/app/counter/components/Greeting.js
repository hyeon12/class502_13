import React from 'react';

const Greeting = ({ name, age, children }) => {
  age = age ?? 20;
  //console.log('props', props);
  //console.log(Object.getOwnPropertyDescriptors(props));
  //console.log('isExtensible', Object.isExtensible(props));
  //console.log('isFrozen', Object.isFrozen(props));
  //props.name = '서이름';
  return (
    <div>
      <h1>{name}님, 안녕하세요.</h1>
      <h1>
        {name}님의 나이는 {age}입니다.
      </h1>
      <div>{children(100)}</div>
      {/*<div>{children}</div>*/}
    </div>
  );
};

Greeting.defaultProps = {
  age: 20,
};

export default Greeting;
