package com.android.goally.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.goally.BaseActivity
import com.android.goally.R
import com.android.goally.data.model.api.response.copilot.Routine
import com.android.goally.databinding.ActivityHomeBinding
import com.android.goally.ui.adapters.RoutineAdapter
import com.android.goally.ui.details.DetailsActivity
import com.android.goally.ui.viewmodels.CopilotViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {


    private lateinit var viewModel: CopilotViewModel
    private var selectedSchedule: String? = null
    private var selectedFolder: String? = null
    private var isScheduleSpinnerTouched = false
    private var isFolderSpinnerTouched = false
    private lateinit var routineAdapter: RoutineAdapter


    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupObservers()



        binding.layoutShimmer.visibility = View.VISIBLE
        binding.layoutShimmer.startShimmer()

        viewModel = ViewModelProvider(this).get(CopilotViewModel::class.java)

        viewModel.copilot.observe(this) { copilot ->
            copilot?.let {
                binding.layoutShimmer.visibility = View.GONE
                binding.layoutShimmer.stopShimmer()

                val routines = it.routines
                routineAdapter = RoutineAdapter(routines) { routine ->
                    onRoutineClick(routine)

                }

                updateFolderSpinner(
                    binding.spinnerFolder,
                    it.routines
                )

                binding.rvRoutines.adapter = routineAdapter
            }

        }

        binding.rvRoutines.layoutManager = LinearLayoutManager(this)


        viewModel.fetchCopilots("ameen")

        // Detect user interaction with schedule spinner
        binding.linearLayout.setOnTouchListener { _, _ ->
            isScheduleSpinnerTouched = true
            false
        }
        binding.layoutFolderSpinner.setOnTouchListener { _, _ ->
            isFolderSpinnerTouched = true
            false
        }

        binding.linearLayout.setOnClickListener {
            binding.spinnerSchedule.performClick()
        }
        binding.layoutFolderSpinner.setOnClickListener {
            binding.spinnerFolder.performClick()
        }


        binding.spinnerSchedule.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (isScheduleSpinnerTouched) {
                        selectedSchedule = parent.getItemAtPosition(position).toString()
                        viewModel.copilot.value?.let {
                            filterRoutines(it.routines)
                        }
                        updateFilteredTextViewVisibility(binding.tvFiltered)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    selectedSchedule = null
                    updateFilteredTextViewVisibility(binding.tvFiltered)

                }
            }


        // Setup folder spinner listener
        binding.spinnerFolder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (isFolderSpinnerTouched) {
                    selectedFolder = parent.getItemAtPosition(position).toString()
                    viewModel.copilot.value?.let {
                        filterRoutines(it.routines)
                    }
                    updateFilteredTextViewVisibility(binding.tvFiltered)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                selectedFolder = null
                updateFilteredTextViewVisibility(binding.tvFiltered)
            }
        }


    }


    private fun onRoutineClick(routine: Routine) {
        Log.d("HomeActivity", "onRoutineClick: $routine")
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("routine", routine)
        startActivity(intent)

    }

    // Populate Folder Spinner with data
    private fun updateFolderSpinner(folderSpinner: Spinner, routines: List<Routine>) {
        val folderNames = routines.map { it.folder ?: "No Folder" }.distinct()
        val folderAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, folderNames)
        folderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        folderSpinner.adapter = folderAdapter
    }

    private fun filterRoutines(routines: List<Routine>) {
        val filteredList = routines.filter { routine ->
            val matchesSchedule = selectedSchedule?.let { it == routine.scheduleV2?.type } ?: true
            val matchesFolder = selectedFolder?.let { it == routine.folder } ?: true
            matchesSchedule && matchesFolder
        }

        if (filteredList.isEmpty()) {
            binding.rvRoutines.visibility = View.GONE
            binding.layoutNoRecordFound.visibility = View.VISIBLE
        } else {
            binding.rvRoutines.visibility = View.VISIBLE
            binding.layoutNoRecordFound.visibility = View.GONE
            routineAdapter.updateList(filteredList)
        }
    }

    private fun updateFilteredTextViewVisibility(tvFiltered: TextView) {
        if (!selectedSchedule.isNullOrEmpty() || !selectedFolder.isNullOrEmpty()) {
            tvFiltered.visibility = View.VISIBLE
        } else {
            tvFiltered.visibility = View.GONE
        }
    }


    private fun setupViews() {
        /* binding.run {
             tvMessage.text =
                 getString(R.string.your_work_starts_here_add_or_update_your_own_views_according_to_your_assignment)
         }*/
    }

    private fun setupObservers() {
        //observer goes here
        generalViewModel.getAuthenticationLive().observe(this) {
            it?.let {
                binding.tvEmail.text = getString(R.string.you_are_logged_in_as, it.name)
            }
        }
    }


    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}