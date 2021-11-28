package com.example.myexpenses

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.example.myexpenses.commons.MyExpensesConstants.ADD_EXPENSE_EXTRA
import com.example.myexpenses.commons.MyExpensesConstants.EDIT_EXPENSE_ID_EXTRA
import com.example.myexpenses.commons.MyExpensesConstants.EDIT_EXPENSE_MONTH_ID_EXTRA
import com.example.myexpenses.features.expenses.create.view.AddExpenseActivity
import com.example.myexpenses.features.expenses.edit.view.EditExpenseActivity

class MyExpensesRouter {
    companion object {
        fun launchAddExpense(activity: FragmentActivity?, monthId: Int) {
            Intent(activity, AddExpenseActivity::class.java).apply {
                putExtra(ADD_EXPENSE_EXTRA, monthId)
                activity?.startActivity(this)
            }
        }

        fun launchEditExpense(activity: FragmentActivity?, expenseId: Int, monthId: Int) {
            Intent(activity, EditExpenseActivity::class.java).apply {
                putExtra(EDIT_EXPENSE_ID_EXTRA, expenseId)
                putExtra(EDIT_EXPENSE_MONTH_ID_EXTRA, monthId)
                activity?.startActivity(this)
            }
        }
    }
}