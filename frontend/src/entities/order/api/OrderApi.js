import {baseApi} from "../../../shared/api/baseApi";

const OrderApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getOrders: build.query({
            query: () =>({
                url: '/purchases?purchaseStatusId=1002',
                method: 'GET'
            }),
            providesTags: ['Order']
        }),
        addOrder: build.mutation({
            query: ({purchaseId}) =>({
                url: `/purchases/${purchaseId}`,
                method: "PATCH",
                body:{
                    purchaseStatusId: 1002
                }
            }),
            invalidatesTags: ['Order','Cart']
        }),
    })
})

export const {useAddOrderMutation, useGetOrdersQuery} = OrderApi