package com.onemain.challenge.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    protected open fun onViewAttached(firstAttach: Boolean) {}
    protected open fun onViewDetached() {}

    fun attachView(firstAttach: Boolean) {
        onViewAttached(firstAttach)
    }

    fun detachView() {
        onViewDetached()
    }
}