package com.example.myexpenses

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.myexpenses.commons.MyExpensesConstants.ADD_EXPENSE_EXTRA
import com.example.myexpenses.features.expenses.create.view.AddExpenseActivity

class MyExpensesRouter {
    companion object {
        fun launchAddExpense(activity: FragmentActivity?, monthId: Int) {
            Intent(activity, AddExpenseActivity::class.java).apply {
                putExtra(ADD_EXPENSE_EXTRA, monthId)
                activity?.startActivity(this)
            }
        }
    }
}