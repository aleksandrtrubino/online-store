import React from 'react'
import { useState, useEffect } from 'react';
import { ProductList } from '../../widgets/productList/ProductList';



const Catalog = () => {
return (
  <div className='catalog'>
    <ProductList />
  </div>
  
)  
}

export default Catalog
