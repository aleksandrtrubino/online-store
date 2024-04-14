import React from "react";
import "./ProductGridItem.css"

const ProductGridItem = ({ product }) => {
  return (
    <div className="product-grid-item">
    
      <h3>{product.name}</h3>
      <div>{product.description}</div>
    </div>
  );
};

export default ProductGridItem;
