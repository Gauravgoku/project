package com.myProject.project.crud.controller;

import com.myProject.project.crud.domainDto.crudDomainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class crudController {
    @Autowired
    private com.myProject.project.crud.service.crudService crudService;

    @PostMapping("/")
    public ResponseEntity<List<crudDomainDto>> saveUser(@RequestBody crudDomainDto crudDomainDto) {
    crudDomainDto crudDomainDto1 =crudService.saveUser(crudDomainDto);
        return ResponseEntity.ok(Collections.singletonList(crudDomainDto1));
    }

    @PutMapping("/update")
    public ResponseEntity<List<crudDomainDto>> updateUser(@RequestBody crudDomainDto crudDomainDto) {
        crudDomainDto crudDomainDto1 = crudService.updateUser(crudDomainDto);
        return ResponseEntity.ok(Collections.singletonList(crudDomainDto1));
    }

    @GetMapping("/get")
    public ResponseEntity<List<crudDomainDto>> fetchAllUser(@RequestParam String crudName) {
        crudDomainDto crudDomainDto = crudService.getUser(crudName);
        if (crudName != null || crudName.isEmpty()) {
            return ResponseEntity.ok(Collections.singletonList(crudDomainDto));
        }
        return ResponseEntity.notFound().build();
    }

        @DeleteMapping("/delete")
        public ResponseEntity<List<crudDomainDto>> userDelete(@RequestParam String crudId) {
            crudDomainDto crudDomainDto = crudService.userDelete(crudId);
            if (crudId != null || crudId.isEmpty()) {
                return ResponseEntity.ok(Collections.singletonList(crudDomainDto));
            }
            return ResponseEntity.notFound().build();
        }


    }

