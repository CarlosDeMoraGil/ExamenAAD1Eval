package edu.iesam.examaad1eval

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.app.db.ProviderDb
import edu.iesam.examaad1eval.features.ex2.data.local.GameDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.GameMockRemoteDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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