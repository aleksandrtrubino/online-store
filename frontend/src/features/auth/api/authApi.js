import { baseApi } from "../../../shared/api/baseApi";

export const loginApi = baseApi.injectEndpoints({
  endpoints: (build) => ({
    login: build.mutation({
      query: (credentials) => ({
        url: "/auth",
        method: "POST",
        body: { ...credentials }
      }),
    }),
    register: build.mutation({
      query: (user) =>({
        url: '/users',
        method: 'POST',
        body: {...user}
      })
    }),
    logout: build.mutation({
      query: () =>({
        url: '/auth',
        method: 'DELETE'
      })
    })
  }),
});

export const { useLoginMutation, useLogoutMutation, useRegisterMutation } = loginApi;
