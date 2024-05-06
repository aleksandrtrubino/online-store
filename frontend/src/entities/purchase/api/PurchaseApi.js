import {baseApi} from "../../../shared/api/baseApi";

const PurchaseApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getPurchases: build.query({
            query: () =>({
                url: '/purchases?purchaseStatusId=1003',
                method: 'GET'
            }),
            providesTags: ['Purchase']
        }),
        addPurchase: build.mutation({
            query: ({purchaseId}) =>({
                url: `/purchases/${purchaseId}`,
                method: "PATCH",
                body:{
                    purchaseStatusId: 1003
                }
            }),
            invalidatesTags: ['Purchase','Order']
        }),
    })
})

export const {useAddPurchaseMutation, useGetPurchasesQuery} = PurchaseApi