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
    const navigate = useNavigate();

    const toPrevPage = () =>{
        navigate(`/catalog?page=${page-1}`)
    }

    const toNextPage = () =>[
        navigate(`/catalog?page=${page+1}`)
    ]
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

const DropdownPriceMenu = ({className, header, priceFrom, priceTo, setPriceFrom, setPriceTo}) =>{

    const [currentIcon, setCurrentIcon] = useState()
    const [currentHeader, setCurrentHeader] = useState(header);
    const [isOpen, setOpen] = useState(false);

    const toggleOpen = () =>{
        setOpen(!isOpen)
    }

    useEffect(() => {
        if(priceFrom === '' && priceTo === ''){
            setCurrentIcon(faChevronDown)
            setCurrentHeader(header)
        }
        else{
            setCurrentIcon(faXmark)
            if(priceFrom === '' ){
                setCurrentHeader(header + ' < '+priceTo+'₽')
            }
            else if(priceTo === ''){
                setCurrentHeader(header + ' > '+priceFrom+'₽')
            }
            else
            setCurrentHeader(priceFrom+" - "+priceTo+"₽")
        }
    }, [priceFrom, priceTo]);

    return(
        <div className={'dropdown ' + className}>
            <div className={'dropdown__header ' + (isOpen? 'dropdown__header_open' : '')} onClick={toggleOpen}>
                <div className='dropdown__header-name'>{currentHeader}</div>
                <FontAwesomeIcon className='dropdown__header-icon'   icon={currentIcon} onClick={()=>{
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

const DropdownSelectMenu = ({className, header, items, selectedItem, setSelectedItem}) =>{


    const [currentIcon, setCurrentIcon] = useState()
    const [currentHeader, setCurrentHeader] = useState(header);
    const [isOpen, setOpen] = useState(false);

    const toggleOpen = () =>{
        setOpen(!isOpen)
    }

    useEffect(() => {
        if(selectedItem.name === ''){
            setCurrentIcon(faChevronDown)
            setCurrentHeader(header)
        }
        else{
            setCurrentIcon(faXmark)
            setCurrentHeader(selectedItem.name)
        }
    }, [selectedItem]);

    return(
        <div className={'dropdown ' + className}>
            <div className={'dropdown__header ' + (isOpen? 'dropdown__header_open' : '')} onClick={toggleOpen}>
                <div className='dropdown__header-name'>{currentHeader}</div>
                <FontAwesomeIcon className='dropdown__header-icon' onClick={()=>{
                    setSelectedItem({id: '', name: ''})
                }}  icon={currentIcon}/>
            </div>
            <div className={'dropdown__menu ' + (!isOpen? 'dropdown__menu_hidden' : '')}>
                {
                    items !== undefined?
                    items.map((item) =>
                    <div className='dropdown__menu-item' onClick={() => setSelectedItem(item)
                    }>
                        <FontAwesomeIcon className='dropdown__menu-item-icon' icon={(item.id === selectedItem.id ? solidCircle : regularCircle)}/>
                        <div className='dropdown__menu-item-name'>{item.name}</div>
                    </div>)
                        :
                        ''
                }
            </div>
        </div>
    )
}

const Search = ({search, setSearch, submitSearch}) => {

    return (
        <div className='catalog__search'>
            <input className='catalog__search-input'
                   placeholder='Найти на KION Маркет'
                   type="text"
                   onChange={(e) => {
                       setSearch(e.target.value)
                   }}
                   value={search}/>
            <div className='catalog__search-icon-wrapper' onClick={submitSearch}>
                <FontAwesomeIcon className='catalog__search-icon' icon={faSearch} />
            </div>
        </div>
    )
}

const Catalog = () => {
    const ANY = '';
    const Order = {
        ASC: 'asc',
        DESC: 'desc'
    }
    const SortBy = {
        PRICE: 'price.price',
        DATE: 'id'
    }
    const LIMIT = 10;

    const orders = [
        {id: Order.ASC, name: 'По возрастанию'},
        {id: Order.DESC, name: 'По убыванию'},
    ]

    const sorts =[
        {id: SortBy.DATE, name: 'По новизне'},
        {id: SortBy.PRICE, name: 'По цене'}
    ]

    const Default ={
        id: '',
        name: ''
    }

    const [selectedPage, setSelectedPage] = useState(1);
    const [selectedSort, setSelectedSort] = useState(sorts[0]);
    const [selectedOrder, setSelectedOrder] = useState(orders[0]);
    const [selectedCategory, setSelectedCategory] = useState(Default);
    const [selectedSubcategory, setSelectedSubcategory] = useState(Default);
    const [selectedPriceFrom, setSelectedPriceFrom] = useState(ANY);
    const [selectedPriceTo, setSelectedPriceTo] = useState(ANY);
    const [selectedShop, setSelectedShop] = useState(Default);
    const [selectedSearch, setSelectedSearch] = useState(ANY);

    const [sort, setSort] = useState(selectedSort.id);
    const [order, setOrder] = useState(selectedOrder.id);
    const [category, setCategory] = useState(selectedCategory.id);
    const [subcategory, setSubcategory] = useState(selectedSubcategory.id);
    const [priceFrom, setPriceFrom] = useState(selectedPriceFrom);
    const [priceTo, setPriceTo] = useState(selectedPriceTo);
    const [shop, setShop] = useState(selectedShop.id);
    const [search, setSearch] = useState(selectedSearch);



    const setPage = (page) => {
        setSearchParams({['page'] : page})
    }

    const [searchParams, setSearchParams] = useSearchParams();
    console.log('Search params: ' + searchParams);
    // const params = Object.fromEntries([...searchParams]);


    useEffect(()=>{
        if(searchParams.get('page') === null){
            setPage(1)
        }
        const categoryParam = searchParams.get('category');
        if(categoryParam !== null){
            setCategory(categoryParam)
        }
        let search = searchParams.get('search');
        if(search !== null){
            setSearch(search)
        }
    },[])


    const products = useGetProductsQuery({
        page: searchParams.get('page'),
        limit: LIMIT,
        sort: sort,
        order: order,
        category: category,
        subcategory: subcategory,
        priceFrom: priceFrom,
        priceTo: priceTo,
        shop: shop,
        search: search
    });



    const applyFilters = () =>{
        setPage(1)

        setSelectedSort(selectedSort)
        setSelectedOrder(selectedOrder)
        setSelectedCategory(selectedCategory)
        setSelectedSubcategory(selectedSubcategory)
        setSelectedShop(selectedShop)

        setSort(selectedSort.id)
        setOrder(selectedOrder.id)
        setCategory(selectedCategory.id)
        setSubcategory(selectedSubcategory.id)
        setShop(selectedShop.id)


        setPriceFrom(selectedPriceFrom)
        setPriceTo(selectedPriceTo)


    }

    const resetFilters = () =>{
        setPage(1)

        setSelectedSort(sorts[0])
        setSelectedOrder(orders[0])
        setSelectedCategory(Default)
        setSelectedSubcategory(Default)
        setSelectedShop(Default)
        setSelectedPriceFrom(ANY)
        setSelectedPriceTo(ANY)

        setSort(sorts[0].id)
        setOrder(orders[0].id)
        setCategory(ANY)
        setSubcategory(ANY)
        setShop(ANY)

        setPriceFrom(ANY)
        setPriceTo(ANY)
    }

    useEffect(() => {
        if(selectedCategory.id === ''){
            setSelectedSubcategory(Default)
        }
    }, [selectedCategory]);

    const categories = useGetCategoriesQuery();
    const subcategories = useGetSubcategoriesQuery(selectedCategory.id);
    const shops = useGetShopsQuery();









return (
    products.isSuccess ?
            <div className='catalog'>
                <Search search={selectedSearch} setSearch={setSelectedSearch} submitSearch={null}/>
                <div className='catalog__filters'>
                    <DropdownSelectMenu
                        className='catalog__categories'
                        header='Категория'
                        items={categories.data}
                        selectedItem={selectedCategory}
                        setSelectedItem={setSelectedCategory}/>
                    <DropdownSelectMenu
                        className={(selectedCategory.id === '' ? 'catalog__subcategories':'')}
                        header='Подкатегория'
                        items={subcategories.data}
                        selectedItem={selectedSubcategory}
                        setSelectedItem={setSelectedSubcategory}/>
                    <DropdownSelectMenu
                        className='catalog__sort'
                        header='Сортировать'
                        items={sorts}
                        selectedItem={selectedSort}
                        setSelectedItem={setSelectedSort}/>
                    <DropdownSelectMenu
                        className='catalog__order'
                        header='Упорядочить'
                        items={orders}
                        selectedItem={selectedOrder}
                        setSelectedItem={setSelectedOrder}/>
                    <DropdownSelectMenu
                        className=''
                        header='Магазин'
                        items={shops.data}
                        selectedItem={selectedShop}
                        setSelectedItem={setSelectedShop}/>
                    <DropdownPriceMenu
                        className='catalog__price-range'
                        header='Цена'
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
