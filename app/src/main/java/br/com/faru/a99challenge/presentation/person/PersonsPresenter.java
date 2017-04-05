package br.com.faru.a99challenge.presentation.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.repository.PersonRepository;
import br.com.faru.a99challenge.repository.callback.OnGetPersonsCallback;


public class PersonsPresenter implements PersonsContract.UserInteractions,
        OnGetPersonsCallback {

    PersonRepository repository;

    private PersonsContract.View view;

    @Inject
    public PersonsPresenter(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setView(PersonsContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.setProgressIndicator(true);
        repository.getPersons(this);
    }

    @Override
    public void onClick(Person person) {
        view.goToPerson(person);
    }

    @Override
    public void onGetPersonsSuccess(List<Person> persons) {
        final ArrayList<Person> personList = new ArrayList<>(new HashSet<>(persons));
        Collections.sort(personList);

        view.setProgressIndicator(false);
        view.showResults(personList);
    }

    @Override
    public void onGetPersonsFailure(String message) {
        view.setProgressIndicator(false);
        view.showMessage(message);
    }

}
