package com.harunbekcan.paging3sampleproject.ui.activity

import android.os.Bundle
import com.harunbekcan.paging3sampleproject.R
import com.harunbekcan.paging3sampleproject.base.BaseActivity
import com.harunbekcan.paging3sampleproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {}

}