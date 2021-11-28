package com.example.myexpenses.features.expenses.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myexpenses.databinding.FragmentExpensesBinding
import com.example.myexpenses.MyExpensesRouter.Companion.launchAddExpense
import com.example.myexpenses.commons.database.MyExpensesApplication
import com.example.myexpenses.features.expenses.list.adapter.ExpensesAdapter
import com.example.myexpenses.features.expenses.list.repository.ExpensesRepositoryImpl
import com.example.myexpenses.features.expenses.list.viewmodel.ExpensesViewModel

class ExpensesFragment : Fragment() {

    private val viewModel by viewModels<ExpensesViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return ExpensesViewModel(ExpensesRepositoryImpl((activity?.application as MyExpensesApplication).repository)) as T
            }
        }
    }

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
        return binding?.root
    }

    override fun onResume() {
        super.onResume()

        setUpViews()
    }

    private fun setUpViews() {
        activity?.let {
            viewModel.loadExpensesByMonthId(monthId)
            viewModel.expenses.observe(it) { expenses ->
                mExpensesAdapter.addExpenseList(expenses as MutableList)
            }
        }

        binding?.rvExpenses?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mExpensesAdapter
        }

        binding?.btnAddExpense?.setOnClickListener {
            launchAddExpense(activity, monthId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(monthId: Int) = ExpensesFragment().apply { this.monthId = monthId }
    }
}