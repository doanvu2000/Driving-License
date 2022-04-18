package com.example.drivinglicense.app.activites

import com.example.drivinglicense.R
import com.example.drivinglicense.component.activity.BaseCoreActivity
import com.example.drivinglicense.databinding.ActivityTipsBinding

class TipsActivity : BaseCoreActivity<ActivityTipsBinding>() {
    override fun initView() {
        supportActionBar?.hide()
        binding.toolbar.setTitle(getString(R.string.text_tips))
    }

    override fun initListener() {
        binding.toolbar.onLeftClickListener = { onBackPressed() }
    }

    override fun initData() {
    }
}