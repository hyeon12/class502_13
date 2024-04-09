import React from 'react';

const MessageBox = ({ className, children }) => {
  return (
    <div className={className}>{children}</div> //태그안쪽 children
    //스타일-className 필수 ... className에 스타일을 할당하는것
  );
};

export default React.memo(MessageBox);
