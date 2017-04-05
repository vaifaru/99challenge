package br.com.faru.a99challenge.repository.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import br.com.faru.a99challenge.app.ChallengeApplication;
import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.repository.PersonRepository;
import br.com.faru.a99challenge.repository.callback.OnGetPersonsCallback;
import br.com.faru.a99challenge.util.Constants;

/**
 * Created by faru on 05/04/17.
 */

public class PersonJSONReader implements PersonRepository {

    @Override
    public void getPersons(OnGetPersonsCallback callback) {
        try {
            final InputStream is = ChallengeApplication.getApplication().getAssets().open(Constants.DATA_FILE);
            JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(is)));

            final Gson gson = new Gson();
            List<Person> persons = gson.fromJson(reader, new TypeToken<List<Person>>() {
            }.getType());

            callback.onGetPersonsSuccess(persons);
        } catch (Exception e) {
            e.printStackTrace();
            callback.onGetPersonsFailure(e.getMessage());
        }
    }
}
