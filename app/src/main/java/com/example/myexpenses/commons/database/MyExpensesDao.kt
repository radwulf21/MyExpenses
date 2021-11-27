package com.example.myexpenses.commons.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myexpenses.features.expenses.list.model.Expense

@Dao
interface MyExpensesDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses WHERE month_id = :monthId")
    suspend fun loadExpensesByMonthId(monthId: Int): List<Expense>
}