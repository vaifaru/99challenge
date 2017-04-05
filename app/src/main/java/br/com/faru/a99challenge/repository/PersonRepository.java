package br.com.faru.a99challenge.repository;

import br.com.faru.a99challenge.repository.callback.OnGetPersonsCallback;

/**
 * Created by faru on 04/04/17.
 */

public interface PersonRepository {

    void getPersons(final OnGetPersonsCallback callback);

}
