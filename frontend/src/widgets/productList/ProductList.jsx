import React from "react";
import { useGetProductListQuery } from "../../entities/product/api/ProductApi";
import ProductGridItem from "../../entities/product/ui/productCard/ProductGridItem";
import "./ProductList.css"

export const ProductList = () => {
  const {
    data: products,
    isLoading,
    isSuccess,
    isError,
    error,
  } = useGetProductListQuery();

  let content;

  if (isLoading) {
    content = <p>loading...</p>;
  } else if (isSuccess) {
    content = products.map((product) => <ProductGridItem key = {product.id} product={product} />);
  } else if (isError) {
    content = <div>{error.toString()}</div>;
  }

  return (
    <div className="product-list">
      {content}
    </div>
  );
};
