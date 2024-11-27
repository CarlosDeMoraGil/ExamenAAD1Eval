package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.ModelsDataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.ModelsXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import edu.iesam.examaad1eval.app.db.ProviderDb
import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        executeExercise1()

        executeExercise2()


    }

    private fun executeExercise1(){
        val dataRepository =
            ModelsDataRepository(ModelsXmlLocalDataSource(this), MockEx1RemoteDataSource())

        dataRepository.getUsers()

        executeExercise2()

    }

    private fun executeExercise2(){

        val room = GameDbLocalDataSource(
            ProviderDb().providerDb(this).provideGameDao()
        )


        GlobalScope.launch {

            val remoteData = GameMockRemoteDataSource().getGames()

            room.saveAll(remoteData)
        }
    }
}