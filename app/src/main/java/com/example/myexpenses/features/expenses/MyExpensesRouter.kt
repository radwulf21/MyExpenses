package com.example.myexpenses.features.expenses

import android.app.Activity
import android.content.Intent
import com.example.myexpenses.features.expenses.create.view.AddExpenseActivity

class MyExpensesRouter {
    companion object {
        fun launchAddExpense(activity: Activity) {
            Intent(activity, AddExpenseActivity::class.java).apply {
                activity.startActivity(this)
            }
        }
    }
}