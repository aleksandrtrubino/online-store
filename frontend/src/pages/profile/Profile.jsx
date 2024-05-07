
import './Profile.css'
import {useGetUserInfoQuery} from "../../entities/user/api/UserApi";
import {useDispatch, useSelector} from "react-redux";
import {logout, selectUserId} from "../../features/auth/model/authSlice";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignOut} from "@fortawesome/free-solid-svg-icons";
import {useLogoutMutation} from "../../features/auth/api/authApi";
import {useNavigate} from "react-router-dom";

const Profile = () =>{

    const userId = useSelector(selectUserId);
    const user = useGetUserInfoQuery(userId)
    const [logoutMutation] = useLogoutMutation();
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const doLogout = async () =>{
        try{
            dispatch(logout());
            const response = await logoutMutation().unwrap();
        }
        catch(error){
            console.log(error)
        }
        navigate('/login')
    }

    return (
        user.isSuccess ?
        <div className='profile'>
            <div className='profile__section'>
                <div className='profile__icon-area'>
                    <p className='profile__icon'>{user.data.firstName[0] + user.data.lastName[0]}</p>
                </div>
                <div className='profile__info-area'>
                    <div className='profile__info'>
                        <span className='profile__info-header'>
                            Почта
                        </span>
                        <span className='profile__info-content'>
                            {user.data.email}
                        </span>
                    </div>
                    <div className='profile__info'>
                        <span className='profile__info-header'>
                            Фамилия
                        </span>
                        <span className='profile__info-content'>
                            {user.data.lastName}
                        </span>
                    </div>
                    <div className='profile__info'>
                        <span className='profile__info-header'>
                            Имя
                        </span>
                        <span className='profile__info-content'>
                            {user.data.firstName}
                        </span>
                    </div>
                    <div className='profile__info'>
                        <span className='profile__info-header'>
                            Отчество
                        </span>
                        <span className='profile__info-content'>
                            {user.data.middleName}
                        </span>
                    </div>
                    <button className='profile__logout-button' onClick={doLogout}>
                        <span className='profile__logout-name'>Выйти</span>
                        <FontAwesomeIcon className='profile__logout-icon' icon={faSignOut}/>
                    </button>

                </div>
            </div>
        </div>
            :
            user.isLoading ?
                'loading...'
                :
                user.isError ?
                    'error'
                    :
                    'undefined'
    )
}

export default Profile;