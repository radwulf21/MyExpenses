package com.example.myexpenses.commons.database

import android.app.Application

class MyExpensesApplication : Application() {
    val database by lazy { MyExpensesDatabase.invoke(this) }
    val repository by lazy { database.expenseDao() }
}