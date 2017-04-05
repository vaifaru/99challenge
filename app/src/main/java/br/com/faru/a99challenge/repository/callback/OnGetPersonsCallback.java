package br.com.faru.a99challenge.repository.callback;

import java.util.List;

import br.com.faru.a99challenge.model.Person;

/**
 * Created by faru on 04/04/17.
 */

public interface OnGetPersonsCallback {
    void onGetPersonsSuccess(List<Person> persons);

    void onGetPersonsFailure(String message);
}
