package com.example.myexpenses.features.expenses.list.repository

import com.example.myexpenses.commons.database.MyExpensesDao

class ExpensesRepositoryImpl(private val expensesDao: MyExpensesDao) : ExpensesRepository {
    override suspend fun loadExpensesByMonthId(monthId: Int) {
        expensesDao.loadExpensesByMonthId(monthId)
    }
}