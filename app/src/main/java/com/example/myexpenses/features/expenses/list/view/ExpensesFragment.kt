package com.example.myexpenses.features.expenses.list.view

import android.content.DialogInterface
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
import com.example.myexpenses.MyExpensesRouter.Companion.launchEditExpense
import com.example.myexpenses.R
import com.example.myexpenses.commons.database.MyExpensesApplication
import com.example.myexpenses.commons.utils.UtilsMethods.Companion.buildAlertDialog
import com.example.myexpenses.commons.utils.UtilsMethods.Companion.showToastMessage
import com.example.myexpenses.features.expenses.list.adapter.ExpensesAdapter
import com.example.myexpenses.features.expenses.list.adapter.ExpensesAdapterCallback
import com.example.myexpenses.features.expenses.list.model.Expense
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
        activity?.let { activity ->
            ExpensesAdapter(activity, object : ExpensesAdapterCallback {
                override fun onClickDeleteIcon(expense: Expense) {
                    buildAlertDialog(
                        activity,
                        activity.getString(R.string.dialog_delete_title),
                        activity.getString(R.string.dialog_delete_message),
                        activity.getString(R.string.dialog_delete_positive_button_text),
                        activity.getString(R.string.dialog_delete_negative_button_text),
                        DialogInterface.OnClickListener { dialog, _ ->
                            viewModel.deleteExpense(expense, expense.monthId)
                            dialog.cancel()
                            showToastMessage(activity, activity.getString(R.string.message_delete_successful))
                        },
                        DialogInterface.OnClickListener { dialog, _ ->
                            dialog.cancel()
                        }
                    )
                }

                override fun onClickEditIcon(expenseId: Int, monthId: Int) {
                    launchEditExpense(activity, expenseId, monthId)
                }
            })
        }
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

    override fun onResume() {
        super.onResume()

        updateExpenses()
    }

    private fun setUpViews() {
        binding?.rvExpenses?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mExpensesAdapter
        }

        binding?.btnAddExpense?.setOnClickListener {
            launchAddExpense(activity, monthId)
        }
    }

    private fun updateExpenses() {
        activity?.let { activity ->
            viewModel.apply {
                loadExpensesByMonthId(monthId)
                expenses.observe(activity) { expenses ->
                    mExpensesAdapter?.addExpenseList(expenses as MutableList)
                }

                getTotalValueOfMonth(monthId)
                totalValue.observe(activity) { totalValue ->
                    if (totalValue != null) {
                        binding?.tvExpenseTotalValue?.text = activity.getString(
                            R.string.text_currency_real, totalValue.toString()
                        )
                    } else {
                        binding?.tvExpenseTotalValue?.text = activity.getString(
                            R.string.empty_value
                        )
                    }
                }
            }
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