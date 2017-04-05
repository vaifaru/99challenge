package br.com.faru.a99challenge.di.module;

import br.com.faru.a99challenge.repository.PersonRepository;
import br.com.faru.a99challenge.repository.json.PersonJSONReader;
import dagger.Module;
import dagger.Provides;

/**
 * Created by faru on 04/04/17.
 */

@Module
public class RepositoryModule {

    @Provides
    PersonRepository providePersonRepository() {
        return new PersonJSONReader();
    }

}
