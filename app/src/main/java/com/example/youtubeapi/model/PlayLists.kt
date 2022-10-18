package com.example.youtubeapi.model

import com.example.youtubeapi.utils.playlistUtils.Item
import com.example.youtubeapi.utils.playlistUtils.PageInfo

data class PlayLists(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)