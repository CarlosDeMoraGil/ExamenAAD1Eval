package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.User

class ModelsXmlLocalDataSource(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "db-examen", Context.MODE_PRIVATE
    )

    private val edit = sharedPref.edit()
    private val gson = Gson()


    fun saveUsers(users: List<User>) {
        edit.apply {

            users.forEach {
                putString("user", gson.toJson(it))
            }

            apply()

        }


    }

    fun findUsers(): List<User> {
        val fileInfo = sharedPref.all
        val users = ArrayList<User>()

        fileInfo.forEach { info ->
            sharedPref.getString("user", null)?.let {
                val user = gson.fromJson(it, User::class.java)
                users.add(user)
            }

        }

        return users
    }

    fun clear() {
        sharedPref.edit().clear().apply()
    }

}