package br.com.faru.a99challenge.app


import android.content.Context
import android.content.Intent

import br.com.faru.a99challenge.model.Person
import br.com.faru.a99challenge.presentation.person.PersonDetailActivity
import br.com.faru.a99challenge.util.Constants

object Navigator {

    fun toPersonDetail(ctx: Context, person: Person) {
        val intent = Intent(ctx, PersonDetailActivity::class.java)
        intent.putExtra(Constants.PERSON, person)
        ctx.startActivity(intent)
    }

}
