package com.harunbekcan.paging3sampleproject.utils

import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> T.executeWithAction(action: T.() -> Unit) {
    action()
    executePendingBindings()
}