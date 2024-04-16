import { configureStore } from "@reduxjs/toolkit";
import authSlice from "../features/auth/model/authSlice";
import { baseApi } from "../shared/api/baseApi";

const store = configureStore({
  reducer: {
    [baseApi.reducerPath]: baseApi.reducer,
    auth: authSlice.reducer,

  },
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(baseApi.middleware)
  // middleware: (getDefaultMiddleware) =>
  //   getDefaultMiddleware().concat(authSlice.middleware),
});
export default store;
