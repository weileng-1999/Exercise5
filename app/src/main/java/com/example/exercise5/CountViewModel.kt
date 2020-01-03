package com.example.exercise5

import android.util.Log
import androidx.lifecycle.ViewModel


class CountViewModel : ViewModel() {
    var countLike: Int = 0
    var countDislike: Int = 0
    init {
        Log.d("ViewModel", "ViewModel created")
    }

    fun plusLike(){
        countLike++
    }

    fun plusDislike() {
        countDislike++
    }

    override fun onCleared() {
        Log.d("ViewModel", "ViewModel destroyed")
        super.onCleared()
    }
}