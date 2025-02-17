package com.azelder.gqlplayground.data

import com.apollographql.apollo.ApolloClient
import com.azelder.gqlplayground.CountriesQuery
import com.azelder.gqlplayground.CountryQuery
import com.azelder.gqlplayground.domain.CountryClient
import com.azelder.gqlplayground.domain.DetailedCountry
import com.azelder.gqlplayground.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}