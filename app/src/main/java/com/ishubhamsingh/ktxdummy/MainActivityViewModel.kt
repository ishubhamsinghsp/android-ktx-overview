package com.ishubhamsingh.ktxdummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Created by Shubham Singh on 1/2/21.
 */
class MainActivityViewModel(): ViewModel() {

    fun getText():String {
        return "hello"
    }

    fun dummyAsyncTask() {
        viewModelScope.launch {
            // Do Something Async
        }
    }
}