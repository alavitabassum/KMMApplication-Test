package com.example.kmmapplication.android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmmapplication.Greeting
import android.widget.TextView
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/*fun greet(): String {
    return Greeting().greeting()
}*/

class MainActivity : AppCompatActivity() {
    private val greeting = Greeting()
    private val mainScope = MainScope()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."

        mainScope.launch{
            kotlin.runCatching {
                greeting.greeting()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = "Error: ${it.localizedMessage}"
            }
        }
    }



}
