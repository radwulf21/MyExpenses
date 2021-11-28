package com.example.myexpenses.features.expenses.list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myexpenses.databinding.ActivityExpensesBinding
import com.example.myexpenses.features.expenses.list.model.MonthEnum
import com.google.android.material.tabs.TabLayoutMediator

class ExpensesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpensesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()
    }

    private fun setUpViews() {
        binding.vpExpenses.adapter = FragmentExpensesAdapter(this)
        binding.vpExpenses.isUserInputEnabled = false

        TabLayoutMediator(binding.tbMonths, binding.vpExpenses) { tab, position ->
            tab.text = MonthEnum.values()[position].value.name
        }.attach()
    }

    inner class FragmentExpensesAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun createFragment(position: Int) = ExpensesFragment.newInstance(MonthEnum.values()[position].value.id)
        override fun getItemCount() = MonthEnum.values().size
    }
}