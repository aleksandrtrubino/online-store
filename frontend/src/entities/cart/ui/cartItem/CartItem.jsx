import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTrash} from "@fortawesome/free-solid-svg-icons";
import React from "react";
import './CartItem.css'
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import {selectUserId} from "../../../../features/auth/model/authSlice";
import {useRemoveFromCartMutation} from "../../api/CartApi";

const CartItem = ({purchase}) =>{

    const navigate = useNavigate()
    const userId = useSelector(selectUserId);
    const [removeFromCart] = useRemoveFromCartMutation();


    const courseProductPage = () => {
        navigate(`/product/${purchase.product.id}`)
    }

    const remove = async  () =>{
        try {
            const productId = purchase.product.id;
            const response = await removeFromCart({productId, userId}).unwrap();
        }
        catch (error){
            console.log(error)
        }
    }

    return(
        <div className="cart-item">

            <div className='cart-item__image-area' onClick={courseProductPage}>
                <img className="cart-item__image"  src={purchase.product.images[0]?`data:image/webp;base64,${purchase.product.images[0]}`:"/images/default-product-image.jpg"} alt="Изображение продукта"/>
            </div>
            <div className='cart-item__price-area'>
                <div className="cart-item__price">{purchase.product.price}₽</div>
            </div>
            <div className='cart-item__name-area'>
                <div className="cart-item__name" onClick={courseProductPage}>{purchase.product.name}</div>
            </div>
            <div className='cart-item__icon-area'>
                <FontAwesomeIcon className='cart-item__trash-icon' onClick={remove} icon={faTrash} />
            </div>

        </div>
    )
}

export default CartItem;