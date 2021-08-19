package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kudzaitsapo.karmanote.ui.adapters.DeedAdapter
import com.kudzaitsapo.karmanote.ui.adapters.DeedClickListener
import com.kudzaitsapo.karmanote.ui.viewmodels.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint
import karmanote.databinding.FragmentDeedsBinding
import kotlinx.android.synthetic.main.fragment_add_person.*
import kotlinx.android.synthetic.main.fragment_deeds.*
import kotlinx.android.synthetic.main.fragment_deeds.tbTopToolbar
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DeedsFragment : Fragment() {

    private lateinit var fragmentDeedsBinding: FragmentDeedsBinding
    private val args: DeedsFragmentArgs by navArgs()
    private val viewModel by viewModels<PersonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDeedsBinding = FragmentDeedsBinding.inflate(inflater)
        return fragmentDeedsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val personId = args.personId

        val deedAdapter = DeedAdapter(DeedClickListener { deed ->
            Toast.makeText(activity, "You have clicked deed with id ${deed.id}", Toast.LENGTH_LONG).show()
        })

        fragmentDeedsBinding.rvGratefulReasons.adapter = deedAdapter

        // Very very very bad but I'm doing it anyways, until I find a better way of doing it
        clEmptyList?.visibility = View.GONE

        tbTopToolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        fabAddDeed.setOnClickListener {
            val action = DeedsFragmentDirections.actionDeedsFragmentToAddDeedFragment(personId)
            findNavController().navigate(action)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.getPersonDeeds(personId).collect { deeds ->
                deedAdapter.submitList(deeds)

                if (deeds.isNotEmpty()) {
                    clEmptyList?.visibility = View.GONE
                } else {
                    clEmptyList?.visibility = View.VISIBLE
                }
            }
        }


    }
}