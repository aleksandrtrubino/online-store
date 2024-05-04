import React, {useState, useEffect} from 'react'
import { ProductList } from '../../widgets/productList/ProductList';
import {useNavigate, useSearchParams} from "react-router-dom";
import {useGetProductsQuery} from "../../entities/product/api/ProductApi";
import {useGetCategoriesQuery, useGetSubcategoriesQuery} from "../../entities/category/api/CategoryApi";
import {useGetShopsQuery} from "../../entities/shop/api/ShopApi";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faChevronRight, faChevronLeft, faChevronDown, faXmark, faSearch, faCircle as solidCircle} from '@fortawesome/free-solid-svg-icons'
import {faCircle as regularCircle} from "@fortawesome/free-regular-svg-icons";
import './Favorites.css'

import PageSlider from "../../widgets/pageSlider/PageSlider";
import DropdownPriceMenu from "../../widgets/dropdownPriceMenu/DropdownPriceMenu";
import DropdownSelectMenu from "../../widgets/dropdownSelectMenu/DropdownSelectMenu";
import SearchBar from "../../widgets/searchBar/SearchBar";



const Favorites = () => {

    const Order = {
        ASC: 'asc',
        DESC: 'desc'
    }
    const Sort = {
        BY_PRICE: 'price.price',
        BY_DATE: 'id'
    }
    const LIMIT = 20;

    const orders = [
        {id: Order.ASC, name: 'По возрастанию'},
        {id: Order.DESC, name: 'По убыванию'},
    ]

    const sorts =[
        {id: Sort.BY_DATE, name: 'По новизне'},
        {id: Sort.BY_PRICE, name: 'По цене'}
    ]

    const navigate = useNavigate()
    const [searchParams, setSearchParams] = useSearchParams();

    const [selectedPage, setSelectedPage] = useState('1');
    const [selectedSortId, setSelectedSortId] = useState(Sort.BY_DATE);
    const [selectedOrderId, setSelectedOrderId] = useState(Order.ASC);
    const [selectedCategoryId, setSelectedCategoryId] = useState('');
    const [selectedSubcategoryId, setSelectedSubcategoryId] = useState('');
    const [selectedShopId, setSelectedShopId] = useState('');
    const [selectedPriceFrom, setSelectedPriceFrom] = useState('');
    const [selectedPriceTo, setSelectedPriceTo] = useState('');
    const [selectedSearch, setSelectedSearch] = useState('');


    const getUrlParam = (name) => {
        const param = searchParams.get(name);
        return param !== null ? param : '';
    }

    const setUrlParam = (name, value) =>{
        if(value !== ''){
            searchParams.set(name, value)
            setSearchParams(searchParams)
        }
    }

    const deleteUrlParam = (name) =>{
        searchParams.delete(name)
        setSearchParams(searchParams)
    }

    const setValueFromUrl = (urlParamName, setValue) =>{
        const param = searchParams.get(urlParamName);
        setValue(param === null ? '' : param)
    }

    let products = useGetProductsQuery({
        page: getUrlParam('page') === '' ? '1' : getUrlParam('page'),
        limit: LIMIT,
        sort: getUrlParam('sort') === '' ? Sort.BY_DATE : getUrlParam('sort'),
        order: getUrlParam('order') === '' ? Order.ASC : getUrlParam('order'),
        category: getUrlParam('category'),
        subcategory: getUrlParam('subcategory'),
        priceFrom: getUrlParam('priceFrom'),
        priceTo: getUrlParam('priceTo'),
        shop: getUrlParam('shop'),
        search: getUrlParam('search'),
        isFavorite: true
    });

    const categories = useGetCategoriesQuery();
    const subcategories = useGetSubcategoriesQuery(selectedCategoryId);
    const shops = useGetShopsQuery();

    useEffect(()=>{
        products.refetch()
        if(getUrlParam('page') === ''){
            searchParams.set('page',1)
        }
        if(getUrlParam('sort') === ''){
            searchParams.set('sort', Sort.BY_DATE)
        }
        if(getUrlParam('order') === ''){
            searchParams.set('order', Order.ASC)
        }
        setSearchParams(searchParams)

        setSelectedPage(getUrlParam('page'))
        setSelectedSortId(getUrlParam('sort'))
        setSelectedOrderId(getUrlParam('order'))
        setSelectedCategoryId(getUrlParam('category'))
        setSelectedSubcategoryId(getUrlParam('subcategory'))
        setSelectedPriceFrom(getUrlParam('priceFrom'))
        setSelectedPriceTo(getUrlParam('priceTo'))
        setSelectedShopId(getUrlParam('shop'))
        setSelectedSearch(getUrlParam('search'))

    },[])


    useEffect(() => {
        if(selectedCategoryId === ''){
            setSelectedSubcategoryId('')
        }
    }, [selectedCategoryId]);


    const applyFilters = () =>{
        setUrlParam('page','1')
        setUrlParam('sort', selectedSortId)
        setUrlParam('order',selectedOrderId)
        setUrlParam('category', selectedCategoryId)
        setUrlParam('subcategory', selectedSubcategoryId)
        setUrlParam('shop',selectedShopId)
        setUrlParam('priceFrom', selectedPriceFrom)
        setUrlParam('priceTo', selectedPriceTo)
    }

    const resetFilters = () =>{

        searchParams.delete('page')
        searchParams.delete('sort')
        searchParams.delete('order')
        searchParams.delete('category')
        searchParams.delete('subcategory')
        searchParams.delete('shop')
        searchParams.delete('priceFrom')
        searchParams.delete('priceTo')

        setSelectedPage('1');
        setSelectedSortId(Sort.BY_DATE);
        setSelectedOrderId(Order.ASC);
        setSelectedCategoryId('');
        setSelectedSubcategoryId('');
        setSelectedShopId('');
        setSelectedPriceFrom('');
        setSelectedPriceTo('');
        setSelectedSearch('');

        searchParams.set('page',1)
        searchParams.set('sort', Sort.BY_DATE)
        searchParams.set('order', Order.ASC)
        setSearchParams(searchParams)

        setSearchParams(searchParams)
    }


    return (
        products.isSuccess ?
            <div className='catalog'>
                <h1 className='favorites__header'>Избранное</h1>
                <div className='catalog__filters'>
                    <DropdownSelectMenu
                        className='catalog__categories'
                        defaultHeader='Категория'
                        items={categories.data}
                        itemId={selectedCategoryId}
                        setItemId={setSelectedCategoryId}/>
                    <DropdownSelectMenu
                        className={(selectedCategoryId === '' ? 'catalog__subcategories':'')}
                        defaultHeader='Подкатегория'
                        items={subcategories.data}
                        itemId={selectedSubcategoryId}
                        setItemId={setSelectedSubcategoryId}/>
                    <DropdownSelectMenu
                        className='catalog__sort'
                        defaultHeader='Сортировать'
                        items={sorts}
                        itemId={selectedSortId}
                        setItemId={setSelectedSortId}/>
                    <DropdownSelectMenu
                        className='catalog__order'
                        defaultHeader='Упорядочить'
                        items={orders}
                        itemId={selectedOrderId}
                        setItemId={setSelectedOrderId}/>
                    <DropdownSelectMenu
                        className=''
                        defaultHeader='Магазин'
                        items={shops.data}
                        itemId={selectedShopId}
                        setItemId={setSelectedShopId}/>
                    <DropdownPriceMenu
                        className='catalog__price-range'
                        defaultHeader='Цена'
                        priceTo={selectedPriceTo}
                        setPriceTo={setSelectedPriceTo}
                        priceFrom={selectedPriceFrom}
                        setPriceFrom={setSelectedPriceFrom}/>
                    <button className='catalog__filters-apply-button' onClick={applyFilters}>Применить</button>
                    <button className='catalog__filters-reset-button' onClick={resetFilters}>Сбросить</button>
                </div>
                <ProductList products={products.data.content}/>
                <PageSlider page={Number(searchParams.get('page'))} maxPage={products.data.totalPages}/>
            </div>
            :
            products.isLoading ? 'loading...'
                :
                products.isError ?
                    'error'
                    :
                    'undefined '


    )
}

export default Favorites
