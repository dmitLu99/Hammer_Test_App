package com.example.hammertestapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _items = MutableLiveData<List<SimpleItem>>().apply {
        value = List(size = 12) { index ->  SimpleItem(text = "text ${index}") }
    }
    val items: LiveData<List<SimpleItem>> = _items
}

data class SimpleItem(val text: String)