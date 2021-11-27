package com.example.myexpenses.features.expenses.create.repository

import com.example.myexpenses.features.expenses.list.model.Expense

interface AddExpenseRepository {
    suspend fun insertExpense(expense: Expense)
}