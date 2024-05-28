
import React, {useEffect} from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faHeart, faStar} from '@fortawesome/free-solid-svg-icons'
import { useSelector } from "react-redux";
import { useState } from "react";
import {useNavigate} from "react-router-dom";
import { selectUserId } from "../../../../features/auth/model/authSlice";
import { useAddFavoriteMutation, useRemoveFavoriteMutation } from "../../api/ProductApi";
import "./ProductCard.css"

const ProductCard = ({ product }) => {

const [isFavorite, setIsFavorite] = useState(product.isFavorite);
const navigate = useNavigate();

const [addFavorite] = useAddFavoriteMutation();
const [removeFavorite] = useRemoveFavoriteMutation();
const userId = useSelector(selectUserId);

  const toggleFavorite = async () =>{
    const productId = product.id;
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

  const getReviewsAndName = (reviewCount) => {
      let word = ' отзывов'
      if(!(reviewCount > 10 && reviewCount < 20)){
          const lastDigit = reviewCount < 10 ? reviewCount : reviewCount % 10;
          switch(lastDigit){
              case 1:
                  word = ' отзыв';
                  break;
              case 2:
              case 3:
              case 4:
                  word = ' отзыва';
                  break;
          }
      }
      return reviewCount + word;
  }

  const courseProductPage = () => {
      navigate(`/product/${product.id}`)
  }

  return (
    <div className="product-card" >

        <div className='product-card__image-wrapper' onClick={courseProductPage}>
            <img className="product-card__image"  src={product.images[0]?`data:image/webp;base64,${product.images[0]}`:"/images/default-product-image.jpg"} alt="Изображение продукта"/>
        </div>
        <div className="product-card__price" onClick={courseProductPage}>{product.price}₽</div>
        <div className={(product.averageRating === null ? 'product-card__review-count_hidden' : '') +' product-card__review-count'}>{getReviewsAndName(product.reviewCount)}</div>
        <FontAwesomeIcon className={(product.averageRating === null ? 'product-card__star-icon_hidden' : '') +' product-card__star-icon'} icon={faStar} />
        <div className={(product.averageRating === null ? 'product-card__rating_hidden' : '') +' product-card__rating'}>{(Math.round(product.averageRating * 10) / 10).toFixed(1)}</div>
        <div className="product-card__name" onClick={courseProductPage}>{product.name}</div>
        <FontAwesomeIcon onClick={toggleFavorite} className={'product-card__is-favorite-icon ' + (isFavorite ? 'product-card__is-favorite-icon_true':'product-card__is-favorite-icon_false')} icon={faHeart}/>
      
    </div>
  );
};

export default ProductCard;
