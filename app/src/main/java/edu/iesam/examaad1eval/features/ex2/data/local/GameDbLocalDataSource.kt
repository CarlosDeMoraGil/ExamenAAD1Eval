package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game

class GameDbLocalDataSource(private val dao: GamesDao) {

    fun saveAll(list: List<Game>) {

        list.forEach {
            dao.saveAll(it.toEntity())
        }

    }

}