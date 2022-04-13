package com.example.drivinglicense.app.activites

import com.example.drivinglicense.component.activity.BaseCoreActivity
import com.example.drivinglicense.databinding.ActivityTipsBinding

class TipsActivity : BaseCoreActivity<ActivityTipsBinding>() {
    override fun initView() {
        supportActionBar?.hide()
    }

    override fun initListener() {
    }

    override fun initData() {
    }
}