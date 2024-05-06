import {useGetCartItemsQuery} from "../../entities/cart/api/CartApi";
import CartList from "../../widgets/cartList/CartList";
import {useNavigate} from "react-router-dom";
import './Cart.css'
import CartMenu from "../../widgets/cartMenu/CartMenu";


const Cart = () =>{

    const navigate = useNavigate();
    const cart = useGetCartItemsQuery();
    console.log(cart.data)

    const courseProductPage = () => {
        navigate(`/product/${cart.data.product.id}`)
    }

    return (
            cart.isSuccess ?
                <div className='cart'>
                    <h1 className='cart__header'>Корзина</h1>
                    <span className='cart__item-count'>Товары({cart?.data?.length})</span>
                    <div className='cart__grid'>
                        <CartList className='cart__item-list' purchases={cart.data}/>
                        {
                            cart?.data?.length !== 0 ?
                                <CartMenu className='cart__item-menu' purchases={cart.data}/>
                                :
                                <></>
                        }
                    </div>
                </div>
            :
                cart.isLoading ? 'loading...'
                    :
                    cart.isError ?
                        'error'
                        :
                        'undefined '
    )
}

export default Cart;