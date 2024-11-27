package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.TypeConverter
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Converters {

    @TypeConverter
    fun toEntity(players: List<Player>): String {

        var player: String = players.toString()

        return player

    }

}