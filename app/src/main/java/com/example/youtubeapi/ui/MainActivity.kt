package com.example.youtubeapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityMainBinding
import com.example.youtubeapi.model.PlayLists
import com.example.youtubeapi.result.Status
import com.example.youtubeapi.ui.playlist.PlayListsAdapter
import com.example.youtubeapi.ui.playlist.PlaylistViewModel
import com.example.youtubeapi.utclass.CheckConnectionInternet
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity() : BaseActivity<ActivityMainBinding,PlaylistViewModel>() {

    override fun inflateVB(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

        override val viewModel: PlaylistViewModel by lazy {
            ViewModelProvider(this)[PlaylistViewModel::class.java]
        }
        private var adapter = PlayListsAdapter()
        private var list = arrayListOf<PlayLists>()

        override fun initViewModel() {
            binding.rvPlaylists.adapter = adapter

            viewModel.getPlaylists().observe(this) {
                Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show()
                Log.d("TAG14", "initViewModel: asda")
                when(it.status){
                    Status.SUCCESS ->{
                        binding.progress.isVisible = false
                        it.data?.items?.let { it1 -> adapter.add(it1) }
                    }
                    Status.ERROR -> {
                        binding.progress.isVisible = false
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                    Status.LOADING -> {
                        binding.progress.isVisible = true
                    }
                }
            }
            CheckConnectionInternet(this).observe(this){
                binding.layoutIntCheck.layoutCheckInternet.isVisible = !it
            }

    }

}