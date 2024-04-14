import React from "react";
import { useState, useEffect } from "react";
import { useDispatch } from 'react-redux'
import { useLoginMutation } from "../../features/auth/api/authApi";
import { useNavigate } from 'react-router-dom'


import { setToken } from "../../features/auth/model/authSlice";

import "./Login.css";

const PASSWORD_REGEX = /^(?=.*[a-z])(?=.*[0-9]).{8,24}$/;
const EMAIL_REGEX = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/;

const Login = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate()

  const [email, setEmail] = useState("");
  const [validEmail, setValidEmail] = useState(true);

  const [password, setPassword] = useState("");
  const [validPassword, setValidPassword] = useState(true);

  const [login] = useLoginMutation()

  useEffect(() => {
    setValidEmail(EMAIL_REGEX.test(email) || email === "" ? true : false);
  }, [email]);

  useEffect(() => {
    setValidPassword(
      PASSWORD_REGEX.test(password) || password === "" ? true : false
    );
  }, [password]);

  const validFields = () => {
    return validEmail && validPassword;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (email === "") {
      setValidEmail(false);
    }
    if (password === "") {
      setValidPassword(false);
    }

    if (validFields()) {
      try{
        // const response = await axios.post(
        //   LOGIN_URL,
        //   JSON.stringify({ email, password }),
        //   {
        //     headers: { "Content-Type": "application/json" },
        //     withCredentials: true,
        //   }
        // );
        console.log("Login: request is sent")
        const response = await login({email, password}).unwrap();
        console.log("token: "+ response?.token)
        navigate("/catalog")
      }
      catch (error){
        console.log(error);
        if(!error){
          console.log("No server response")
        }
        else if(error?.response?.status === 404){
          console.log("User with this email doesn't exist")
        }
        else if(error?.response?.status === 403){
          console.log("Wrong password")
        }
      }
      


    }
  };

  return (
    <>
      <div className="login__wrapper">
        <section className="login__section">
          <form className="login__form" onSubmit={handleSubmit}>
            <h1 className="login__header">Вход</h1>

            <div className="login__input-wrapper">
              <label className="login__label" htmlFor="email">
                Электронная почта:
              </label>
              <input
                className={
                  validEmail
                    ? email !== ""
                      ? "login__input login__input_box-shadow_green"
                      : "login__input"
                    : "login__input login__input_box-shadow_red"
                }
                type="text"
                id="email"
                placeholder="Электронная почта"
                autoComplete="email"
                onChange={(e) => {
                  setEmail(e.target.value);
                  setValidEmail(true);
                }}
                value={email}
              />
              <div
                className={
                  !validEmail
                    ? "login__error-message"
                    : "login__error-message login__error-message_hidden"
                }
                id="email"
              >
                <p>Введите корректный адрес электронной почты.</p>
              </div>
            </div>

            <div className="login__input-wrapper">
              <label className="login__label" htmlFor="password">
                Пароль:
              </label>
              <input
                className={
                  validPassword
                    ? password !== ""
                      ? "login__input login__input_box-shadow_green"
                      : "login__input"
                    : "login__input login__input_box-shadow_red"
                }
                type="password"
                id="password"
                placeholder="Пароль"
                autoComplete="current-password"
                onChange={(e) => setPassword(e.target.value)}
                value={password}
              />
              <div
                className={
                  !validPassword
                    ? "login__error-message"
                    : "login__error-message login__error-message_hidden"
                }
                id="password"
              >
                <p>
                  Пароль должен содержать не менее 8 символов
                  <br /> и включать в себя цифры и латинские буквы. <br />
                  Допускаются буквы верхнего регистра и специальные символы.
                </p>
              </div>
            </div>

            <button className="login__button">Войти</button>
          </form>
        </section>
      </div>
    </>
  );
};

export default Login;
