package com.gcyazilim.kotlincountries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gcyazilim.kotlincountries.model.Country

@Database(entities = [Country::class], version = 1)
abstract class CountryDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDAO

    // Companion => Static bir degisken olusturmaya yarıyor, heryerden bu object'e ulasılabılmesını sağlıyor
    companion object {
        //Farklı thread'lerde calıstırılacagı ıcın @Volatile eklendı
        @Volatile
        private var instance: CountryDatabase? = null

        private val lock = Any()

        // Aynı anda ıkı ıslem gerceklestırmesın dıye synchronized kullanıldı
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CountryDatabase::class.java,
            "countrydatabase"
        ).build()
    }
}