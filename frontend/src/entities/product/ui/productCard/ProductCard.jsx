import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faHeart as solidHeart} from '@fortawesome/free-solid-svg-icons'
import { faHeart as regularHeart} from '@fortawesome/free-regular-svg-icons'
import "./ProductCard.css"

const ProductCard = ({ product }) => {
  return (
    <div className="product-card">
    
      <img className="product-card__image" src={product.images[0]?`data:image/jpeg;base64,${product.images[0]}`:"/images/default-product-image.jpg"} alt="Изображение продукта"/>
      <div className="product-card__price">{product.price}₽</div>
      <div className="product-card__name">{product.name}</div>
      <FontAwesomeIcon className={'product-card__is-favorite-icon ' + (product.isFavorite === true? 'product-card__is-favorite-icon_true':'product-card__is-favorite-icon_false')} icon={regularHeart}/>
      
    </div>
  );
};

export default ProductCard;
