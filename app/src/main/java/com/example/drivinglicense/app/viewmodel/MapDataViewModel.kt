package com.example.drivinglicense.app.viewmodel

import com.example.drivinglicense.app.entity.Answer
import com.example.drivinglicense.component.viewmodel.BaseViewModel
import com.example.drivinglicense.utils.listAnswer

class MapDataViewModel : BaseViewModel() {

    var mapAnswer = HashMap<Int, MutableList<Answer>>()

    /** 60 question 1 -> 60 */
    fun getQuestionImportant() {
        for (i in 1..3) {
            mapAnswer[i] = listAnswer[i - 1]
        }
    }

}