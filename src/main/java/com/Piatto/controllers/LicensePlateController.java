package com.Piatto.controllers;

import com.Piatto.dtos.LicensePlateDto;
import com.Piatto.models.LicensePlate;
import com.Piatto.services.LicensePlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/license-plate")
public class LicensePlateController {

    @Autowired
    LicensePlateService licensePlateService;


    @GetMapping("/all")
    public ResponseEntity<List<LicensePlate>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(licensePlateService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LicensePlate> findById(@PathVariable(name = "id")UUID id){
        return  ResponseEntity.status(HttpStatus.OK).body(licensePlateService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LicensePlate> updateLicensePlate(@RequestBody LicensePlateDto licensePlateDto,
                                                           @PathVariable(name = "id")UUID id){
        return ResponseEntity.status(HttpStatus.CREATED).body(licensePlateService.updateLicensePlate(id,licensePlateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LicensePlate> deleteLicensePlate(@PathVariable(name = "id")UUID id){
        licensePlateService.deleteLicensePlate(id);
        return ResponseEntity.noContent().build();
    }


}
