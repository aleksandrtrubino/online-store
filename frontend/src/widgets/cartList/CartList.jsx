
import React from "react";
import CartItem from "../../entities/cart/ui/cartItem/CartItem";
import './CartList.css'

const CartList = ({className, purchases}) =>{

    const content = purchases === undefined ? "В корзине нет товаров" :purchases.map((purchase) => <CartItem key = {purchase.id} purchase={purchase} />);


    return (
        <div className={className + ' cart-list'}>
            {content}
        </div>
    )
}

export default CartList;