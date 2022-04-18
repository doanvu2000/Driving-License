package com.example.drivinglicense.app.activites

import com.example.drivinglicense.R
import com.example.drivinglicense.component.activity.BaseCoreActivity
import com.example.drivinglicense.databinding.ActivityLearningTheoryBinding

class LearningTheoryActivity : BaseCoreActivity<ActivityLearningTheoryBinding>() {
    override fun initView() {
        supportActionBar?.hide()
        binding.toolbar.setTitle(getString(R.string.text_learning_theory))
    }

    override fun initListener() {
        binding.toolbar.onLeftClickListener = { onBackPressed() }
    }

    override fun initData() {
    }
}