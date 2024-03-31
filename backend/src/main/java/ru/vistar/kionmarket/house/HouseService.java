package ru.vistar.kionmarket.house;

import java.util.List;

//houses
public interface HouseService {
    public House create(HouseDto houseDto);// POST
    public House update(Long houseId, HouseDto houseDto);//{houseId} PUT
    public House findById(Long houseId);//{houseId} GET
    public List<House> findAll();//houses GET
    public void deleteById(Long houseId);//houses/{houseId} DELETE
}
