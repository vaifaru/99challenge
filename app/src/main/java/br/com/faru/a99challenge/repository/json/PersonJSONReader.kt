package br.com.faru.a99challenge.repository.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

import br.com.faru.a99challenge.app.ChallengeApplication
import br.com.faru.a99challenge.model.Person
import br.com.faru.a99challenge.repository.PersonRepository
import br.com.faru.a99challenge.repository.callback.OnGetPersonsCallback
import br.com.faru.a99challenge.util.Constants

/**
 * Created by faru on 05/04/17.
 */

class PersonJSONReader : PersonRepository {

    override fun getPersons(callback: OnGetPersonsCallback) {
        try {
            val inputStream = ChallengeApplication.application.assets.open(Constants.DATA_FILE)
            val reader = JsonReader(BufferedReader(InputStreamReader(inputStream)))

            val gson = Gson()
            val persons = gson.fromJson<List<Person>>(reader, object : TypeToken<List<Person>>() {

            }.type)

            callback.onGetPersonsSuccess(persons)
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.let { callback.onGetPersonsFailure(it) }
        }

    }
}
