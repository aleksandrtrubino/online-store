import React from "react";
import { Link } from "react-router-dom";
import "./header.css";

const AuthHeader = () => {
  return (
    <header className="header">
      <Link className="header__logo-wrapper" to="/catalog">
        <img
        className="header__logo"
          src={"/images/kion-logo.png"}
          alt="site logo"
        />
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
