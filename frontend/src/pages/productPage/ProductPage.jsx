import {useParams} from "react-router-dom";
import {useDispatch} from "react-redux";
import {useGetProductByIdQuery} from "../../entities/product/api/ProductApi";
import {useEffect, useState} from "react";
import React from "react";
import ProductCard from "../../entities/product/ui/productCard/ProductCard";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faChevronRight, faChevronLeft, faShop} from '@fortawesome/free-solid-svg-icons'
import './ProductPage.css'

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

const ProductPage = () =>{
    const {productId} = useParams()
    const dispatch = useDispatch();

    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error,
    } = useGetProductByIdQuery({productId: productId});

    return(
    isSuccess ?
        <div className='product-page__wrapper'>
            <div className='product-page'>
            <div className='product-page__image-area'>
                <div className='product-page__image-wrapper'>
                <ImageSlider images={data.images}/>
                </div>
            </div>
            <div className='product-page__name-area'>
                <div className='product-page__name-wrapper'>
                    <div className='product-page__name'>
                        {data.name}
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
                                {data.subcategory.category.name}
                                </span>
                            </div>
                            <div className='product-page__details-item'>
                                <span className='product-page__details-item-header'>
                                    Подкатегория:
                                </span>
                                <span className='product-page__details-item-content'>
                                {data.subcategory.name}
                                </span>
                            </div>
                        </div>
                    </div>

                    <div className='product-page__shop-wrapper'>
                        <FontAwesomeIcon className='product-page__shop-logo ' icon={faShop}/>
                        <div className='product-page__shop-name'>
                            {data.shop.name}
                        </div>
                        <div className='product-page__shop'>
                            Магазин
                        </div>
                    </div>
                </div>
            </div>
            <div className='product-page__price-area'>
                <div className='product-page__price-wrapper'>
                    <div className='product-page__price'>{data.price}₽</div>
                    <button className='product-page__button-to-cart'>Добавить в корзину</button>
                </div>
            </div>
            <div className='product-page__description-area'>{data.description}</div>
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

export default ProductPage;