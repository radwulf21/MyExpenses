package com.example.myexpenses.features.expenses.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myexpenses.databinding.FragmentExpensesBinding
import com.example.myexpenses.features.expenses.list.adapter.ExpensesAdapter

class ExpensesFragment : Fragment() {

    private val mExpensesAdapter by lazy {
        ExpensesAdapter()
    }

    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding

    private var monthId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)

        setUpViews()

        return binding?.root
    }

    private fun setUpViews() {
        binding?.rvExpenses?.adapter = mExpensesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(monthId: Int) = ExpensesFragment().apply { this.monthId = monthId }
    }
}