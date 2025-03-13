package com.Piatto.services;

import com.Piatto.dtos.OwnerDto;
import com.Piatto.models.Owner;
import com.Piatto.repositories.OwnerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    public Owner findById(UUID id){
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot be found"));
    }

    public Owner createOwner(OwnerDto ownerDto){
        var owner = new Owner();
        BeanUtils.copyProperties(ownerDto, owner);
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(UUID id, OwnerDto ownerDto){
        var owner = findById(id);
        BeanUtils.copyProperties(ownerDto, owner);
        return ownerRepository.save(owner);
    }

    public void deleteOwner(UUID id){
        var owner = findById(id);
        ownerRepository.delete(owner);
    }

}
