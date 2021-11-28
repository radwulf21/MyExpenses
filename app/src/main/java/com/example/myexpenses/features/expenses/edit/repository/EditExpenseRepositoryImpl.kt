package com.example.myexpenses.features.expenses.edit.repository

import com.example.myexpenses.commons.database.MyExpensesDao
import com.example.myexpenses.features.expenses.list.model.Expense

class EditExpenseRepositoryImpl(private val myExpensesDao: MyExpensesDao) : EditExpenseRepository {
    override suspend fun editExpense(expense: Expense) {
        myExpensesDao.editExpense(expense)
    }
}