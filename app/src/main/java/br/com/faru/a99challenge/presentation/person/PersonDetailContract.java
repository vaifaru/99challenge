package br.com.faru.a99challenge.presentation.person;

import br.com.faru.a99challenge.model.Person;

public interface PersonDetailContract {

    interface View {

        void showInfo(Person person);

    }

    interface UserInteractions {

        void setView(PersonDetailContract.View view);

        void onCreate(Person person);

    }

}
