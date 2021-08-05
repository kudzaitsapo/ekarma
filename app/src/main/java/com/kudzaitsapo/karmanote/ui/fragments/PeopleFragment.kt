package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import karmanote.databinding.FragmentPeopleBinding

class PeopleFragment : Fragment() {

    private lateinit var fragmentPeopleBinding: FragmentPeopleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPeopleBinding = FragmentPeopleBinding.inflate(inflater)
        return fragmentPeopleBinding.root
    }
}