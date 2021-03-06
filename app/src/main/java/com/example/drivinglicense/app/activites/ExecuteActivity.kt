package com.example.drivinglicense.app.activites

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import com.example.drivinglicense.R
import com.example.drivinglicense.app.adapter.AnswerAdapter
import com.example.drivinglicense.app.entity.Answer
import com.example.drivinglicense.app.viewmodel.MapDataViewModel
import com.example.drivinglicense.component.activity.BaseVMActivity
import com.example.drivinglicense.component.widgets.recyclerview.RecyclerUtils
import com.example.drivinglicense.databinding.ActivityExecuteBinding
import com.example.drivinglicense.databinding.LayoutQuestionAnswerBinding
import com.example.drivinglicense.utils.TITLE_TOOLBAR

class ExecuteActivity : BaseVMActivity<ActivityExecuteBinding, MapDataViewModel>() {

    var titleToolbar = ""

    /**
     * key: questionId
     * value: list answer of question
     * */

    var mapAnswer = HashMap<Int, MutableList<Answer>>()

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
        titleToolbar = intent.extras?.getString(TITLE_TOOLBAR) ?: "Ôn luyện"
        binding.toolbar.setTitle(titleToolbar)
        binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.primary))
        binding.toolbar.setTitleColor(Color.WHITE)
        binding.toolbar.setIconLeft(R.drawable.icon_back_white)
        binding.toolbar.setIconRight(R.drawable.icon_info)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun initListener() {
        binding.toolbar.onLeftClickListener = { onBackPressed() }
        answerAdapter.setOnClickItemRecyclerView { answer, _ ->
            if (answer.isCorrect) {
                bindingContent.layoutEx.visibility = View.VISIBLE
                bindingContent.layoutExplainAnswer.visibility = View.VISIBLE
                bindingContent.textExplainAnswer.text = answer.answerExplain
                answerAdapter.dataList.map { it.flag = 1 }
                answer.flag = 2
            } else {
                bindingContent.layoutEx.visibility = View.GONE
                bindingContent.layoutExplainAnswer.visibility = View.GONE
                answerAdapter.dataList.map { it.flag = 1 }
                answer.flag = 3
            }
            answerAdapter.notifyDataSetChanged()
        }
    }


    override fun initData() {
        bindingContent.textQuestionContent.text = getString(R.string.question_important_3)
        viewModel.getAnswerWithQuestionImportant()
        val listAnswer = viewModel.mapAnswer[3]
        if (listAnswer != null) {
            answerAdapter.addData(listAnswer)
        }

    }

}