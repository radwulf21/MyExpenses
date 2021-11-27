package com.example.myexpenses.features.expenses.list.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "value") val value: Double,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "month_id") val monthId: Int
)