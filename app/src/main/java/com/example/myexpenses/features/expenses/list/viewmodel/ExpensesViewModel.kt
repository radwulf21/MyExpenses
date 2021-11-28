package com.example.myexpenses.features.expenses.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myexpenses.features.expenses.list.model.Expense
import com.example.myexpenses.features.expenses.list.repository.ExpensesRepository
import kotlinx.coroutines.launch

class ExpensesViewModel(private val repository: ExpensesRepository) : ViewModel() {
    val expenses = MutableLiveData<List<Expense>>()
    val totalValue = MutableLiveData<Double>()

    fun loadExpensesByMonthId(monthId: Int) {
        viewModelScope.launch {
            expenses.value = repository.loadExpensesByMonthId(monthId)
        }
    }

    fun getTotalValueOfMonth(monthId: Int) {
        viewModelScope.launch {
            totalValue.value = repository.getTotalValueOfMonth(monthId)
        }
    }

    fun deleteExpense(expense: Expense, monthId: Int) {
        viewModelScope.launch {
            repository.deleteExpense(expense)
            loadExpensesByMonthId(monthId)
            getTotalValueOfMonth(monthId)
        }
    }
}