package com.example.myexpenses.features.expenses.list.repository

import com.example.myexpenses.features.expenses.list.model.Expense

interface ExpensesRepository {
    suspend fun loadExpensesByMonthId(monthId: Int): List<Expense>
}