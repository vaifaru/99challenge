package br.com.faru.a99challenge.util;


import android.content.Context;
import android.content.Intent;

import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.presentation.person.PersonDetailActivity;

public class Navigation {

    public static void goToPerson(Context ctx, Person person) {
        Intent intent = new Intent(ctx, PersonDetailActivity.class);
        intent.putExtra(Constants.PERSON, person);
        ctx.startActivity(intent);
    }

}
