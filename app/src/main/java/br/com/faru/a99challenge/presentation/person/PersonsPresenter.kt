package br.com.faru.a99challenge.presentation.person

import java.util.ArrayList
import java.util.Collections
import java.util.HashSet

import javax.inject.Inject

import br.com.faru.a99challenge.model.Person
import br.com.faru.a99challenge.repository.PersonRepository
import br.com.faru.a99challenge.repository.callback.OnGetPersonsCallback


class PersonsPresenter @Inject
    constructor(var repository: PersonRepository) : PersonsContract.UserInteractions, OnGetPersonsCallback {

    private var view: PersonsContract.View? = null

    override fun setView(view: PersonsContract.View) {
        this.view = view
    }

    override fun onActivityCreated() {
        view?.setProgressIndicator(true)
        repository.getPersons(this)
    }

    override fun onClick(person: Person) {
        view?.goToPerson(person)
    }

    override fun onGetPersonsSuccess(persons: List<Person>) {
        val personList = ArrayList(HashSet(persons))
        Collections.sort(personList)

        view?.setProgressIndicator(false)
        view?.showResults(personList)
    }

    override fun onGetPersonsFailure(message: String) {
        view?.setProgressIndicator(false)
        view?.showMessage(message)
    }

}
