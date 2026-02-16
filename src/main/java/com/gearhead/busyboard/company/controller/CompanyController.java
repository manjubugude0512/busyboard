package com.gearhead.busyboard.company.controller;

import com.gearhead.busyboard.company.dto.CompanyRequestDTO;
import com.gearhead.busyboard.company.dto.CompanyResponseDTO;
import com.gearhead.busyboard.company.entity.Company;
import com.gearhead.busyboard.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
