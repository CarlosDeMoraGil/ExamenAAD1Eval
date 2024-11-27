package edu.iesam.examaad1eval.app.db

import android.content.Context
import androidx.room.Room

class ProviderDb() {

    fun providerDb(context: Context): AppDataBase {
        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "GAMES"
        ).fallbackToDestructiveMigration()
            .build()

        return db

    }

}