import './CartMenu.css'
import {useEffect, useState} from "react";
import {useAddOrderMutation} from "../../entities/order/api/OrderApi";
import {useSelector} from "react-redux";
import {selectUserId} from "../../features/auth/model/authSlice";
import {useNavigate} from "react-router-dom";

const CartMenu = ({className, purchases}) =>{

    const [sum, setSum] = useState();
    const [addOrder] = useAddOrderMutation();
    const userId = useSelector(selectUserId);
    const navigate = useNavigate()

    // Function to calculate the sum of prices of products
    const getSum = (purchases) => {
        if (purchases !== undefined) {
            return purchases.reduce((total, purchase) => {
                return total + purchase.product.price;
            }, 0);
        }
        return 0;
    }

    useEffect(() => {
        setSum(getSum(purchases));
    }, [purchases])

    const makeOrders = async () =>{
        for(let i = 0; i < purchases.length; i++){
            try{
                const purchaseId = purchases[i].id;
                const response = await addOrder({purchaseId}).unwrap()
            }
            catch(error){
                console.log(error)
            }
        }
        navigate('/orderlist')
    }

    return (
        <div className={className + ' cart-menu'}>
            <div className='cart-menu__header'>Итого: {sum}₽</div>
            <button className='cart-menu__button' onClick={makeOrders}>Заказать</button>
        </div>
    )
}

export default CartMenu;