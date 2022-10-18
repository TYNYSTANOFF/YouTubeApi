package com.example.youtubeapi.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.result.Resource
import com.example.youtubeapi.result.Resource.Companion.loading
import com.example.youtubeapi.model.PlayLists
import com.example.youtubeapi.remote.ApiService
import com.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): MutableLiveData<Resource<PlayLists>> {
        return getPlaylist()
    }

    private fun getPlaylist(): MutableLiveData<Resource<PlayLists>> {
        val data = MutableLiveData<Resource<PlayLists>>()
        data.value = loading()
        apiService.getPlaylists().enqueue(
            object : Callback<PlayLists> {
                override fun onResponse(call: Call<PlayLists>, response: Response<PlayLists>) {
                    if (response.isSuccessful){
                        data.value = Resource.success(response.body())
                        Log.e("ololo", "onResponse:" + response.body() )
                    }}
                override fun onFailure(call: Call<PlayLists>, t: Throwable) {
                    Log.d("ololo", "onSuccess: else")
                    data.value = Resource.error(null, t.message)
                }
            }
        )
        return data
    }
}