package com.example.youtubeapi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.youtubeapi.R

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>  : Fragment(){
    protected lateinit var binding: VB
    protected abstract val viewModel :VM
    private var navController : NavController? = null

    protected abstract fun inflateVB(layoutInflater: LayoutInflater):VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        binding = inflateVB(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        val navHost = activity?.supportFragmentManager?.findFragmentById(R.id.playlistFragment) as NavHostFragment
        navController = navHost.navController
        checkInternet()
        initViews()
        initViewModel()
        initListener()
    }
    fun navigate(directions : Int, data : Bundle?){
        navController?.navigate(directions, data)
    }

    fun getBundle(key:String){
        val bundle=Bundle()
        bundle.getStringArrayList(key)
    }

    abstract fun checkInternet()
    abstract fun initViewModel()
    abstract fun initListener()
    abstract fun initViews()
}