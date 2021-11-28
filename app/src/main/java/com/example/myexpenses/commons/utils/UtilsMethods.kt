package com.example.myexpenses.commons.utils

import android.content.Context
import android.widget.Toast

class UtilsMethods {
    companion object {
        fun showToastMessage(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}