import React, {useState, useEffect} from 'react'
import { ProductList } from '../../widgets/productList/ProductList';
import {useNavigate, useSearchParams} from "react-router-dom";
import {useGetProductsQuery} from "../../entities/product/api/ProductApi";
import {useGetCategoriesQuery, useGetSubcategoriesQuery} from "../../entities/category/api/CategoryApi";
import {useGetShopsQuery} from "../../entities/shop/api/ShopApi";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faChevronRight, faChevronLeft, faChevronDown, faXmark, faSearch, faCircle as solidCircle} from '@fortawesome/free-solid-svg-icons'
import {faCircle as regularCircle} from "@fortawesome/free-regular-svg-icons";
import './Catalog.css'


const PageSlider = ({page, maxPage}) =>{
    const [searchParams, setSearchParams] = useSearchParams()

    const toPrevPage = () =>{
        searchParams.set('page',`${page - 1}`)
        setSearchParams(searchParams)
    }

    const toNextPage = () => {
        searchParams.set('page', `${page + 1}`)
        setSearchParams(searchParams)
    }
    return(
        <div className='catalog__page-slider'>
            <div onClick={toPrevPage}  className={'catalog__left-arrow-wrapper ' + (page === 1 ? 'catalog__left-arrow-wrapper_hidden':'')}>
                <FontAwesomeIcon className='catalog__left-arrow ' icon={faChevronLeft}/>
            </div>
            <div className='catalog__page-number'>{page}</div>
            <div onClick={toNextPage} className={'catalog__right-arrow-wrapper '+ (page === maxPage ? 'catalog__right-arrow-wrapper_hidden':'')}>
                <FontAwesomeIcon className='catalog__right-arrow '  icon={faChevronRight}/>
            </div>
        </div>
    )
}

const DropdownPriceMenu = ({className, defaultHeader, priceFrom, priceTo, setPriceFrom, setPriceTo}) =>{

    const [headerIcon, setHeaderIcon] = useState()
    const [header, setHeader] = useState(defaultHeader);
    const [isOpen, setOpen] = useState(false);

    const toggleOpen = () =>{
        setOpen(!isOpen)
    }

    useEffect(() => {
        if(priceFrom === '' && priceTo === ''){
            setHeaderIcon(faChevronDown)
            setHeader(defaultHeader)
        }
        else{
            setHeaderIcon(faXmark)
            if(priceFrom === '' ){
                setHeader(defaultHeader + ' < '+priceTo+'₽')
            }
            else if(priceTo === ''){
                setHeader(defaultHeader + ' > '+priceFrom+'₽')
            }
            else
            setHeader(priceFrom+" - "+priceTo+"₽")
        }
    }, [priceFrom, priceTo]);

    return(
        <div className={'dropdown ' + className}>
            <div className={'dropdown__header ' + (isOpen? 'dropdown__header_open' : '')} onClick={toggleOpen}>
                <div className='dropdown__header-name'>{header}</div>
                <FontAwesomeIcon className='dropdown__header-icon'   icon={headerIcon} onClick={()=>{
                    setPriceTo('')
                    setPriceFrom('')
                }
                }/>
            </div>
            <div className={'dropdown__menu ' + (!isOpen? 'dropdown__menu_hidden' : '')}>
                    <div className='dropdown__menu-item' >
                        <div className='dropdown__menu-item-name'>От</div>
                        <input className='dropdown__menu-input'
                            type="number"
                            onChange={(e) => {
                                if(e.target.value === '0' || e.target.value.startsWith('0')) {
                                    setPriceFrom('')
                                }
                                else {
                                    setPriceFrom(e.target.value);
                                }
                            }}
                            value={priceFrom}
                        />
                    </div>
                    <div className='dropdown__menu-item' >
                        <div className='dropdown__menu-item-name'>До</div>
                        <input className='dropdown__menu-input'
                            type="number"
                            onChange={(e) => {
                                if(e.target.value === '0' || e.target.value.startsWith('0')) {
                                    setPriceTo('')
                                }
                                else {
                                    setPriceTo(e.target.value);
                                }
                            }}
                            value={priceTo}
                        />
                    </div>
            </div>
        </div>
    )
}

const DropdownSelectMenu = ({className, defaultHeader, items, itemId, setItemId}) =>{

    const [headerIcon, setHeaderIcon] = useState()
    const [header, setHeader] = useState(defaultHeader);
    const [item, setItem] = useState();
    const [isOpen, setOpen] = useState(false);

    const toggleOpen = () =>{
        setOpen(!isOpen)
    }

    useEffect(() => {
        if(itemId !== '')
            setItem(items.find(item => item.id === itemId))
        else
            setItem(undefined)
    }, [itemId]);

    useEffect(() => {
        if(item === undefined){
            setHeaderIcon(faChevronDown)
            setHeader(defaultHeader)
        }
        else{
            setHeaderIcon(faXmark)
            setHeader(item.name)
        }
    }, [item]);

    return(
        <div className={'dropdown ' + className}>
            <div className={'dropdown__header ' + (isOpen? 'dropdown__header_open' : '')} onClick={toggleOpen}>
                <div className='dropdown__header-name'>{header}</div>
                <FontAwesomeIcon className='dropdown__header-icon' onClick={()=>{
                    setItemId('')
                }}  icon={headerIcon}/>
            </div>
            <div className={'dropdown__menu ' + (!isOpen? 'dropdown__menu_hidden' : '')}>
                {
                    items !== undefined?
                    items.map((item) =>
                    <div className='dropdown__menu-item' onClick={() => setItemId(item.id)
                    }>
                        <FontAwesomeIcon className='dropdown__menu-item-icon' icon={(item.id === itemId ? solidCircle : regularCircle)}/>
                        <div className='dropdown__menu-item-name'>{item.name}</div>
                    </div>)
                        :
                        <></>
                }
            </div>
        </div>
    )
}

const Search = ({search, setSearch, submitSearch}) => {

    return (
        <form className='catalog__search' onSubmit={submitSearch}>
            <input className='catalog__search-input'
                   placeholder='Найти на KION Маркет'
                   type="text"
                   onChange={(e) => {
                       setSearch(e.target.value)
                   }}
                   value={search}/>
            <div className='catalog__search-icon-wrapper' onClick={submitSearch} >
                <FontAwesomeIcon className='catalog__search-icon' icon={faSearch} />
            </div>
        </form>
    )
}

const Catalog = () => {

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
        search: getUrlParam('search')
    });

    const categories = useGetCategoriesQuery();
    const subcategories = useGetSubcategoriesQuery(selectedCategoryId);
    const shops = useGetShopsQuery();

    useEffect(()=>{
        if(getUrlParam('page') === ''){
            setUrlParam('page',1)
        }
        if(getUrlParam('sort') === ''){
            setUrlParam('sort', Sort.BY_DATE)
        }
        if(getUrlParam('order') === ''){
            setUrlParam('order', Order.ASC)
        }

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

        setUrlParam('page',1)
        setUrlParam('sort', Sort.BY_DATE)
        setUrlParam('order', Order.ASC)

        setSearchParams(searchParams)
    }

    const applySearch = () =>{
        if(selectedSearch !== '')
            searchParams.set('search', selectedSearch)
        else
            searchParams.delete('search')
        searchParams.set('page','1')
        setSearchParams(searchParams)

    }

    const resetSearch = () => {
        searchParams.delete('search')
        setSearchParams(searchParams)
    }


return (
    products.isSuccess ?
            <div className='catalog'>
                <Search search={selectedSearch} setSearch={setSelectedSearch} submitSearch={applySearch}/>
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

export default Catalog
