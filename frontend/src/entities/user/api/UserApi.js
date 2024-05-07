import {baseApi} from "../../../shared/api/baseApi";

const UserApi = baseApi.injectEndpoints({
    endpoints: (build) => ({
        getUserInfo: build.query({
            query: (userId) => ({
                url: `/users/${userId}`,
                method: "GET",
            })
        }),
    }),
});

export const {useGetUserInfoQuery} = UserApi;