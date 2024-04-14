import { baseApi } from "../../../shared/api/baseApi";

export const loginApi = baseApi.injectEndpoints({
  endpoints: (builder) => ({
    login: builder.mutation({
      query: (credentials) => ({
        url: "/auth",
        method: "POST",
        body: { ...credentials },
        withCredentials: true,
      }),
    }),
  }),
});

export const { useLoginMutation } = loginApi;
