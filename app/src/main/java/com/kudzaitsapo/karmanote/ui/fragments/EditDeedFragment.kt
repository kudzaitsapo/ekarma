package com.kudzaitsapo.karmanote.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import karmanote.databinding.FragmentEditDeedBinding

class EditDeedFragment: Fragment() {

    private lateinit var fragmentEditDeedBinding: FragmentEditDeedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEditDeedBinding = FragmentEditDeedBinding.inflate(inflater)
        return fragmentEditDeedBinding.root
    }
}