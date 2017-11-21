package br.com.faru.a99challenge.repository.callback

import br.com.faru.a99challenge.model.Person


interface OnGetPersonsCallback {
    fun onGetPersonsSuccess(persons: List<Person>)

    fun onGetPersonsFailure(message: String)
}
