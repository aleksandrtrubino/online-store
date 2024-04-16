import { useLocation, Navigate, Outlet } from "react-router-dom"
import { useSelector } from "react-redux"
import { selectCurrentToken } from "./authSlice"
import React from "react"
import { useJwt } from "react-jwt"

const RequireAuth = () => {
    const token = useSelector(selectCurrentToken)
    const [isExpired] = useJwt(token);
    const location = useLocation()

    return (
        !isExpired
            ? <Outlet />
            : <Navigate to="/login" state={{ from: location }} replace />
    )
}
export default RequireAuth