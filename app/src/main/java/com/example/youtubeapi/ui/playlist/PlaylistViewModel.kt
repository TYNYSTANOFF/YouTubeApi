package com.example.youtubeapi.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.model.PlayLists
import com.example.youtubeapi.utils.Constant
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.remote.ApiService
import com.example.youtubeapi.remote.RetrofitClient
import com.example.youtubeapi.result.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    fun getPlaylists(): MutableLiveData<Resource<PlayLists>> {
        return App().repository.getPlaylists()
    }
}