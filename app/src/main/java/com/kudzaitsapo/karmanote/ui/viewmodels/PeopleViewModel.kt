package com.kudzaitsapo.karmanote.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kudzaitsapo.karmanote.models.PeopleEntity
import com.kudzaitsapo.karmanote.repository.DbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PeopleViewModel
@Inject
constructor(private val repository: DbRepository) : ViewModel()
{
    private val _peopleState = MutableStateFlow(emptyList<PeopleEntity>())

    val peopleState: StateFlow<List<PeopleEntity>>
        get() = _peopleState

    init {
       viewModelScope.launch {
           repository.getAllPeople().collect {
               _peopleState.value = it
           }
       }
    }
}