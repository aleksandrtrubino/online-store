import {useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {
    useAddFavoriteMutation,
    useGetProductByIdQuery,
    useRemoveFavoriteMutation
} from "../../entities/product/api/ProductApi";
import {useEffect, useState} from "react";
import React from "react";
import ProductCard from "../../entities/product/ui/productCard/ProductCard";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {
    faChevronRight,
    faChevronLeft,
    faShop,
    faCircle as solidCircle,
    faHeart
} from '@fortawesome/free-solid-svg-icons'
import {faCircle as regularCircle} from "@fortawesome/free-regular-svg-icons";
import './Product.css'
import {selectUserId} from "../../features/auth/model/authSlice";
import {useAddToCartMutation, useRemoveFromCartMutation} from "../../entities/cart/api/CartApi";

const ImageSlider = ({images}) => {
    const [isLeftArrowVisible, setIsLeftArrowVisible] = useState(false);
    const [isRightArrowVisible, setIsRightArrowVisible] = useState(false);
    const [index, setIndex] = useState(0);
    const [image, setImage] = useState(images[index]);

    useEffect(()=>{
        if(images.length > 1)
            setIsRightArrowVisible(true);
    },[]);

    useEffect(() => {
        if(index > 0){
            setIsLeftArrowVisible(true)
        }
        else{
            setIsLeftArrowVisible(false)
        }
        if(index === images.length - 1){
            setIsRightArrowVisible(false)
        }
        else{
            setIsRightArrowVisible(true)
        }
    }, [index]);

    const toPrevImage = () =>{
        setIndex(index - 1)
    }

    const toNextImage = () =>[
        setIndex(index + 1)
    ]

    const content = images.map((product) => <ProductCard key = {product.id} product={product} />);

    return(
        <>
            <FontAwesomeIcon className={'product-page__left-arrow ' + (!isLeftArrowVisible ? 'product-page__left-arrow_hidden':'')} onClick={toPrevImage} icon={faChevronLeft}/>
            <img className='product-page__image' src={images[0]?`data:image/webp;base64,${images[index]}`:"/images/default-product-image.jpg"} alt="Изображение продукта" />
            <FontAwesomeIcon className={'product-page__right-arrow ' + (!isRightArrowVisible ? 'product-page__right-arrow_hidden':'')} onClick={toNextImage} icon={faChevronRight}/>
        </>
    )

}

const Product = () =>{
    const {productId} = useParams()
    const dispatch = useDispatch();

    const [addFavorite] = useAddFavoriteMutation();
    const [removeFavorite] = useRemoveFavoriteMutation();
    const [addToCart] = useAddToCartMutation();
    const [removeFromCart] = useRemoveFromCartMutation();
    const userId = useSelector(selectUserId);
    const [isInCart, setIsInCart] = useState(undefined);

    const {
        data: product,
        isLoading,
        isSuccess,
        isError,
        error,
        refetch
    } = useGetProductByIdQuery({productId: productId});

    const [isFavorite, setIsFavorite] = useState(undefined);

    useEffect(() => {
        if(isSuccess){
            setIsFavorite(product.isFavorite)
            setIsInCart(product.isInCart)
        }
    }, [product]);


    const toggleInCart = async () =>{
        if(!isInCart){
            try{
                const response = await addToCart({productId, userId}).unwrap();
                setIsInCart(true)
            }
            catch(error){
                console.log(error)
            }
        }
        else{
            try{
                const response = await removeFromCart({productId, userId}).unwrap();
                setIsInCart(false)
            }
            catch(error){
                console.log(error)
            }
        }
    }

    const toggleFavorite = async () =>{
        if(!isFavorite){
            try{
                const response = await addFavorite({userId, productId}).unwrap();
                setIsFavorite(true)
            }
            catch(error){
                console.log(error)
            }

        }
        else{
            const response = await removeFavorite({userId, productId}).unwrap();
            setIsFavorite(false)
            console.log(response)
        }

    }

    const getIsFavorite = () =>{
        if(isFavorite === undefined) {
            return product.isFavorite;
        }
        return isFavorite
    }

    return(
    isSuccess ?
        <div className='product-page__wrapper'>
            <div className='product-page'>
            <div className='product-page__image-area'>
                <div className='product-page__image-wrapper'>
                <ImageSlider images={product.images}/>
                </div>
            </div>
            <div className='product-page__name-area'>
                <div className='product-page__name-wrapper'>
                    <div className='product-page__name'>
                        {product.name}
                    </div>
                    <div className='product-page__rating-reviews'>

                    </div>

                    <div className='product-page__details'>
                        <div className='product-page__details-list'>
                            <div className='product-page__details-item'>
                                <span className='product-page__details-item-header'>
                                    Категория:
                                </span>
                                <span className='product-page__details-item-content'>
                                {product.subcategory.category.name}
                                </span>
                            </div>
                            <div className='product-page__details-item'>
                                <span className='product-page__details-item-header'>
                                    Подкатегория:
                                </span>
                                <span className='product-page__details-item-content'>
                                {product.subcategory.name}
                                </span>
                            </div>
                        </div>
                    </div>

                    <div className='product-page__shop-wrapper'>
                        <FontAwesomeIcon className='product-page__shop-logo ' icon={faShop}/>
                        <div className='product-page__shop-name'>
                            {product.shop.name}
                        </div>
                        <div className='product-page__shop'>
                            Магазин
                        </div>
                    </div>
                </div>
            </div>
            <div className='product-page__price-area'>
                <div className='product-page__price-wrapper'>
                    <div className='product-page__price'>{product.price}₽</div>
                    <button className={
                        'product-page__button-to-cart ' +
                        ((isInCart === undefined ? product.isInCart : isInCart) ? 'product-page__button-to-cart_true' : '')}
                            onClick={toggleInCart}
                    >{!(isInCart === undefined ? product.isInCart : isInCart) ? 'Добавить в корзину' : 'В корзине'}</button>
                    <button className='product-page__button-to-favorites'>
                        <FontAwesomeIcon className=
                                             {
                            'product-page__to-favorite-icon '
                                                 + ((isFavorite === undefined ? product.isFavorite : isFavorite) ?
                                                     'product-page__to-favorite-icon_true'
                                                     :
                                                     'product-page__to-favorite-icon_false')}
                                         icon={faHeart}
                                         onClick={toggleFavorite}
                        />
                    </button>
                </div>
            </div>
            <div className='product-page__description-area'>{product.description}</div>
            </div>
        </div>
        :
        isLoading ?
            'loading...'
            :
            isError ?
                {error}
                :
                'Unexpected Error Occured'
    )
}

export default Product;