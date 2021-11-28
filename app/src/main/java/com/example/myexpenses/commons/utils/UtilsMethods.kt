package com.example.myexpenses.commons.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

class UtilsMethods {
    companion object {
        fun showToastMessage(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        fun buildAlertDialog(
            context: Context?,
            title: String,
            message: String,
            positiveButtonText: String,
            negativeButtonText: String,
            positiveButtonAction: DialogInterface.OnClickListener?,
            negativeButtonAction: DialogInterface.OnClickListener?
        ) {
            val builder = AlertDialog.Builder(context)
            builder.apply {
                setTitle(title)
                setMessage(message)
                setPositiveButton(positiveButtonText, positiveButtonAction)
                setNegativeButton(negativeButtonText, negativeButtonAction)
            }
            val alert = builder.create()
            alert.show()
        }
    }
}