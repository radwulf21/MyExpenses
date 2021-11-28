package com.example.myexpenses.commons.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myexpenses.features.expenses.list.model.Expense

@Database(entities = [Expense::class], version = 1)
abstract class MyExpensesDatabase : RoomDatabase() {

    abstract fun expenseDao(): MyExpensesDao

    companion object {
        @Volatile
        private var instance: MyExpensesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MyExpensesDatabase::class.java, "app_data_base.db"
        ).build()
    }
}