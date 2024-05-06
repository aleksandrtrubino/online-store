import React from "react";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import {selectUserId} from "../../../../features/auth/model/authSlice";
import './PurchaseItem.css'

const PurchaseItem = ({purchase}) =>{

    const navigate = useNavigate()
    const userId = useSelector(selectUserId);
    console.log(purchase)


    const courseProductPage = () => {
        navigate(`/product/${purchase.product.id}`)
    }

    const toDate = (iso80601date) =>{
        const date = new Date(iso80601date);
        const day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        const month = date.getMonth() < 10 ? '0' + date.getMonth() : date.getMonth();
        const year = date.getFullYear()
        return day +'.' + month + '.' + year;
    }


    return(
        <div className="purchase-item">

            <div className='purchase-item__image-area' onClick={courseProductPage}>
                <img className="purchase-item__image"  src={purchase.product.images[0]?`data:image/webp;base64,${purchase.product.images[0]}`:"/images/default-product-image.jpg"} alt="Изображение продукта"/>
            </div>
            <div className='purchase-item__price-area'>
                <div className="purchase-item__price">{purchase.product.price}₽</div>
            </div>
            <div className='purchase-item__name-area'>
                <div className="purchase-item__name" onClick={courseProductPage}>{purchase.product.name}</div>
            </div>
            <div className='purchase-item__date-area'>
                Дата покупки: {toDate(purchase.updatedAt)}
            </div>

        </div>
    )
}

export default PurchaseItem;