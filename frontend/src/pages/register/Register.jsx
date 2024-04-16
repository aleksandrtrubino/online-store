import React from "react";
import { useState, useEffect } from "react";
import "./Register.css";

const NAME_REGEX = /^([а-яёА-ЯЁ]){1,23}$/;
const PASSWORD_REGEX = /^(?=.*[a-z])(?=.*[0-9]).{8,24}$/;
const EMAIL_REGEX = /^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/;

const Register = () => {
  const [firstName, setFirstName] = useState("");
  const [validFirstName, setValidFirstName] = useState(true);

  const [middleName, setMiddleName] = useState("");
  const [validMiddleName, setValidMiddleName] = useState(true);

  const [lastName, setLastName] = useState("");
  const [validLastName, setValidLastName] = useState(true);

  const [email, setEmail] = useState("");
  const [validEmail, setValidEmail] = useState(true);

  const [password, setPassword] = useState("");
  const [validPassword, setValidPassword] = useState(true);

  const [matchingPassword, setMatchingPassword] = useState("");
  const [validMatchingPassword, setValidMatchingPassword] = useState(true);

  useEffect(() => {
    setValidLastName(
      NAME_REGEX.test(lastName) || lastName === "" ? true : false
    );
  }, [lastName]);

  useEffect(() => {
    setValidFirstName(
      NAME_REGEX.test(firstName) || firstName === "" ? true : false
    );
  }, [firstName]);

  useEffect(() => {
    setValidMiddleName(
      NAME_REGEX.test(middleName) || middleName === "" ? true : false
    );
  }, [middleName]);

  useEffect(() => {
    setValidEmail(EMAIL_REGEX.test(email) || email === "" ? true : false);
  }, [email]);

  useEffect(() => {
    setValidPassword(
      PASSWORD_REGEX.test(password) || password === "" ? true : false
    );
  }, [password]);

  useEffect(() => {
    setValidMatchingPassword(
      matchingPassword === "" || password === matchingPassword ? true : false
    );
  }, [password, matchingPassword]);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (lastName === "") {
      setValidLastName(false);
    }
    if (firstName === "") {
      setValidFirstName(false);
    }
    if (middleName === "") {
      setValidMiddleName(false);
    }
    if (email === "") {
      setValidEmail(false);
    }
    if (password === "") {
      setValidPassword(false);
    }
    if (matchingPassword === "") {
      setValidMatchingPassword(false);
    }
  };

  return (
    <>
      <div className="register__wrapper">
        <section className="register__section">
          <form className="register__form" onSubmit={handleSubmit}>
            <h1 className="register__header">Регистрация</h1>

            <div className="register__input-wrapper">
              <label className="register__label" htmlFor="last-name">
                Фамилия:
              </label>
              <input
                className={
                  validLastName
                    ? lastName !== ""
                      ? "register__input register__input_box-shadow_green"
                      : "register__input"
                    : "register__input register__input_box-shadow_red"
                }
                type="text"
                id="last-name"
                placeholder="Фамилия"
                autoComplete="off"
                onChange={(e) => setLastName(e.target.value)}
                value={lastName}
              />
              <div
                className={
                  !validLastName
                    ? "register__error-message"
                    : "register__error-message register__error-message_hidden"
                }
                id="last-name"
              >
                <p>
                  Некорректный формат. <br />
                  Пожалуйста, используйте кириллические символы.
                </p>
              </div>
            </div>

            <div className="register__input-wrapper">
              <label className="register__label" htmlFor="first-name">
                Имя:
              </label>
              <input
                className={
                  validFirstName
                    ? firstName !== ""
                      ? "register__input register__input_box-shadow_green"
                      : "register__input"
                    : "register__input register__input_box-shadow_red"
                }
                type="text"
                id="first-name"
                placeholder="Имя"
                autoComplete="off"
                onChange={(e) => setFirstName(e.target.value)}
                value={firstName}
              />
              <div
                className={
                  !validFirstName
                    ? "register__error-message"
                    : "register__error-message register__error-message_hidden"
                }
                id="first-name"
              >
                <p>
                  Некорректный формат. <br />
                  Пожалуйста, используйте кириллические символы.
                </p>
              </div>
            </div>

            <div className="register__input-wrapper">
              <label className="register__label" htmlFor="middle-name">
                Отчество:
              </label>
              <input
                className={
                  validMiddleName
                    ? middleName !== ""
                      ? "register__input register__input_box-shadow_green"
                      : "register__input"
                    : "register__input register__input_box-shadow_red"
                }
                type="text"
                id="middle-name"
                placeholder="Отчество"
                autoComplete="off"
                onChange={(e) => setMiddleName(e.target.value)}
                value={middleName}
              />
              <div
                className={
                  !validMiddleName
                    ? "register__error-message"
                    : "register__error-message register__error-message_hidden"
                }
                id="middle-name"
              >
                <p>
                  Некорректный формат. <br />
                  Пожалуйста, используйте кириллические символы.
                </p>
              </div>
            </div>

            <div className="register__input-wrapper">
              <label className="register__label" htmlFor="email">
                Электронная почта:
              </label>
              <input
                className={
                  validEmail
                    ? email !== ""
                      ? "register__input register__input_box-shadow_green"
                      : "register__input"
                    : "register__input register__input_box-shadow_red"
                }
                type="text"
                id="email"
                placeholder="Электронная почта"
                autoComplete="off"
                onChange={(e) => {
                  setEmail(e.target.value);
                  setValidEmail(true);
                }}
                value={email}
              />
              <div
                className={
                  !validEmail
                    ? "register__error-message"
                    : "register__error-message register__error-message_hidden"
                }
                id="email"
              >
                <p>Введите корректный адрес электронной почты.</p>
              </div>
            </div>

            <div className="register__input-wrapper">
              <label className="register__label" htmlFor="password">
                Пароль:
              </label>
              <input
                className={
                  validPassword
                    ? password !== ""
                      ? "register__input register__input_box-shadow_green"
                      : "register__input"
                    : "register__input register__input_box-shadow_red"
                }
                type="password"
                id="password"
                placeholder="Пароль"
                onChange={(e) => setPassword(e.target.value)}
                value={password}
              />
              <div
                className={
                  !validPassword
                    ? "register__error-message"
                    : "register__error-message register__error-message_hidden"
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

            <div className="register__input-wrapper">
              <label className="register__label" htmlFor="matching-password">
                Повторите пароль:
              </label>
              <input
                className={
                  validMatchingPassword
                    ? matchingPassword !== ""
                      ? "register__input register__input_box-shadow_green"
                      : "register__input"
                    : "register__input register__input_box-shadow_red"
                }
                type="password"
                id="matching-password"
                placeholder="Повторите пароль"
                onChange={(e) => setMatchingPassword(e.target.value)}
                value={matchingPassword}
              />
              <div
                className={
                  !validMatchingPassword
                    ? "register__error-message"
                    : "register__error-message register__error-message_hidden"
                }
                id="matching-password"
              >
                <p>Пароли не совпадают.</p>
              </div>
            </div>

            <button className="register__button">Создать аккаунт</button>
          </form>
        </section>
      </div>
    </>
  );
};

export default Register;
