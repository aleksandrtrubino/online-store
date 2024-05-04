import React, {useEffect, useState} from "react";
import {faChevronDown, faCircle as solidCircle, faXmark} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCircle as regularCircle} from "@fortawesome/free-regular-svg-icons";
import './DropdownSelectMenu.css'

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
        <div className={className + ' dropdown-select-menu'}>
            <div className={'dropdown-select-menu__header ' + (isOpen? 'dropdown-select-menu__header_open' : '')} onClick={toggleOpen}>
                <div className='dropdown-select-menu__header-name'>{header}</div>
                <FontAwesomeIcon className='dropdown-select-menu__header-icon' onClick={()=>{
                    setItemId('')
                }}  icon={headerIcon}/>
            </div>
            <div className={'dropdown-select-menu__menu ' + (!isOpen? 'dropdown-select-menu__menu_hidden' : '')}>
                {
                    items !== undefined?
                        items.map((item) =>
                            <div className='dropdown-select-menu__menu-item' onClick={() => setItemId(item.id)
                            }>
                                <FontAwesomeIcon className='dropdown-select-menu__menu-item-icon' icon={(item.id === itemId ? solidCircle : regularCircle)}/>
                                <div className='dropdown-select-menu__menu-item-name'>{item.name}</div>
                            </div>)
                        :
                        <></>
                }
            </div>
        </div>
    )
}

export default DropdownSelectMenu;