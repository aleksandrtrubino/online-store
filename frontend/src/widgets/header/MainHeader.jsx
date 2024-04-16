import React from "react";
import { Link } from "react-router-dom";
import "./header.css";

const MainHeader = () => {
  return (
    <header className="header">
      <Link className="header__logo-wrapper" to="/catalog">
        <img
          className="header__logo"
          src={"/images/kion-logo.png"}
          alt="site logo"
        />
      </Link>
      <Link className="header__link" to="/profile">
        Профиль
      </Link>
      <Link className="header__link" to="/cart">
        Корзина
      </Link>
      <Link className="header__link" to="/favorites">
        Избранное
      </Link>
      <Link className="header__link" to="/orderlist">
        Заказы
      </Link>
    </header>
  );
};

export default MainHeader;
