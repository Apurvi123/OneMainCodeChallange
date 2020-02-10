package com.onemain.challenge.viewmodel

import androidx.lifecycle.*
import com.onemain.challenge.data.DadJoke
import com.onemain.challenge.data.DadJokeRetrofitService
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel(
    private val dadJokeRetrofitService: DadJokeRetrofitService
) : BaseViewModel() {

    private var _joke = MutableLiveData<String>()
    val joke: LiveData<String> by lazy { _joke }

    override fun onViewAttached(firstAttach: Boolean) {
        super.onViewAttached(firstAttach)
        if(firstAttach) {
            getJoke()
        }
    }

    fun getJoke(){
        viewModelScope.launch {
            val response = fetchJoke()
            _joke.value = response?.text
        }
    }


    private suspend fun fetchJoke(): DadJoke? {
        return try {
            dadJokeRetrofitService.nextJoke()
        } catch (e: IOException) {
            null
        }
    }

}
