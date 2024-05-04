import { baseApi } from "../../../shared/api/baseApi";
import {createApi} from "@reduxjs/toolkit/query/react";
import api from "js-cookie";

const CartApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        addToCart: build.mutation({
            query: ({productId, userId}) =>({
                url: `/purchases`,
                method: "POST",
                body:{
                    userId: userId,
                    addressId: null,
                    productId: productId,
                    purchaseStatusId: 1001
                }
            })
        }),
        removeFromCart: build.mutation({
            query: ({productId, userId}) =>({
                url: `/purchases?productId=${productId}&purchaseStatusId=1001`,
                method: "DELETE"
            })
        })
    })
})

export const {useAddToCartMutation, useRemoveFromCartMutation} = CartApi