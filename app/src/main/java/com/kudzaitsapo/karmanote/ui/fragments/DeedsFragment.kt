package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import karmanote.databinding.FragmentDeedsBinding

class DeedsFragment : Fragment() {

    private lateinit var fragmentDeedsBinding: FragmentDeedsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDeedsBinding = FragmentDeedsBinding.inflate(inflater)
        return fragmentDeedsBinding.root
    }
}