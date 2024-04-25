import React from 'react';
import { Outlet } from 'react-router-dom';

import MainHeader from '../header/MainHeader';
import Footer from '../footer/Footer';
import './layout.css'

const MainLayout = () => {
  return (
    <>
    <MainHeader />
      <div className='content'>
        <Outlet />
      </div>

    <Footer />
    </>
  )
}

export default MainLayout;
