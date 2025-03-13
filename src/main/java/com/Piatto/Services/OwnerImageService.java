package com.Piatto.Services;

import com.Piatto.Dtos.LicensePlateDto;
import com.Piatto.Dtos.OwnerImageDto;
import com.Piatto.Models.Owner;
import com.Piatto.Models.OwnerImage;
import com.Piatto.Repositories.OwnerImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerImageService {

    @Autowired
    OwnerImageRepository ownerImageRepository;

    public List<OwnerImage> findAll(){
        return ownerImageRepository.findAll();
    }

    public OwnerImage findById(UUID id){
        return ownerImageRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot be found"));
    }

    public OwnerImage createOwnerImage(OwnerImageDto ownerImageDto){
        var ownerImage = new OwnerImage();
        BeanUtils.copyProperties(ownerImageDto,ownerImage);
        return ownerImageRepository.save(ownerImage);
    }

    public OwnerImage updateOwnerImage(UUID id, OwnerImageDto ownerImageDto){
        var ownerImage = findById(id);
        BeanUtils.copyProperties(ownerImageDto, ownerImage);
        return ownerImageRepository.save(ownerImage);
    }

    public void deleteOwnerImage(UUID id){
        var licensePlate = findById(id);
        ownerImageRepository.delete(licensePlate);
    }

}
