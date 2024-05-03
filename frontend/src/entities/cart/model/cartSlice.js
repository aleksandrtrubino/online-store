import { createSlice } from "@reduxjs/toolkit";

const cartSlice = createSlice({
    name: "cart",
    initialState: {
        productIds: []
    },
    reducers:{
        addToCart: (state, action) =>{
            state.productIds = state.productIds.concat(action.payload);
        },
        removeFromCart: (state, action) =>{
            state.productIds = state.productIds.filter(e => e !== action.payload);
        },
        clearCart: (state) =>{
            state.productIds = []
        }
    }
});

export const {addToCart, removeFromCart, clearCart} = cartSlice.actions;
export const selectCart = (state) =>  state.cart.productIds;

export default cartSlice;