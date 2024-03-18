package com.emissionmgmt.resources

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
data class Company(
    var companyName: String = "",
    var naceCode: String = "",
    var gva: Double = 0.00,
    var scope1Emissions: Double = 0.00,
    var scope2Emissions: Double = 0.00,
    var scope3Emissions: Double = 0.00
) : PanacheEntity()