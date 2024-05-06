import { baseApi } from "../../../shared/api/baseApi";

const CartApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getCartItems: build.query({
            query: () =>({
                url: '/purchases?purchaseStatusId=1001',
                method: 'GET'
            }),
            providesTags: ['Cart']
        }),
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
            }),
            invalidatesTags: ['Cart']
        }),
        removeFromCart: build.mutation({
            query: ({productId, userId}) =>({
                url: `/purchases?productId=${productId}&purchaseStatusId=1001`,
                method: "DELETE"
            }),
            invalidatesTags: ['Cart']
        })
    })
})

export const {useAddToCartMutation, useRemoveFromCartMutation, useGetCartItemsQuery} = CartApi