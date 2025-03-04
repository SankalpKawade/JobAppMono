package com.JobApplication.FirstJobApp.Company.impl;

import com.JobApplication.FirstJobApp.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
