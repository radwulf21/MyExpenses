package com.example.myexpenses.features.expenses.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myexpenses.features.expenses.list.model.Expense
import com.example.myexpenses.features.expenses.list.repository.ExpensesRepository
import kotlinx.coroutines.launch

class ExpensesViewModel(private val repository: ExpensesRepository) : ViewModel() {
    val expenses = MutableLiveData<List<Expense>>()

    fun loadExpensesByMonthId(monthId: Int) {
        viewModelScope.launch {
            expenses.value = repository.loadExpensesByMonthId(monthId)
        }
    }
}