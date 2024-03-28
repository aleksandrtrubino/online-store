package ru.vistar.kionmarket.street;

import java.util.List;


//streets
public interface StreetService {
    public Street create(StreetDto streetDto);// POST
    public Street update(Long streetId, StreetDto streetDto);//{streetId} PUT
    public Street findById(Long streetId);//{streetId} GET
    public List<Street> findAll();// GET
    public void deleteById(Long streetId);//{streetId} DELETE
}
