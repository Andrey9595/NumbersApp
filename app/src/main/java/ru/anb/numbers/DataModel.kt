package ru.anb.numbers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {
    val data: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(101)
    }

    fun addNumbers(numbers: Int) {
        data.postValue(numbers)
    }

    fun removeNubers(numbers: Int) {
        data.postValue(numbers)
    }
}