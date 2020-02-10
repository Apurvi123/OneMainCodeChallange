package com.onemain.challenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import com.onemain.challenge.R
import com.onemain.challenge.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment<MainViewModel>(MainViewModel::class) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swipeToRefresh.setOnRefreshListener { baseViewModel.getJoke() }
        initObservers()
    }

    private fun initObservers() {
        baseViewModel.joke.observe(this) {
            jokeTextView.text = it
            swipeToRefresh.isRefreshing = false
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
