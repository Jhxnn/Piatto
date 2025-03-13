package com.Piatto.Controllers;

import com.Piatto.Dtos.OwnerDto;
import com.Piatto.Models.Owner;
import com.Piatto.Repositories.OwnerRepository;
import com.Piatto.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/all")
    public ResponseEntity<List<Owner>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> findById(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@RequestBody OwnerDto ownerDto,
                                             @PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.updateOwner(id, ownerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Owner> deleteOwner(@PathVariable(name = "id") UUID id){
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
