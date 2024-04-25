import React from "react";
import { Link } from "react-router-dom";
import "./header.css";

const AuthHeader = () => {
  return (
    <header className="header">
        <Link className="header__logo-wrapper" to="/catalog">
            <img
                className="header__logo-image"
                src={"/images/kion-logo.png"}
                alt="site logo"
            />
            <div className='header__logo-text'>Маркет</div>
        </Link>
      <Link className="header__link" to="/login">
        Вход
      </Link>
      <Link className="header__link" to="/register">
        Регистрация
      </Link>
    </header>
  );
};

export default AuthHeader;
