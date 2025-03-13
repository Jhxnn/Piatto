package com.Piatto.controllers;

import com.Piatto.dtos.OwnerImageDto;
import com.Piatto.models.OwnerImage;
import com.Piatto.services.OwnerImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/owner-image")
public class OwnerImageController {

    @Autowired
    OwnerImageService ownerImageService;

    @GetMapping("/all")
    public ResponseEntity<List<OwnerImage>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ownerImageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerImage> findById(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(ownerImageService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerImage> updateOwnerImage(@RequestBody OwnerImageDto ownerImageDto,
                                                       @PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerImageService.updateOwnerImage(id, ownerImageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OwnerImage> deleteOwnerImage(@PathVariable(name = "id") UUID id){
        ownerImageService.deleteOwnerImage(id);
        return ResponseEntity.noContent().build();
    }
}
