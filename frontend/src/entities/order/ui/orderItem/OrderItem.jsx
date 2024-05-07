import React from "react";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import {selectUserId} from "../../../../features/auth/model/authSlice";
import './OrderItem.css'
import {useAddPurchaseMutation} from "../../../purchase/api/PurchaseApi";

const OrderItem = ({purchase}) =>{

    const navigate = useNavigate()
    const userId = useSelector(selectUserId);
    const [addPurchase] = useAddPurchaseMutation()
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

    const receiveOrder = async () =>{
        try{
            const purchaseId = purchase.id;
            const response = await addPurchase({purchaseId}).unwrap()
        }
        catch(error){
            console.log(error)
        }
    }


    return(
        <div className="order-item">

            <div className='order-item__image-area' onClick={courseProductPage}>
                <img className="order-item__image"  src={purchase.product.images[0]?`data:image/webp;base64,${purchase.product.images[0]}`:"/images/default-product-image.jpg"} alt="Изображение продукта"/>
            </div>
            <div className='order-item__price-area'>
                <div className="order-item__price">{purchase.product.price}₽</div>
            </div>
            <div className='order-item__name-area'>
                <div className="order-item__name" onClick={courseProductPage}>{purchase.product.name}</div>
            </div>
            <div className='order-item__date-area'>
                <button className='order-item__receive-button' onClick={receiveOrder}>Получил</button>
                <span className='order-item__date'>{'Дата заказа: ' + toDate(purchase.updatedAt)}</span>
            </div>

        </div>
    )
}

export default OrderItem;