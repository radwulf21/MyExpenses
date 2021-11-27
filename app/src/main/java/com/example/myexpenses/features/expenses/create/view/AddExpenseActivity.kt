package com.example.myexpenses.features.expenses.create.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.myexpenses.R
import com.example.myexpenses.commons.MyExpensesConstants.ADD_EXPENSE_EXTRA
import com.example.myexpenses.features.expenses.create.viewmodel.AddExpenseViewModel

class AddExpenseActivity : AppCompatActivity() {

    private val viewModel: AddExpenseViewModel by viewModels()

    private var monthId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        getAddExpenseExtra()
    }

    private fun getAddExpenseExtra() {
        if (intent.hasExtra(ADD_EXPENSE_EXTRA)) {
            monthId = intent.getIntExtra(ADD_EXPENSE_EXTRA, 0)
        }
    }
}