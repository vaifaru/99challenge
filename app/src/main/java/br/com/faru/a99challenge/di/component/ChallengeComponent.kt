package br.com.faru.a99challenge.di.component

import br.com.faru.a99challenge.di.module.RepositoryModule
import br.com.faru.a99challenge.di.scope.ActivityScope
import br.com.faru.a99challenge.presentation.person.PersonDetailFragment
import br.com.faru.a99challenge.presentation.person.PersonsFragment
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(RepositoryModule::class))
interface ChallengeComponent {

    fun inject(personsFragment: PersonsFragment)

    fun inject(personDetailFragment: PersonDetailFragment)
}
