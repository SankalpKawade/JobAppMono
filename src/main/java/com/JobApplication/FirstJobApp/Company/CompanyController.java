package com.JobApplication.FirstJobApp.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("Update Complete!!!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCompany (@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Created!!!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompany(id);
        if (isDeleted){
            return new ResponseEntity<>("Deleted!!!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyService.getCompany(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
