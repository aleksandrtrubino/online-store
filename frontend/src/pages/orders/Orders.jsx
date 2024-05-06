
import {useNavigate, useSearchParams} from "react-router-dom";
import {useGetOrdersQuery} from "../../entities/order/api/OrderApi";

import './Orders.css'
import OrderList from "../../widgets/orderList/OrderList";
import {useEffect, useState} from "react";
import PurchaseList from "../../widgets/purchaseList/PurchaseList";

const Orders = () =>{

    const navigate = useNavigate();
    const [searchParams, setSearchParams] = useSearchParams();

    useEffect(() => {
        const param = searchParams.get('purchased')
        if(param === null){
            searchParams.set('purchased', '0')
            setSearchParams(searchParams)
        }
    }, []);

    const courseOrders = () =>{
        searchParams.set('purchased', '0')
        setSearchParams(searchParams)
    }

    const coursePurchases = () =>{
        searchParams.set('purchased', '1')
        setSearchParams(searchParams)
    }

    return (
            <div className='orders'>
                <div className='orders__headers'>
                    <h1 className={(searchParams.get('purchased') === '0' ? 'orders-header__header_highlighted' : '') + ' orders-header__header'} onClick={courseOrders}>Заказы</h1>
                    <h1 className={(searchParams.get('purchased') === '1' ? 'orders-header__header_highlighted' : '') + ' orders-header__header'} onClick={coursePurchases}>Купленные товары</h1>
                </div>
                <div className='orders__grid'>
                    {
                        searchParams.get('purchased') === '0' ?
                            <OrderList />
                            :
                            searchParams.get('purchased') === '1' ?
                                <PurchaseList />
                                :
                                'error'
                    }
                </div>
            </div>
    )
}

export default Orders;