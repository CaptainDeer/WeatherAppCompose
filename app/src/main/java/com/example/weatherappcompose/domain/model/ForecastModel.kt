package com.example.weatherappcompose.domain.model

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

/**
 * Created by Erik Hernandez on 11/12/2022.
 */
@Entity(tableName = "weather")
data class ForecastModel(
    @ColumnInfo(name = "dateTime") val dateTime: Int = 0,
    @ColumnInfo(name = "cityName") val cityName: String = "",
    @ColumnInfo(name = "temperature") val temperature: Double = 0.0,
    @ColumnInfo(name = "feelsLike") val feelsLike: Double = 0.0,
    @ColumnInfo(name = "weatherName") val weatherName: String = "",
    @ColumnInfo(name = "weatherDescription") val weatherDescription: String = "",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    )

@Dao
interface WeatherDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(forecastModel: ForecastModel)

    @Query("SELECT * FROM weather")
    fun getAll(): MutableList<ForecastModel>

    @Query("DELETE FROM weather")
    fun delete()
}