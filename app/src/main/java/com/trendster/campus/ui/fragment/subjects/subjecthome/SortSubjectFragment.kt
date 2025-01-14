package com.trendster.campus.ui.fragment.subjects.subjecthome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.trendster.campus.databinding.FragmentSortSubjectBinding
import com.trendster.campus.viewmodels.mainviewmodel.MainViewModel

class SortSubjectFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSortSubjectBinding? = null
    private val binding get() = _binding!!
    private var branchChip = "CSE"
    private var semesterChip = "1"
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSortSubjectBinding.inflate(inflater, container, false)

        binding.chipGroupAddBranch.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            val selectedBranchChip = chip.text.toString()
            branchChip = selectedBranchChip
        }
        binding.chipGroupAddSemester.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            val selectedSemesterChip = chip.text.toString()
            semesterChip = selectedSemesterChip
        }

        binding.btnUpdate.setOnClickListener {
            mainViewModel.sortSubject(branchChip, semesterChip)
            findNavController().navigateUp()
        }

        return binding.root
    }
}
