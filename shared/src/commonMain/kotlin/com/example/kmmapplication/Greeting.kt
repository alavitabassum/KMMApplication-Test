package com.example.kmmapplication

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.datetime.*

class Greeting {

    val httpClient = HttpClient()
    suspend fun greeting(): String {
        return "${getHello()}, ${Platform().platform}!"+
                "There are only ${daysUntilNewYear()} days left!"
    }

    private suspend fun getHello(): String{
        val response: HttpResponse = httpClient.get("https://teamtreehouse.com/matthew.json")
        return response.readText()
    }
}



fun daysUntilNewYear():Int{
    val today = Clock.System.todayAt(TimeZone.currentSystemDefault())
    val closestNewYear = LocalDate(today.year + 1, 1, 1)
    return today.daysUntil(closestNewYear)
}