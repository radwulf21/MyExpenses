package com.example.myexpenses.features.expenses.list.repository

import com.example.myexpenses.commons.database.MyExpensesDao
import com.example.myexpenses.features.expenses.list.model.Expense

class ExpensesRepositoryImpl(private val expensesDao: MyExpensesDao) : ExpensesRepository {
    override suspend fun loadExpensesByMonthId(monthId: Int): List<Expense> {
        return expensesDao.loadExpensesByMonthId(monthId)
    }

    override suspend fun deleteExpense(expense: Expense) {
        expensesDao.deleteExpense(expense)
    }

    override suspend fun getTotalValueOfMonth(monthId: Int): Double {
        return expensesDao.getTotalValueOfMonth(monthId)
    }
}