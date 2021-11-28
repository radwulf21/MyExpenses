package com.example.myexpenses.features.expenses.edit.repository

import com.example.myexpenses.features.expenses.list.model.Expense

interface EditExpenseRepository {
    suspend fun editExpense(expense: Expense)
}