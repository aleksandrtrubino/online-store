import React from 'react';
import { Outlet } from 'react-router-dom';

import AuthHeader from '../header/AuthHeader';
import Footer from '../footer/Footer';

const AuthLayout = () => {
  return (
    <>
      <AuthHeader />
      <Outlet />
      <Footer />
    </>
  )
}

export default AuthLayout;
