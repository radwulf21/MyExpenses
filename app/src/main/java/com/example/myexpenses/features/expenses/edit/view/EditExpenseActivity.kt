package com.example.myexpenses.features.expenses.edit.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myexpenses.R
import com.example.myexpenses.commons.MyExpensesConstants.EDIT_EXPENSE_ID_EXTRA
import com.example.myexpenses.commons.MyExpensesConstants.EDIT_EXPENSE_MONTH_ID_EXTRA
import com.example.myexpenses.commons.database.MyExpensesApplication
import com.example.myexpenses.commons.utils.UtilsMethods.Companion.showToastMessage
import com.example.myexpenses.databinding.ActivityEditExpenseBinding
import com.example.myexpenses.features.expenses.edit.repository.EditExpenseRepositoryImpl
import com.example.myexpenses.features.expenses.edit.viewmodel.EditExpenseViewModel
import com.example.myexpenses.features.expenses.list.model.Expense

class EditExpenseActivity : AppCompatActivity() {

    private val viewModel by viewModels<EditExpenseViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return EditExpenseViewModel(EditExpenseRepositoryImpl((application as MyExpensesApplication).repository)) as T
            }
        }
    }

    private lateinit var binding: ActivityEditExpenseBinding

    private var expenseId = 0
    private var monthId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getEditExpenseExtra()

        binding.btnAddExpense.setOnClickListener {
            if (binding.edEditDescription.text.toString().isBlank() || binding.edEditValue.text.toString().isBlank()) {
                showToastMessage(this, getString(R.string.error_message_edit_text_blank))
            } else {
                val description = binding.edEditDescription.text.toString()
                val value = binding.edEditValue.text.toString().toDouble()
                val expense = Expense(id = expenseId, description = description, value = value, monthId = monthId)
                viewModel.editExpense(expense)
                showToastMessage(this, getString(R.string.message_edit_successful))
                finish()
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun getEditExpenseExtra() {
        if (intent.hasExtra(EDIT_EXPENSE_ID_EXTRA)) {
            expenseId = intent.getIntExtra(EDIT_EXPENSE_ID_EXTRA, 0)
        }

        if (intent.hasExtra(EDIT_EXPENSE_MONTH_ID_EXTRA)) {
            monthId = intent.getIntExtra(EDIT_EXPENSE_MONTH_ID_EXTRA, 0)
        }
    }
}