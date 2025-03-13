package com.Piatto.Services;


import com.Piatto.Dtos.LicensePlateDto;
import com.Piatto.Models.LicensePlate;
import com.Piatto.Repositories.LicensePlateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicensePlateService {

    @Autowired
    LicensePlateRepository licensePlateRepository;

    public List<LicensePlate> findAll(){
        return licensePlateRepository.findAll();
    }

    public LicensePlate findById(UUID id){
        return licensePlateRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot be found"));
    }

    public LicensePlate createLicensePlate(LicensePlateDto licensePlateDto){
        var licensePlate = new LicensePlate();
        BeanUtils.copyProperties(licensePlateDto,licensePlate);
        return licensePlateRepository.save(licensePlate);
    }
    public LicensePlate updateLicensePlate(UUID id, LicensePlateDto licensePlateDto){
        var licensePlate = findById(id);
        BeanUtils.copyProperties(licensePlateDto, licensePlate);
        return licensePlateRepository.save(licensePlate);
    }
    public void deleteLicensePlate(UUID id){
        var licensePlate = findById(id);
        licensePlateRepository.delete(licensePlate);
    }
}
