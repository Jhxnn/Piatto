package com.Piatto.Services;

import com.Piatto.Dtos.OwnerDto;
import com.Piatto.Models.Owner;
import com.Piatto.Repositories.OwnerRepository;
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

    public Owner createLicensePlate(OwnerDto ownerDto){
        var owner = new Owner();
        BeanUtils.copyProperties(ownerDto, owner);
        return ownerRepository.save(owner);
    }

    public Owner updateLicensePlate(UUID id, OwnerDto ownerDto){
        var owner = findById(id);
        BeanUtils.copyProperties(ownerDto, owner);
        return ownerRepository.save(owner);
    }

    public void deleteLicensePlate(UUID id){
        var owner = findById(id);
        ownerRepository.delete(owner);
    }

}
