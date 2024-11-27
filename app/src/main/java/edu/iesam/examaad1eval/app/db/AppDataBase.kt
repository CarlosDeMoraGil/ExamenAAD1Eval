package edu.iesam.examaad1eval.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.Converters
import edu.iesam.examaad1eval.features.ex2.data.local.GamesDao
import edu.iesam.examaad1eval.features.ex2.data.local.GamesEntity

@Database(entities = [GamesEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun provideGameDao(): GamesDao

}