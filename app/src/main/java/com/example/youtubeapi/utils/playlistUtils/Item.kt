package com.example.youtubeapi.utils.playlistUtils

import com.example.youtubeapi.ContentDetails

data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
)