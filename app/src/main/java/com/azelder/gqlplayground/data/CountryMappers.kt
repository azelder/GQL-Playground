package com.azelder.gqlplayground.data

import com.azelder.gqlplayground.CountriesQuery
import com.azelder.gqlplayground.CountryQuery
import com.azelder.gqlplayground.domain.DetailedCountry
import com.azelder.gqlplayground.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No Capital",
    )

}