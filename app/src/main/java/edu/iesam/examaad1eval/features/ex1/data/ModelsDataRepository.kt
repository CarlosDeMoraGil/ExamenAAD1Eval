package edu.iesam.examaad1eval.features.ex1.data

import android.util.Log
import edu.iesam.examaad1eval.features.ex1.data.local.ModelsXmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.ModelsRepository
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class ModelsDataRepository(
    private val local: ModelsXmlLocalDataSource,
    private val remote: MockEx1RemoteDataSource
) : ModelsRepository {

    override fun getUsers(): List<User> {
        val localData = local.findUsers()

        val remote = remote.getUsers()

        local.saveUsers(remote)

        if (localData.isEmpty()) {

            local.saveUsers(remote)

            Log.d("@dev", localData.toString())
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