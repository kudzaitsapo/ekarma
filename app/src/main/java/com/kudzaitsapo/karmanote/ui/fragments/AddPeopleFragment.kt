package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import karmanote.databinding.FragmentPeopleBinding

class AddPeopleFragment : Fragment() {

    private lateinit var fragmentAddPeopleBinding: FragmentPeopleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAddPeopleBinding = FragmentPeopleBinding.inflate(inflater)
        return fragmentAddPeopleBinding.root
    }
}