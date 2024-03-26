package ru.vistar.kionmarket.addresstype;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {

    private final AddressTypeRepository addressTypeRepository;
    public AddressTypeServiceImpl(AddressTypeRepository addressTypeRepository) {
        this.addressTypeRepository = addressTypeRepository;
    }

    @Override
    public AddressType create(AddressTypeDto addressTypeDto) {
        AddressType addressType = new AddressType();
        addressType.setName(addressTypeDto.getName());
        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType update(Long id, AddressTypeDto addressTypeDto) {
        AddressType addressType = addressTypeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("AddressType with id %1$s not found", id)));
        addressType.setName(addressTypeDto.getName());
        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType findById(Long id) {
        AddressType addressType = addressTypeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("AddressType with id %1$s not found",id)));
        return addressType;
    }

    @Override
    public List<AddressType> findAll() {
        return addressTypeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        addressTypeRepository.deleteById(id);
    }

    @Override
    public Set<Address> getAddresses(Long id) {
        AddressType addressType = addressTypeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("AddressType with id %1$s not found", id)));
        return addressType.getAddresses();
    }
}
