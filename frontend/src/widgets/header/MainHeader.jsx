import React from "react";
import { Link } from "react-router-dom";
import "./header.css";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {
    faBoxes,
    faBoxesAlt,
    faBoxesPacking,
    faBoxesStacked, faBoxOpen,
    faCartShopping,
    faHeart,
    faUser
} from "@fortawesome/free-solid-svg-icons";

const MainHeader = () => {
  return (
    <header className="header">
      <Link className="header__logo-wrapper" to="/catalog?page=1&sort=id&order=asc">
        <img
          className="header__logo-image"
          src={"/images/kion-logo.png"}
          alt="site logo"
        />
          <div className='header__logo-text'>Маркет</div>
      </Link>
      <Link className="header__link" to="/profile">
          <FontAwesomeIcon className='header__link-icon' icon={faUser} />
          <span className='header__link-name'>Профиль</span>
      </Link>
      <Link className="header__link" to="/cart">
          <FontAwesomeIcon className='header__link-icon' icon={faCartShopping} />
          <span className='header__link-name'>Корзина</span>
      </Link>
      <Link className="header__link" to="/favorites">
          <FontAwesomeIcon className='header__link-icon' icon={faHeart} />
          <span className='header__link-name'>Избранное</span>
      </Link>
      <Link className="header__link" to="/orderlist?purchased=0">
          <FontAwesomeIcon className='header__link-icon' icon={faBoxOpen} />
          <span className='header__link-name'>Заказы</span>
      </Link>
    </header>
  );
};

export default MainHeader;
