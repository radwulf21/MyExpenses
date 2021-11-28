package com.example.myexpenses.commons.database

import androidx.room.*
import com.example.myexpenses.features.expenses.list.model.Expense

@Dao
interface MyExpensesDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses WHERE month_id = :monthId")
    suspend fun loadExpensesByMonthId(monthId: Int): List<Expense>

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT SUM(value) FROM expenses WHERE month_id = :monthId")
    suspend fun getTotalValueOfMonth(monthId: Int): Double

    @Update
    suspend fun editExpense(expense: Expense)
}