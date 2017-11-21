package br.com.faru.a99challenge.repository

import br.com.faru.a99challenge.repository.callback.OnGetPersonsCallback

interface PersonRepository {

    fun getPersons(callback: OnGetPersonsCallback)

}
