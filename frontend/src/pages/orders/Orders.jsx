
import CartList from "../../widgets/cartList/CartList";
import {useNavigate} from "react-router-dom";
import CartMenu from "../../widgets/cartMenu/CartMenu";
import {useGetOrdersQuery} from "../../entities/order/api/OrderApi";

import './Orders.css'

const Orders = () =>{

    const navigate = useNavigate();
    const orders = useGetOrdersQuery()
    console.log(orders.data)

    const courseProductPage = () => {
        navigate(`/product/${orders.data.product.id}`)
    }

    return (
        orders.isSuccess ?
            <div className='orders'>
                <h1 className='orders-header'>Заказы</h1>
                <span className='orders__item-count'>Товары({orders?.data?.length})</span>
                <div className='orders__grid'>
                    <CartList className='orders__item-list' purchases={orders.data}/>
                </div>
            </div>
            :
            orders.isLoading ? 'loading...'
                :
                orders.isError ?
                    'error'
                    :
                    'undefined '
    )
}

export default Orders;