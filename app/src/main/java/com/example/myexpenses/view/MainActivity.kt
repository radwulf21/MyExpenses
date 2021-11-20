package com.example.myexpenses.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myexpenses.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val months = listOf("A", "B", "C", "D", "E", "F", "G")

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpExpenses.adapter = FragmentExpensesAdapter(this)

        TabLayoutMediator(binding.tbMonths, binding.vpExpenses) { tab, position ->
            tab.text = months[position]
        }.attach()
    }
}

class FragmentExpensesAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun createFragment(position: Int) = ExpensesFragment()
    override fun getItemCount() = 7
}