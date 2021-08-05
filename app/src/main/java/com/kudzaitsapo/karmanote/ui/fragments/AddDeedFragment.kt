package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import karmanote.databinding.FragmentAddDeedBinding

class AddDeedFragment : Fragment() {

    private lateinit var fragmentAddDeedBinding : FragmentAddDeedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentAddDeedBinding = FragmentAddDeedBinding.inflate(inflater)
        return fragmentAddDeedBinding.root
    }
}