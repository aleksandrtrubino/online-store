import { configureStore } from "@reduxjs/toolkit";
import authSlice from "../features/auth/model/authSlice";
import { baseApi } from "../shared/api/baseApi";
import cartSlice from "../entities/cart/model/cartSlice";

import { persistStore, persistReducer } from 'redux-persist'
import storage from 'redux-persist/lib/storage'

const authReducer = persistReducer({key: 'auth', storage}, authSlice.reducer)
const cartReducer = persistReducer({key: 'cart', storage}, cartSlice.reducer)


const store = configureStore({
  reducer: {
    [baseApi.reducerPath]: baseApi.reducer,
    auth: authReducer,
    cart: cartReducer
  },
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(baseApi.middleware)
  // middleware: (getDefaultMiddleware) =>
  //   getDefaultMiddleware().concat(authSlice.middleware),
});

export const persistor = persistStore(store)
export default store;
