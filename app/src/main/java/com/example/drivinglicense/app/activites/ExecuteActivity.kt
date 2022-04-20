package com.example.drivinglicense.app.activites

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.example.drivinglicense.R
import com.example.drivinglicense.app.adapter.AnswerAdapter
import com.example.drivinglicense.app.entity.Answer
import com.example.drivinglicense.component.activity.BaseCoreActivity
import com.example.drivinglicense.component.widgets.recyclerview.RecyclerUtils
import com.example.drivinglicense.databinding.ActivityExecuteBinding
import com.example.drivinglicense.databinding.LayoutQuestionAnswerBinding
import com.example.drivinglicense.utils.TITLE_TOOLBAR

class ExecuteActivity : BaseCoreActivity<ActivityExecuteBinding>() {
    var titleToolbar = ""
    private val bindingContent by lazy {
        LayoutQuestionAnswerBinding.bind(binding.root)
    }
    private val answerAdapter by lazy {
        AnswerAdapter()
    }

    override fun initView() {
        setupToolBar()
        RecyclerUtils.setGridManager(this, bindingContent.rcvAnswers, answerAdapter)
    }

    private fun setupToolBar() {
        binding.toolbar.setTitle(titleToolbar)
        binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        binding.toolbar.setTitleColor(Color.WHITE)
        binding.toolbar.setIconLeft(R.drawable.icon_back_white)
        binding.toolbar.setIconRight(R.drawable.icon_info)
    }

    override fun initListener() {
        binding.toolbar.onLeftClickListener = { onBackPressed() }
    }


    override fun initData() {
        titleToolbar = intent.extras?.getString(TITLE_TOOLBAR) ?: "Ôn luyện"
        bindingContent.textQuestionContent.text = getString(R.string.question_important_1)
        val listAnswer = mutableListOf(
            Answer(1, getString(R.string.answer_important_1_1), false, 1),
            Answer(2, getString(R.string.answer_important_1_2), false, 1),
            Answer(
                3,
                getString(R.string.answer_important_1_3),
                true,
                1,
                "Đây là đáp án đúng, không cần giải thích!"
            ),
            Answer(4, getString(R.string.answer_important_1_4), false, 1)
        )
        answerAdapter.addData(listAnswer)
    }

}