package com.example.myexpenses.features.expenses.create.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myexpenses.R
import com.example.myexpenses.commons.MyExpensesConstants.ADD_EXPENSE_EXTRA
import com.example.myexpenses.commons.database.MyExpensesApplication
import com.example.myexpenses.commons.utils.UtilsMethods.Companion.showToastMessage
import com.example.myexpenses.databinding.ActivityAddExpenseBinding
import com.example.myexpenses.features.expenses.create.repository.AddExpenseRepository
import com.example.myexpenses.features.expenses.create.repository.AddExpenseRepositoryImpl
import com.example.myexpenses.features.expenses.create.viewmodel.AddExpenseViewModel
import com.example.myexpenses.features.expenses.list.model.Expense

class AddExpenseActivity : AppCompatActivity() {

    private val viewModel by viewModels<AddExpenseViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return AddExpenseViewModel(AddExpenseRepositoryImpl((application as MyExpensesApplication).repository)) as  T
            }
        }
    }

    private lateinit var binding: ActivityAddExpenseBinding

    private var monthId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAddExpenseExtra()

        binding.btnAddExpense.setOnClickListener {
            if (binding.edDescription.text.toString().isBlank() || binding.edValue.text.toString().isBlank()) {
                showToastMessage(this, getString(R.string.error_message_edit_text_blank))
            } else {
                val description = binding.edDescription.text.toString()
                val value = binding.edValue.text.toString().toDouble()
                val expense = Expense(description = description, value = value, monthId = monthId)
                viewModel.insertExpense(expense)
                showToastMessage(this, getString(R.string.message_insert_successful))
                finish()
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun getAddExpenseExtra() {
        if (intent.hasExtra(ADD_EXPENSE_EXTRA)) {
            monthId = intent.getIntExtra(ADD_EXPENSE_EXTRA, 0)
        }
    }
}