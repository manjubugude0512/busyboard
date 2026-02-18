package com.gearhead.busyboard.company.controller;

import com.gearhead.busyboard.company.dto.CompanyRequestDTO;
import com.gearhead.busyboard.company.dto.CompanyResponseDTO;
import com.gearhead.busyboard.company.entity.Company;
import com.gearhead.busyboard.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyResponseDTO> createCompany(
            @RequestBody CompanyRequestDTO requestDTO) {
        CompanyResponseDTO responseDTO= companyService.createCompany(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<CompanyResponseDTO> updateCompany(
           @PathVariable("id") int id, @RequestBody CompanyRequestDTO companyRequestDTO){
        CompanyResponseDTO responseDTO=companyService.updateCompany(id, companyRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping("/getList")
    public  ResponseEntity<List<CompanyResponseDTO>> getAllCompanies(){
        List<CompanyResponseDTO> listDTO=companyService.getAllCompanies();
        return ResponseEntity.status(HttpStatus.FOUND).body(listDTO);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyResponseDTO> getCompany( @PathVariable("id") int id){
        CompanyResponseDTO companyResponseDTO=companyService.getCompany(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(companyResponseDTO);
    }
}
