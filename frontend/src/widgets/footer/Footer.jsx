import React from 'react';
import { Link } from 'react-router-dom';

import './Footer.css';

const Footer = () => {

  const footerText = "© ООО \"Вистар\",⠀2009-2024"

  return (
    <>
    <footer className='footer'>
      <div className='footer__column'>
        <div className='footer__row'>
          <Link className="footer__link" to="/about">О нас</Link>
          <Link className="footer__link" to="/contacts">Контакты</Link>
        </div>
        <span className='footer__copyright'>{footerText}</span>
      </div>
    </footer>
    </>
  )
}

export default Footer;
