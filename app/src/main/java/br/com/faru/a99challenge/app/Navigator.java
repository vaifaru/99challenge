package br.com.faru.a99challenge.app;


import android.content.Context;
import android.content.Intent;

import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.presentation.person.PersonDetailActivity;
import br.com.faru.a99challenge.util.Constants;

public class Navigator {

    public static void toPersonDetail(Context ctx, Person person) {
        Intent intent = new Intent(ctx, PersonDetailActivity.class);
        intent.putExtra(Constants.PERSON, person);
        ctx.startActivity(intent);
    }

}
