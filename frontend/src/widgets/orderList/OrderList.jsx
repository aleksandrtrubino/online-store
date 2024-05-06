
import React from "react";
import './OrderList.css'
import OrderItem from "../../entities/order/ui/orderItem/OrderItem";
import {useGetOrdersQuery} from "../../entities/order/api/OrderApi";

const OrderList = ({className}) =>{

    const purchases = useGetOrdersQuery()
    const content = purchases === undefined ? "Нет заказов" : purchases?.data?.map((purchase) => <OrderItem key = {purchase.id} purchase={purchase} />);


    return (
        purchases.isSuccess ?
        <div className={className + ' order-list'}>
            <span className='order-list__item-count'>Товары({purchases?.data?.length})</span>
            {content}
        </div>
            :
            purchases.isLoading?
                'loading...'
                :
                'error'
    )
}

export default OrderList;