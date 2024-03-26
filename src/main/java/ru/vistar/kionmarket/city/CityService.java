package ru.vistar.kionmarket.city;

import ru.vistar.kionmarket.city.City;
import ru.vistar.kionmarket.city.CityDto;
import java.util.List;

public interface CityService {
    public City create(CityDto cityDto);//addresses/cities
    public City update(Long id, CityDto cityDto);//addresses/cities/{id}
    public City findById(Long id);//addresses/cities/{id}
    public List<City> findAll();//addresses/cities
    public void deleteById(Long id);//addresses/cities/{id}
}
