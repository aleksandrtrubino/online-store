import React from "react";
import { useGetProductsQuery } from "../../entities/product/api/ProductApi";
import ProductCard from "../../entities/product/ui/productCard/ProductCard";
import "./ProductList.css"
import { useDispatch } from "react-redux";

export const ProductList = ({products}) => {

  const content = products.map((product) => <ProductCard key = {product.id} product={product} />);

  return (
    <div className="product-list">
      {content}
    </div>
  );
};
