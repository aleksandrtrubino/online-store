import React from 'react'
import { useState, useEffect } from 'react';
import { ProductList } from '../../widgets/productList/ProductList';
import {useSearchParams} from "react-router-dom";
import {useGetProductsQuery} from "../../entities/product/api/ProductApi";
import './Catalog.css'



const Catalog = () => {

    const [searchParams, setSearchParams] = useSearchParams();
    console.log('Search params: ' + searchParams);
    // const params = Object.fromEntries([...searchParams]);


    useEffect(()=>{
        if(searchParams.get('page') === null){
            setSearchParams({['page'] :'1'})
        }
    },[])

    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error,
    } = useGetProductsQuery({page: searchParams.get('page'), limit: 10, sort: "id", order: "asc"});


return (
    isSuccess ?
            <div className='catalog'>
                <ProductList className='catalog__product-list' products={data.content}/>
            </div>
        :
        isLoading ? 'loading...'
            :
            isError ?
                'error'
                :
                'undefined '

  
)  
}

export default Catalog
