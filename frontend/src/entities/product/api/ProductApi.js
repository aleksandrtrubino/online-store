import React from "react";
import { baseApi } from "../../../shared/api/baseApi";

const ProductApi = baseApi.injectEndpoints({
  endpoints: (build) => ({
    getProductList: build.query({
      query: () => ({
        url: "/products",
        method: "GET",
      }),
    }),
  }),
});

export const {useGetProductListQuery } = ProductApi;
