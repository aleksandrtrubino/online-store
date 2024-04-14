import React from 'react';
import { Link } from 'react-router-dom';

import './Footer.css';

const Footer = () => {
  return (
    <>
    <footer className='footer'>
      <div className='footer__column'>
        <div className='footer__row'>
          <Link className="footer__link" to="/about">О нас</Link>
          <Link className="footer__link" to="/contacts">Контакты</Link>
        </div>
        <text className='footer__copyright'> © ООО "Вистар", 2009-2024</text>
      </div>
    </footer>
    </>
  )
}

export default Footer;
