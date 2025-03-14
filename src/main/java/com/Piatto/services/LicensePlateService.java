package com.Piatto.services;


import com.Piatto.dtos.LicensePlateDto;
import com.Piatto.models.LicensePlate;
import com.Piatto.repositories.LicensePlateRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
public class LicensePlateService {

    @Autowired
    LicensePlateRepository licensePlateRepository;

    @Autowired
    private OcrService ocrService;

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

    @Transactional
    public String licensePlateData(MultipartFile file){

        var licensePlate = new LicensePlate();
        String licensePlateValue= ocrService.extractPlateText(file);
        licensePlate.setLicensePlate(licensePlateValue);
        licensePlateRepository.save(licensePlate);
        return licensePlateValue;

        }



}
