package com.gearhead.busyboard.company.service;

import com.gearhead.busyboard.company.dto.CompanyRequestDTO;
import com.gearhead.busyboard.company.dto.CompanyResponseDTO;
import com.gearhead.busyboard.company.entity.Company;
import com.gearhead.busyboard.company.mapper.CompanyMapper;
import com.gearhead.busyboard.company.repo.CompanyRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper mapper;

    public CompanyService(CompanyRepository companyRepository,
                          CompanyMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    public CompanyResponseDTO createCompany(CompanyRequestDTO requestDTO) {

        Company company = mapper.toEntity(requestDTO);
        Company saved = companyRepository.save(company);
        return mapper.toResponseDTO(saved);
    }
    
    public CompanyResponseDTO getCompany(int id){
        Optional<Company> company=companyRepository.findById(id);
        if (company.isEmpty()){
            throw new RuntimeException("Company not found with the id:"+id);
        }
        return mapper.toResponseDTO(company.get());
    }

    public CompanyResponseDTO updateCompany(int id, CompanyRequestDTO companyRequestDTO){
        Company company = companyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Company not found with id: " + id));

        Optional.ofNullable(companyRequestDTO.name()).ifPresent(company::setName);
        Optional.ofNullable(companyRequestDTO.subscriptionPlan()).ifPresent(company::setSubscriptionPlan);


        Company updated = companyRepository.save(company);

        return mapper.toResponseDTO(updated);
    }

    public List<CompanyResponseDTO> getAllCompanies(){
        List<Company> companies=companyRepository.findAll();
        return companies.stream().map(mapper::toResponseDTO).toList();
    }
}

