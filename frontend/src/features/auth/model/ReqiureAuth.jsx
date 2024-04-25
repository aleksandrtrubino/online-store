import { useLocation, Navigate, Outlet } from "react-router-dom"
import React from "react"
import { useJwt } from "react-jwt"
import Cookies from 'js-cookie';

const RequireAuth = () => {
    const token = Cookies.get("refreshToken")
    const {isExpired} = useJwt(token);
    const location = useLocation()

    return (
        !isExpired
            ? <Outlet />
            : <Navigate to="/login" state={{ from: location }} replace />
    )
}
export default RequireAuth