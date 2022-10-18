package com.example.youtubeapi.ui.playlist

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.utils.playlistUtils.Item
import com.example.youtubeapi.databinding.ItemPlaylistsBinding

class PlayListsAdapter : RecyclerView.Adapter<PlayListsAdapter.ImageViewHolder>() {

    private var list = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(list: List<Item>) {
        this.list = list as ArrayList<Item>
        Log.d("ololo","s ArrayList<Item>")

        notifyDataSetChanged()
    }

    class ImageViewHolder(private val binding: ItemPlaylistsBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(playLists: Item) {
            Log.d("ololo","dkkdkddkdkdkkd")
            binding.ivPreview.load(playLists.snippet.thumbnails.default.url)
            binding.tvPlaylist.text = playLists.snippet.title
            binding.tvPlaylist.setTextColor(Color.BLACK)
            binding.tvVideoName.text = playLists.snippet.channelTitle
            binding.tvVideoName.setTextColor(Color.BLACK)
        }
    }
}