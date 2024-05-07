import React from "react";
import { Provider } from "react-redux";
import store, {persistor} from "./store";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import {PersistGate} from "redux-persist/integration/react";

import Register from "../pages/register";
import Login from "../pages/login";
import Product from "../pages/product/Product";
import AuthLayout from "../widgets/layout/AuthLayout";
import MainLayout from "../widgets/layout/MainLayout";
import RequireAuth from "../features/auth/model/ReqiureAuth";
import DropdownSelectMenu from "../widgets/dropdownSelectMenu/DropdownSelectMenu";
import Favorites from "../pages/favorites/Favorites";
import Catalog from "../pages/catalog/Catalog";
import Cart from "../pages/cart/Cart";

import { CreateProductImage } from "../entities/product/CreateProductImage";
import Orders from "../pages/orders/Orders";
import Profile from "../pages/profile/Profile";


const App = () => {
  return (
    <BrowserRouter>
      <Provider store={store}>
          <PersistGate loading={null} persistor={persistor}>
        <Routes>

          <Route element={<AuthLayout />}>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Route>

           <Route element={<RequireAuth />}>
            <Route element={<MainLayout />}>
                <Route path="/catalog" element={<Catalog />} />
                <Route path='/favorites' element={<Favorites />}/>
                <Route path="/product/:productId" element={<Product />}/>
                <Route path="/cart" element={<Cart />}/>
                <Route path='/orderlist' element={<Orders />}/>
                <Route path='/profile' element={<Profile />}/>

              <Route path="/product-image" element={<CreateProductImage/>}/>
            </Route>
           </Route>

          <Route path="*" element={<Navigate to="/catalog"/>}/>

        </Routes>
              </PersistGate>
      </Provider>
    </BrowserRouter>
  );
};

export default App;
