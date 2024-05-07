import {baseApi} from "../../../shared/api/baseApi";

const ReviewApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getReviews: build.query({
            query: () =>({
                url: '/reviews',
                method: 'GET'
            }),
            providesTags: ['Review']
        }),
        addReview: build.mutation({
            query: ({review}) =>({
                url: `/reviews`,
                method: "POST",
                body: {...review}
            }),
            invalidatesTags: ['Review']
        }),
    })
})

export const {useAddReviewMutation, useGetReviewsQuery} = ReviewApi