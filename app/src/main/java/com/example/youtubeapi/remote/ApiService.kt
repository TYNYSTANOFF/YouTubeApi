package com.example.youtubeapi.remote

import com.example.youtubeapi.model.PlayLists
import com.example.youtubeapi.utils.Constant
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("key") apiKey: String = Constant.apiKey,
        @Query("part") part: String = Constant.part,
        @Query("channelId") channelId: String = Constant.channelId,
        @Query("maxResults") maxResults: Int = 50

    ):Call<PlayLists>
}