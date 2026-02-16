package com.gearhead.busyboard.company.mapper;

import com.gearhead.busyboard.company.dto.CompanyRequestDTO;
import com.gearhead.busyboard.company.dto.CompanyResponseDTO;
import com.gearhead.busyboard.company.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toEntity(CompanyRequestDTO dto) {
        Company company = new Company();
        company.setName(dto.name());
        company.setSubscriptionPlan(dto.subscriptionPlan());
        return company;
    }

    public CompanyResponseDTO toResponseDTO(Company company) {
        return new CompanyResponseDTO(
                company.getId(),
                company.getName(),
                company.getSubscriptionPlan()
        );
    }
}
