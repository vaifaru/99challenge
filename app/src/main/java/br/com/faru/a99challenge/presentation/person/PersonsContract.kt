package br.com.faru.a99challenge.presentation.person

import br.com.faru.a99challenge.model.Person

interface PersonsContract {

    interface View {

        fun showResults(persons: List<Person>)

        fun setProgressIndicator(active: Boolean)

        fun goToPerson(person: Person)

        fun showMessage(message: String)
    }

    interface UserInteractions {

        fun setView(view: View)

        fun onActivityCreated()

        fun onClick(person: Person)
    }

}
