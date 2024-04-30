import { baseApi } from "../../../shared/api/baseApi";



const CategoryApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getCategories: build.query({
            query: () => ({
                url: `/categories`,
                method: "GET",
            })
        }),
        getSubcategories: build.query({
            query: (categoryId) => ({
                url: `/categories/${categoryId}/subcategories`,
                method: "GET",
            })
        }),
    }),
});

export const {useGetCategoriesQuery, useGetSubcategoriesQuery} = CategoryApi;
