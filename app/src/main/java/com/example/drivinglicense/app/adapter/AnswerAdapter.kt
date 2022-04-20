package com.example.drivinglicense.app.adapter

import com.example.drivinglicense.app.entity.Answer
import com.example.drivinglicense.component.adapter.BaseRecyclerViewAdapter
import com.example.drivinglicense.databinding.ItemAnswerBinding

class AnswerAdapter : BaseRecyclerViewAdapter<Answer, ItemAnswerBinding>() {
    override fun bindData(binding: ItemAnswerBinding, item: Answer, position: Int) {
        binding.textAnswerCount.text = "${position + 1}"
        binding.textAnswerContent.text = item.answerContent
    }
}