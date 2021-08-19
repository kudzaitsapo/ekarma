package com.kudzaitsapo.karmanote.repository

import com.kudzaitsapo.karmanote.data.dao.DeedsDao
import com.kudzaitsapo.karmanote.data.dao.PeopleDao
import com.kudzaitsapo.karmanote.models.DeedEntity
import com.kudzaitsapo.karmanote.models.PeopleEntity
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class DbRepository
@Inject
constructor(val personDAO: PeopleDao, val deedsDao: DeedsDao) {


    // Methods dealing with people
    fun createPerson(person: PeopleEntity) : Long = personDAO.insertPerson(person)

    fun getAllPeople() : Flow<List<PeopleEntity>> = personDAO.getAll()

    fun deletePerson(person: PeopleEntity) = personDAO.delete(person)

    // Methods dealing with deeds
    fun createDeed(deedEntity: DeedEntity) : Long = deedsDao.insertDeed(deedEntity)

    fun getPersonDeeds(personId: Int) : Flow<List<DeedEntity>> = deedsDao.getPersonDeeds(personId)

    fun updateDeed(deedEntity: DeedEntity) = deedsDao.updateDeed(deedEntity)

    fun deleteDeed(deedEntity: DeedEntity) = deedsDao.delete(deedEntity)



}