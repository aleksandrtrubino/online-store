import { baseApi } from "../../../shared/api/baseApi";



const ShopApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getShops: build.query({
            query: () => ({
                url: `/shops`,
                method: "GET",
            })
        }),
    }),
});

export const {useGetShopsQuery} = ShopApi;
