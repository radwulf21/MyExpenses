package com.example.myexpenses.features.expenses.edit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myexpenses.features.expenses.edit.repository.EditExpenseRepository
import com.example.myexpenses.features.expenses.list.model.Expense
import kotlinx.coroutines.launch

class EditExpenseViewModel(private val repository: EditExpenseRepository) : ViewModel() {
    fun editExpense(expense: Expense) {
        viewModelScope.launch {
            repository.editExpense(expense)
        }
    }
}