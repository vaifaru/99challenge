package br.com.faru.a99challenge.presentation.person;

import java.util.List;

import br.com.faru.a99challenge.model.Person;

public interface PersonsContract {

    interface View {

        void showResults(List<Person> persons);

        void setProgressIndicator(boolean active);

        void goToPerson(Person person);

        void showMessage(String message);
    }

    interface UserInteractions {

        void setView(View view);

        void onCreate();

        void onClick(Person person);
    }

}
