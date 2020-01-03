package com.example.exercise5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var countviewmodel: CountViewModel
    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")
        //Initialize the counter ViewModel
        countviewmodel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Initialise the shared preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        imageViewLike.setOnClickListener {
            countviewmodel.plusLike()
            textViewLike.text = countviewmodel.countLike.toString()
        }

        imageViewDislike.setOnClickListener {
            countviewmodel.plusDislike()
            textViewDislike.text = countviewmodel.countDislike.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")

        val like = sharedPreferences.getInt(getString(R.string.like), 0)
        val dislike = sharedPreferences.getInt(getString(R.string.dislike), 0)

        countviewmodel.countLike = like
        countviewmodel.countDislike = dislike

        textViewLike.text = countviewmodel.countLike.toString()
        textViewDislike.text = countviewmodel.countDislike.toString()

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")

        //To store the data of like and dislike
        with(sharedPreferences.edit()) {
            putInt(getString(R.string.like), countviewmodel.countLike)
            putInt(getString(R.string.dislike), countviewmodel.countDislike)
            commit()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}