'use client';
import React, { createContext, useState } from 'react';

const UserContext = createContext({
  states: { isLogin: false, isAdmin: false, userInfo: null }, // 상태값
  actions: {
    setIsLogin: null,
    setIsAdmin: null,
    setUserInfo: null,
  }, // 상태 변경 함수
});

const UserProvider = ({ children }) => {
  const [isLogin, setIsLogin] = useState(false);
  const [isAdmin, setIsAdmin] = useState(false);
  const [userInfo, setUserInfo] = useState(null);
  const value = {
    states: { isLogin, isAdmin, userInfo },
    actions: { setIsLogin, setIsAdmin, setUserInfo },
  };

  return <UserContext.Provider value={value}>{children}</UserContext.Provider>;
};

const { Consumer: UserConsumer } = UserContext;

export { UserProvider, UserConsumer };

export default UserContext;


