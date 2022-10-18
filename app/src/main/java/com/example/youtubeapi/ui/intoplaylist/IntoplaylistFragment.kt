package com.example.youtubeapi.ui.intoplaylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseFragment
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.databinding.FragmentIntoplaylistBinding


class IntoplaylistFragment() : BaseFragment<FragmentIntoplaylistBinding, BaseViewModel>() {

    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(requireActivity())[BaseViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intoplaylist, container, false)
    }

    override fun inflateVB(layoutInflater: LayoutInflater): FragmentIntoplaylistBinding {
       return FragmentIntoplaylistBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        TODO("Not yet implemented")
    }

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun initListener() {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }

}