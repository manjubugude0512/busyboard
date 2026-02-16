package com.gearhead.busyboard.company.service;

import com.gearhead.busyboard.company.dto.CompanyRequestDTO;
import com.gearhead.busyboard.company.dto.CompanyResponseDTO;
import com.gearhead.busyboard.company.entity.Company;
import com.gearhead.busyboard.company.mapper.CompanyMapper;
import com.gearhead.busyboard.company.repo.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;


@Service
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    public CompanyService(CompanyRepository repository,
                          CompanyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CompanyResponseDTO createCompany(CompanyRequestDTO requestDTO) {

        Company company = mapper.toEntity(requestDTO);
        company.setCreatedAt(Instant.now());

        Company saved = repository.save(company);
        return mapper.toResponseDTO(saved);
    }
}

