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
        String name = addressTypeDto.getName();
        AddressType addressType = new AddressType(name);
        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType update(Long addressTypeId, AddressTypeDto addressTypeDto) {
        AddressType addressType = addressTypeRepository.findById(addressTypeId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressTypeId)));
        addressType.setName(addressTypeDto.getName());
        return addressTypeRepository.save(addressType);
    }

    @Override
    public AddressType findById(Long addressTypeId) {
        return addressTypeRepository.findById(addressTypeId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressTypeId)));
    }

    @Override
    public List<AddressType> findAll() {
        return addressTypeRepository.findAll();
    }

    @Override
    public void deleteById(Long addressTypeId) {
        addressTypeRepository.deleteById(addressTypeId);
    }

    @Override
    public Set<Address> getAddresses(Long addressTypeId) {
        AddressType addressType = addressTypeRepository.findById(addressTypeId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressTypeId)));
        return addressType.getAddresses();
    }
}
