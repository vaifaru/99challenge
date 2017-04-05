package br.com.faru.a99challenge.di.component;

import br.com.faru.a99challenge.di.module.RepositoryModule;
import br.com.faru.a99challenge.di.scope.ActivityScope;
import br.com.faru.a99challenge.presentation.person.PersonDetailFragment;
import br.com.faru.a99challenge.presentation.person.PersonsFragment;
import dagger.Component;

@ActivityScope
@Component(modules = {RepositoryModule.class})
public interface ChallengeComponent {

    void inject(PersonsFragment personsFragment);

    void inject(PersonDetailFragment personDetailFragment);
}
