package edu.iesam.examaad1eval.features.ex1.domain

interface ModelsRepository {

    fun getUsers(): List<User>
    fun getItems(): List<Item>
    fun getServices(): List<Services>

}