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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCompanyById(
        @PathParam("id") id: Long
    ): Response = Response.ok(repository.findById(id)).build()

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createCompany(company: Company): Response {
        repository.persist(company)

        return Response.ok(company).status(201).build()
    }

}