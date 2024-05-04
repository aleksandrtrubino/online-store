import React, {useEffect, useState} from "react";
import {faChevronDown, faXmark} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import './DropdownPriceMenu.css'

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
            <div className={'dropdown-price-menu__header ' + (isOpen? 'dropdown-price-menu__header_open' : '')} onClick={toggleOpen}>
                <div className='dropdown-price-menu__header-name'>{header}</div>
                <FontAwesomeIcon className='dropdown-price-menu__header-icon'   icon={headerIcon} onClick={()=>{
                    setPriceTo('')
                    setPriceFrom('')
                }
                }/>
            </div>
            <div className={'dropdown-price-menu__menu ' + (!isOpen? 'dropdown-price-menu__menu_hidden' : '')}>
                <div className='dropdown-price-menu__menu-item' >
                    <div className='dropdown-price-menu__menu-item-name'>От</div>
                    <input className='dropdown-price-menu__menu-input'
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
                <div className='dropdown-price-menu__menu-item' >
                    <div className='dropdown-price-menu__menu-item-name'>До</div>
                    <input className='dropdown-price-menu__menu-input'
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

export default DropdownPriceMenu;