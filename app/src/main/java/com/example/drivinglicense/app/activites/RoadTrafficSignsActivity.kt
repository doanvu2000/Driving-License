package com.example.drivinglicense.app.activites

import android.graphics.Color
import com.example.drivinglicense.R
import com.example.drivinglicense.component.activity.BaseCoreActivity
import com.example.drivinglicense.databinding.ActivityRoadTrafficSignsBinding

class RoadTrafficSignsActivity : BaseCoreActivity<ActivityRoadTrafficSignsBinding>() {
    override fun initView() {
        supportActionBar?.hide()
        setupToolBar()
    }
    private fun setupToolBar() {
        binding.toolbar.setTitle(getString(R.string.text_road_signs))
        binding.toolbar.setBackgroundColor(Color.GREEN)
        binding.toolbar.setTitleColor(Color.WHITE)
        binding.toolbar.setIconLeft(R.drawable.icon_back_white)
        binding.toolbar.setIconRight(R.drawable.icon_info)
    }
    override fun initListener() {
        binding.toolbar.onLeftClickListener = { onBackPressed() }
    }

    override fun initData() {
    }
}