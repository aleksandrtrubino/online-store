import React from 'react';
import { Outlet } from 'react-router-dom';

import MainHeader from '../header/MainHeader';
import Footer from '../footer/Footer';

const MainLayout = () => {
  return (
    <>
    <MainHeader />
    <Outlet />
    <Footer />
    </>
  )
}

export default MainLayout;
