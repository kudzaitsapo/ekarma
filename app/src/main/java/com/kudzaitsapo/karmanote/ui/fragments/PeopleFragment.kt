package com.kudzaitsapo.karmanote.ui.fragments

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.kudzaitsapo.karmanote.ui.adapters.ItemClickListener
import com.kudzaitsapo.karmanote.ui.adapters.PersonAdapter
import com.kudzaitsapo.karmanote.ui.viewmodels.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint
import karmanote.databinding.FragmentPeopleBinding
import kotlinx.android.synthetic.main.fragment_people.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private lateinit var fragmentPeopleBinding: FragmentPeopleBinding

    private val viewModel by viewModels<PeopleViewModel> ()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentPeopleBinding = FragmentPeopleBinding.inflate(inflater)
        return fragmentPeopleBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // This is very bad practice but I'm doing it anyways
        ivEmptyListImage?.visibility = View.GONE
        textView3?.visibility = View.GONE
        textView4?.visibility = View.GONE

        val peopleAdapter = PersonAdapter(ItemClickListener { item ->
            val action = PeopleFragmentDirections.actionPeopleFragmentToDeedsFragment(item.personId)
            findNavController().navigate(action)

        })

        val shapeAppearanceModel = ShapeAppearanceModel().toBuilder().setAllCorners(
            CornerFamily.ROUNDED, 60F).build()
        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {
            fillColor = ColorStateList.valueOf(Color.WHITE)
        }

        fragmentPeopleBinding.svPersonSearch.background = shapeDrawable
        fragmentPeopleBinding.rvPeopleList.adapter = peopleAdapter

        fabAddPerson.setOnClickListener { v ->
            fabClick(v)
        }


        lifecycleScope.launchWhenCreated {
            viewModel.peopleState.collect { people ->
                peopleAdapter.submitList(people)

                if (people.isNotEmpty()) {
                    ivEmptyListImage?.visibility = View.GONE
                    textView3?.visibility = View.GONE
                    textView4?.visibility = View.GONE
                } else {
                    ivEmptyListImage?.visibility = View.VISIBLE
                    textView3?.visibility = View.VISIBLE
                    textView4?.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun fabClick(view: View) {
        val action = PeopleFragmentDirections.actionPeopleFragmentToAddPeopleFragment()
        view.findNavController().navigate(action)
    }
}