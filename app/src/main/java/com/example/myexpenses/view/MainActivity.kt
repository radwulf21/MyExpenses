package com.example.myexpenses.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myexpenses.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val months = listOf("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro")

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpExpenses.adapter = FragmentExpensesAdapter(this)
        binding.vpExpenses.isUserInputEnabled = false

        TabLayoutMediator(binding.tbMonths, binding.vpExpenses) { tab, position ->
            tab.text = months[position]
        }.attach()
    }

    inner class FragmentExpensesAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun createFragment(position: Int) = ExpensesFragment()
        override fun getItemCount() = 12
    }
}