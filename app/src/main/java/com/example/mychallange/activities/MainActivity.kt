package com.example.mychallange.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mychallange.R
import com.example.mychallange.adapters.ChallengeAdapter
import com.example.mychallange.json.MockedJson
import com.example.mychallange.models.Establishment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = ChallengeAdapter(
            getEstablishmentsFromJson()
        )

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
    }

    private fun getEstablishmentsFromJson(): MutableList<Establishment>{
        val gson = Gson()
        val establishmentType = object: TypeToken<MutableList<Establishment>>() {}.type
        return gson.fromJson(MockedJson.json, establishmentType)
    }
}
