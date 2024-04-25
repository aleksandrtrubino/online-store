
import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHeart } from '@fortawesome/free-solid-svg-icons'
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

  const courseProductPage = () => {
      navigate(`/catalog/${product.id}`)
  }

  return (
    <div className="product-card">

        <div className='product-card__image-wrapper'>
            <img className="product-card__image" onClick={courseProductPage} src={product.images[0]?`data:image/webp;base64,${product.images[0]}`:"/images/default-product-image.jpg"} alt="Изображение продукта"/>
        </div>
        <div className="product-card__price">{product.price}₽</div>
        <div className="product-card__name">{product.name}</div>
        <FontAwesomeIcon onClick={toggleFavorite} className={'product-card__is-favorite-icon ' + (isFavorite ? 'product-card__is-favorite-icon_true':'product-card__is-favorite-icon_false')} icon={faHeart}/>
      
    </div>
  );
};

export default ProductCard;
