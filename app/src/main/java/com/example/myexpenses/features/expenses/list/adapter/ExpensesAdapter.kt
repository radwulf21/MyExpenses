package com.example.myexpenses.features.expenses.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myexpenses.databinding.ItemExpenseBinding
import com.example.myexpenses.features.expenses.list.model.Expense

class ExpensesAdapter() : RecyclerView.Adapter<ExpensesAdapter.ExpenseViewHolder>() {

    private val mExpenses: MutableList<Expense> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val item = mExpenses[position]
        holder.bind(item)
    }

    override fun getItemCount() = mExpenses.size

    fun addExpenseList(expenses: List<Expense>) {
        mExpenses.clear()
        mExpenses.addAll(expenses)
        notifyDataSetChanged()
    }

    inner class ExpenseViewHolder(private val binding: ItemExpenseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(expense: Expense) {
            binding.tvExpenseValue.text = expense.value.toString()
            binding.tvExpenseDescription.text = expense.description
        }
    }
}