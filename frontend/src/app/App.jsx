import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Register from "../pages/register";
import Login from "../pages/login";
import Catalog from "../pages/catalog";
import ProductPage from "../pages/productPage/ProductPage";
import AuthLayout from "../widgets/layout/AuthLayout";
import MainLayout from "../widgets/layout/MainLayout";
import RequireAuth from "../features/auth/model/ReqiureAuth";
import React from "react";
import { Provider } from "react-redux";
import store from "./store";

import { CreateProductImage } from "../entities/product/CreateProductImage";

const App = () => {
  return (
    <BrowserRouter>
      <Provider store={store}>
        <Routes>

          <Route element={<AuthLayout />}>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Route>

           <Route element={<RequireAuth />}>
            <Route element={<MainLayout />}>
              <Route path="/catalog" element={<Catalog />} />
              <Route path="/catalog/:productId" element={<ProductPage />}/>
              <Route path="/product-image" element={<CreateProductImage/>}/>
            </Route>
           </Route>

          <Route path="*" element={<Navigate to="/catalog"/>}/>

        </Routes>
      </Provider>
    </BrowserRouter>
  );
};

export default App;
