import { createSlice } from "@reduxjs/toolkit";
import {decodeToken} from "react-jwt";


const authSlice = createSlice({
  name: "auth",
  initialState: {
    id: null,
    token: null,
  },
  reducers: {
    setToken(state, action){
      state.token = action.payload;
      state.id = decodeToken(state.token).sub;
    },
    logout(state, action){
      state.token = null;
      state.id = null;
    }
  },
});

export const {setToken, logout } = authSlice.actions;
export const selectCurrentId = (state) => state.auth.id;
export const selectCurrentToken = (state) => state.auth.token;

export default authSlice;
