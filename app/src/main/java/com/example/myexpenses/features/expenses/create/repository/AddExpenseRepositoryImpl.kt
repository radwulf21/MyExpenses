package com.example.myexpenses.features.expenses.create.repository

import com.example.myexpenses.commons.database.MyExpensesDao
import com.example.myexpenses.features.expenses.list.model.Expense

class AddExpenseRepositoryImpl(private val myExpensesDao: MyExpensesDao) : AddExpenseRepository {
    override suspend fun insertExpense(expense: Expense) {
        myExpensesDao.insertExpense(expense)
    }
}