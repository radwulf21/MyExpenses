package com.example.myexpenses.features.expenses.list.model

data class Expense(
    val id: Int,
    val value: Double,
    val description: String,
    val monthId: Int
)