package com.emissionmgmt.resources

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.transaction.Transactional


@Path("/companies")
class CompanyResource(val repository: CompanyRepository) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getCompanies(): Response = Response.ok(repository.listAll()).build()

}