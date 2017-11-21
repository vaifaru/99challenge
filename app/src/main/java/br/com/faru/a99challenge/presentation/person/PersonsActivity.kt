package br.com.faru.a99challenge.presentation.person

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.view.View

import br.com.faru.a99challenge.R
import br.com.faru.a99challenge.presentation.BaseActivity

class PersonsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persons)
        showPersonsFragment()
    }

    private fun showPersonsFragment() {
        var currentFragment = getFragmentByTag(PersonDetailFragment::class.java.canonicalName)
        if (currentFragment == null) {
            currentFragment = PersonsFragment.newInstance()
        }

        replaceFragmentWithTag(currentFragment, R.id.container)
    }

}
