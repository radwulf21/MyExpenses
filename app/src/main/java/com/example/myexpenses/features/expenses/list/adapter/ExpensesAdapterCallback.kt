package com.example.myexpenses.features.expenses.list.adapter

import com.example.myexpenses.features.expenses.list.model.Expense

interface ExpensesAdapterCallback {
    fun onClickDeleteIcon(expense: Expense)
    fun onClickEditIcon(expenseId: Int, monthId: Int)
}