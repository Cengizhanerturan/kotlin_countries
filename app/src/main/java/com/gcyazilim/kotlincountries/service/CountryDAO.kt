package com.gcyazilim.kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gcyazilim.kotlincountries.model.Country

@Dao
interface CountryDAO {
    //Data Access Object

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>
    // Insert -> INSERT INTO
    // suspend -> coroutine, pause & resume
    // vararg -> multiple country objects
    // List<Long> -> primary keys

    @Query("Select * From country")
    suspend fun getAllCountries(): List<Country>

    @Query("Select * From country Where uuid = :countryId")
    suspend fun getCountry(countryId: Int): Country

    @Query("Delete From country")
    suspend fun deleteAllCountries()
}