package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kudzaitsapo.karmanote.ui.viewmodels.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import karmanote.databinding.FragmentAddDeedBinding
import kotlinx.android.synthetic.main.fragment_add_deed.*
import kotlinx.android.synthetic.main.fragment_deeds.tbTopToolbar

@AndroidEntryPoint
class AddDeedFragment : Fragment() {

    private lateinit var fragmentAddDeedBinding : FragmentAddDeedBinding
    private val viewModel by viewModels<PersonViewModel> ()
    private val args: AddDeedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAddDeedBinding = FragmentAddDeedBinding.inflate(inflater)
        return fragmentAddDeedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val personId = args.personId

        tbTopToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        btnSave.setOnClickListener {
            if (etDeedInput.text.toString().isNotEmpty()) {
                viewModel.createDeedForPerson(personId, etDeedInput.text.toString())
                Toast.makeText(activity, "Successfully saved the reason for your gratefulness", Toast.LENGTH_LONG).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(activity, "There has to be a reason for you to be grateful to this person, right?", Toast.LENGTH_LONG).show()
            }
        }


    }
}