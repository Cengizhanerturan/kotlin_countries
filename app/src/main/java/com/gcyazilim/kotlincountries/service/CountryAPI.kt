package com.gcyazilim.kotlincountries.service

import com.gcyazilim.kotlincountries.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPI {
    //? GET, POST

    //? https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //? BASE_URL -> https://raw.githubusercontent.com/
    //? EXT -> atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    //? RxJava
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>

    //? Coroutine
    //@GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    //suspend fun getCountries(): Response<List<Country>>

}