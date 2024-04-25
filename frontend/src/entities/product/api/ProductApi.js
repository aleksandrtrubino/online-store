import React from "react";
import { baseApi } from "../../../shared/api/baseApi";



const ProductApi = baseApi.injectEndpoints({
  endpoints: (build) => ({
    getProducts: build.query({
      query: ({page, limit, sort, order}) => ({
        url: `/products?page=${page - 1}&limit=${limit}&sort=${sort}&order=${order}`,
        method: "GET",
      })
    }),
      getProductById: build.query({
          query: ({productId}) => ({
              url: `products/${productId}`,
              method: "GET",
          }),
      }),
    addFavorite: build.mutation({
      query: ({userId, productId}) =>({
       url: `/users/${userId}/favorites/${productId}`,
       method: "POST"
      })
    }),
    removeFavorite: build.mutation({
      query: ({userId, productId}) =>({
       url: `/users/${userId}/favorites/${productId}`,
       method: "DELETE"
      })
    }),
  }),
});

export const {useGetProductByIdQuery, useGetProductsQuery, useAddFavoriteMutation, useRemoveFavoriteMutation } = ProductApi;
