package com.example.myexpenses.features.expenses.create.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myexpenses.features.expenses.create.repository.AddExpenseRepository
import com.example.myexpenses.features.expenses.list.model.Expense
import kotlinx.coroutines.launch

class AddExpenseViewModel(private val repository: AddExpenseRepository) : ViewModel() {
    fun insertExpense(expense: Expense) {
        viewModelScope.launch {
            repository.insertExpense(expense)
        }
    }
}