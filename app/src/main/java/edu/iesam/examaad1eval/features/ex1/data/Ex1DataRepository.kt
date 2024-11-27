package edu.iesam.examaad1eval.features.ex1.data

import android.util.Log
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val local: Ex1XmlLocalDataSource,
    private val remote: MockEx1RemoteDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val localData = local.findUsers()

        if (localData.isEmpty()) {
            val remote = remote.getUsers()

            local.saveUsers(remote)

            Log.d("@dev", remote.toString())
            return remote

        } else {
            Log.d("@dev", localData.toString())
            return localData
        }

    }

    override fun getItems(): List<Item> {
        TODO("Not yet implemented")
    }

    override fun getServices(): List<Services> {
        TODO("Not yet implemented")
    }


}