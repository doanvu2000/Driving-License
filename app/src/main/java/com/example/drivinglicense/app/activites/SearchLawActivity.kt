package com.example.drivinglicense.app.activites

import com.example.drivinglicense.R
import com.example.drivinglicense.component.activity.BaseCoreActivity
import com.example.drivinglicense.databinding.ActivitySearchLawBinding

class SearchLawActivity : BaseCoreActivity<ActivitySearchLawBinding>() {
    override fun initView() {
        supportActionBar?.hide()
        binding.toolbar.setTitle(getString(R.string.text_search_law))
    }

    override fun initListener() {
        binding.toolbar.onLeftClickListener = { onBackPressed() }
    }

    override fun initData() {
    }
}