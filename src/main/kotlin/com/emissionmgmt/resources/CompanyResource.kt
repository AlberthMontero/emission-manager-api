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

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    fun findByCompanyName(
        @QueryParam("companyName") companyName: String
    ): Response = Response.ok(repository.findByCompanyName(companyName)).build()

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createCompany(company: Company): Response {
        repository.persist(company)

        return Response.ok(company).status(201).build()
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateCompany(@PathParam("id") id: Long, updatedCompany: Company): Response {
        val existingCompany = repository.findById(id) ?: return Response.status(Response.Status.NOT_FOUND).build()
        
        // Update the fields of the existingCompany entity with values from updatedCompany
        existingCompany.apply {
            companyName = updatedCompany.companyName
            naceCode = updatedCompany.naceCode
            gva = updatedCompany.gva
            scope1Emissions = updatedCompany.scope1Emissions
            scope2Emissions = updatedCompany.scope2Emissions
            scope3Emissions = updatedCompany.scope3Emissions
        }
        
        // Save the updated entity to the database
        existingCompany.persist()
        
        return Response.ok(existingCompany).build()
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteCompany(@PathParam("id") id: Long): Response {
        val company = repository.findById(id) ?: return Response.status(Response.Status.NOT_FOUND).build()

        repository.delete(company)

        return Response.noContent().build()
    } 
}