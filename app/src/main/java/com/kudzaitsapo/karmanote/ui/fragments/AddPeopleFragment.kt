package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kudzaitsapo.karmanote.ui.viewmodels.PeopleViewModel
import com.kudzaitsapo.karmanote.ui.viewmodels.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import karmanote.R
import karmanote.databinding.FragmentAddDeedBinding
import karmanote.databinding.FragmentAddPersonBinding
import karmanote.databinding.FragmentPeopleBinding
import kotlinx.android.synthetic.main.fragment_add_person.*

@AndroidEntryPoint
class AddPeopleFragment : Fragment() {

    private lateinit var fragmentAddPeopleBinding: FragmentAddPersonBinding
    private val viewModel by viewModels<PersonViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAddPeopleBinding = FragmentAddPersonBinding.inflate(inflater)
        return fragmentAddPeopleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbTopToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        btnSave.setOnClickListener {
            if (etPersonName.text.toString().isNotEmpty() && etDeed.text.toString().isNotEmpty()) {
                val personId = viewModel.createPerson(etPersonName.text.toString()).toInt()
                viewModel.createDeedForPerson(personId, etDeed.text.toString())
                Toast.makeText(activity, "Successfully saved ${etPersonName.text}", Toast.LENGTH_LONG).show()
                findNavController().popBackStack()

            } else {
                Toast.makeText(activity, "There has to be something you are grateful for, and someone you are grateful to, right?", Toast.LENGTH_LONG).show()
            }
        }


    }
}