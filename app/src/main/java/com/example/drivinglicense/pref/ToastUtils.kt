package com.example.drivinglicense.pref

import android.content.Context
import android.widget.Toast

private var toast: Toast? = null

fun showError(context: Context, errorMessage: String) {
    toastMessage(context, errorMessage)
}

fun toastMessage(context: Context, message: String) {
    if (toast == null) {
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    } else {
        toast?.setText(message)
    }
    toast?.show()
}

fun Context.showDevelopMessage() {
    Toast.makeText(this, "develop", Toast.LENGTH_SHORT).show()
}