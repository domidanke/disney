package com.example.disney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Disney Characters"
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val call: Call<DisneyApiCharacterResponse> = RetrofitInstance.disneyApiService.fetchData()
        call.enqueue(object : Callback<DisneyApiCharacterResponse> {
            override fun onResponse(call: Call<DisneyApiCharacterResponse>, response: Response<DisneyApiCharacterResponse>) {
                if (response.isSuccessful) {
                    val res: DisneyApiCharacterResponse? = response.body()
                    val disneyCharacters = res?.data
                    if (disneyCharacters != null) {
                        val disneyAdapter = DisneyCharacterAdapter(disneyCharacters)
                        recyclerView.adapter = disneyAdapter
                    }
                } else {
                    println("Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<DisneyApiCharacterResponse>, t: Throwable) {
                println("Network request failed: ${t.message}")
            }
        })
    }
}
