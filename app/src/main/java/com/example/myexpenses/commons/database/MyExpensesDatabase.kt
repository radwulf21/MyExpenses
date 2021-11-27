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
        private var INSTANCE : MyExpensesDatabase? = null

        fun getDatabase(context: Context): MyExpensesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyExpensesDatabase::class.java,
                    "my_expenses.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}