import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSearch} from "@fortawesome/free-solid-svg-icons";
import React from "react";
import './SearchBar.css'

const SearchBar = ({search, setSearch, submitSearch}) => {

    return (
        <form className='search-bar' onSubmit={submitSearch}>
            <input className='search-bar__input'
                   placeholder='Найти на KION Маркет'
                   type="text"
                   onChange={(e) => {
                       setSearch(e.target.value)
                   }}
                   value={search}/>
            <div className='search-bar__icon-wrapper' onClick={submitSearch} >
                <FontAwesomeIcon className='search-bar__icon' icon={faSearch} />
            </div>
        </form>
    )
}

export default SearchBar;