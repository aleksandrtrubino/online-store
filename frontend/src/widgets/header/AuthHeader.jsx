import React from "react";
import { Link } from "react-router-dom";
import "./header.css";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignIn, faUser, faUserPlus} from "@fortawesome/free-solid-svg-icons";

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
          <FontAwesomeIcon className='header__link-icon' icon={faSignIn} />
          <span className='header__link-name'>Вход</span>

      </Link>
      <Link className="header__link" to="/register">
          <FontAwesomeIcon className='header__link-icon' icon={faUserPlus} />
          <span className='header__link-name'>Регистрация</span>
      </Link>
    </header>
  );
};

export default AuthHeader;
