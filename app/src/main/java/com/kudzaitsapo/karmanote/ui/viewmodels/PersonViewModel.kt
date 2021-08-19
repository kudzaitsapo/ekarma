package com.kudzaitsapo.karmanote.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.kudzaitsapo.karmanote.models.DeedEntity
import com.kudzaitsapo.karmanote.models.PeopleEntity
import com.kudzaitsapo.karmanote.repository.DbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PersonViewModel
@Inject
constructor(private val repository: DbRepository) : ViewModel()
{
    fun createPerson(fullName: String) : Long {
        val person = PeopleEntity(fullName = fullName)
        return repository.createPerson(person)
    }

    fun createDeedForPerson(personId: Int, deed: String) : Long {
        val deedEntity = DeedEntity(personId = personId, description = deed)
        return repository.createDeed(deedEntity)
    }

    fun getPersonDeeds(personId: Int) : Flow<List<DeedEntity>> {
        return repository.getPersonDeeds(personId)
    }
}