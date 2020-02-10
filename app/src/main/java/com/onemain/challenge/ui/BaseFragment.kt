package com.onemain.challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.onemain.challenge.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseFragment<V : BaseViewModel>(clazz: KClass<V>) : Fragment() {
    private var firstLaunch = true

    val baseViewModel: V by viewModel(clazz)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        firstLaunch = savedInstanceState == null
    }

    override fun onResume() {
        super.onResume()
        baseViewModel.attachView(firstLaunch)
        firstLaunch = false
    }

    override fun onPause() {
        super.onPause()
        baseViewModel.detachView()
    }
}