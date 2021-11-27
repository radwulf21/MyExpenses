package com.example.myexpenses.features.expenses.list.repository

interface ExpensesRepository {
    suspend fun loadExpensesByMonthId(monthId: Int)
}