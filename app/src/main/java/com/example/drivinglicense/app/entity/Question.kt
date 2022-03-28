package com.example.drivinglicense.app.entity

data class Question(
    val questionId: Int,
    val examId: Int,
    val content: String,
    val image: String,
    val isImportant: Boolean //câu điểm liệt (sai => trượt)
)