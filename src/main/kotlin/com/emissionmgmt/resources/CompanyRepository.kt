package com.emissionmgmt.resources 

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class CompanyRepository : PanacheRepository<Company> {

    // Define custom query methods here (optional)
    fun findByCompanyName(companyName: String) = list("companyName = '$companyName'")
}