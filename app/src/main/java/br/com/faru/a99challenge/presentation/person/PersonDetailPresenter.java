package br.com.faru.a99challenge.presentation.person;

import javax.inject.Inject;

import br.com.faru.a99challenge.model.Person;

public class PersonDetailPresenter implements PersonDetailContract.UserInteractions {

    private PersonDetailContract.View view;

    @Inject
    public PersonDetailPresenter() {
    }

    @Override
    public void setView(PersonDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate(Person person) {
        view.showInfo(person);
    }

}
