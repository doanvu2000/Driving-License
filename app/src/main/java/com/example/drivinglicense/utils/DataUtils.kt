package com.example.drivinglicense.utils

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.example.drivinglicense.R
import com.example.drivinglicense.app.entity.Question

fun getContext(ct: Context): Context {
    return ct
}
/**-------------------------260 câu hỏi lý thuyết-------------------------*/

/**Câu hỏi điểm liệt*/ //60
fun getListQuestionImportant(context: Context): MutableList<Question> {
    val list = mutableListOf<Question>()
    for (i in 1..20) {
        val id =
            context.resources.getIdentifier("question_important_$i", "string", context.packageName)
        if (id > 0) {
            list.add(
                Question(1, null, context.getString(id), null, true)
            )
        }
    }
    return list
}

/**Khái niệm và quy tắc*/ //83

/**Văn hóa và đạo đức lái xe*/ //5

/**Kỹ thuật lái xe*/ //12

/**Biển báo đường bộ*/ //65

/**Sa hình*/ //35