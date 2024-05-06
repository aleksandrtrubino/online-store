import {useSearchParams} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faChevronLeft, faChevronRight} from "@fortawesome/free-solid-svg-icons";
import React from "react";
import './PageSlider.css'

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
        <div className={(maxPage === 1 ? 'page-slider_hidden' : '') + ' page-slider'}>
            <div onClick={toPrevPage}  className={'page-slider__left-arrow-wrapper ' + (page === 1 ? 'page-slider__left-arrow-wrapper_hidden':'')}>
                <FontAwesomeIcon className='page-slider__left-arrow ' icon={faChevronLeft}/>
            </div>
            <div className='page-slider__page-number'>{page}</div>
            <div onClick={toNextPage} className={'page-slider__right-arrow-wrapper '+ (page === maxPage ? 'page-slider__right-arrow-wrapper_hidden':'')}>
                <FontAwesomeIcon className='page-slider__right-arrow '  icon={faChevronRight}/>
            </div>
        </div>
    )
}

export default PageSlider;