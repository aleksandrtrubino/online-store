
import React from "react";
import './PurchaseList.css'
import OrderItem from "../../entities/order/ui/orderItem/OrderItem";
import {useGetPurchasesQuery} from "../../entities/purchase/api/PurchaseApi";
import PurchaseItem from "../../entities/purchase/ui/purchaseItem/PurchaseItem";


const OrderList = ({className}) =>{

    const purchases = useGetPurchasesQuery()
    const content = purchases === undefined ? "Нет купленных товаров" : purchases?.data?.map((purchase) => <PurchaseItem key = {purchase.id} purchase={purchase} />);


    return (
        purchases.isSuccess ?
            <div className={className + ' purchase-list'}>
                <span className='purchase-list__item-count'>Товары({purchases?.data?.length})</span>
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