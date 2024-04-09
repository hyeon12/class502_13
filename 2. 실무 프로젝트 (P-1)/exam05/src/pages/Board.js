import React from 'react';
import { useParams, useLocation, useSearchParams } from 'react-router-dom';

const posts = {
  post1: {
    subject: '게시글1번',
    content: '게시글1번 내용',
  },
  post2: {
    subject: '게시글2번',
    content: '게시글2번 내용',
  },
};

const Board = () => {
  const { id } = useParams(); // 경로변수... 비구조화할당
  const data = posts[`post${id}`]; //해당데이터 가져옴

  //const [searchParams, setSearchParams] = useSearchParams();
  //console.log(searchParams.get('key1'));
  //setSearchParams('k1=v1&k2=v2');
  //console.log(searchParams.toString());

  //const location = useLocation();
  //console.log(location);

  return (
    <>
      {data ? (
        <>
          <h1>{data.subject}</h1>
          <div>{data.content}</div>
        </>
      ) : (
        <div>게시글이 없습니다.</div>
      )}
    </>
  );
}; //JSX 에서는 if문 사용 불가... "삼항조건"이나 &&연산 사용

export default React.memo(Board);
