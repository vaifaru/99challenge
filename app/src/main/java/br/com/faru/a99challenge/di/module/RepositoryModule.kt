package br.com.faru.a99challenge.di.module

import br.com.faru.a99challenge.repository.PersonRepository
import br.com.faru.a99challenge.repository.json.PersonJSONReader
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    internal fun providePersonRepository(): PersonRepository {
        return PersonJSONReader()
    }

}
