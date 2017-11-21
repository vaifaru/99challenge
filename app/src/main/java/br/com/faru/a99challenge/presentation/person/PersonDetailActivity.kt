package br.com.faru.a99challenge.presentation.person

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.text.TextUtils

import com.facebook.drawee.view.SimpleDraweeView

import br.com.faru.a99challenge.R
import br.com.faru.a99challenge.model.Person
import br.com.faru.a99challenge.presentation.BaseActivity
import br.com.faru.a99challenge.util.Constants
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_person_detail.*

class PersonDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_person_detail)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)

        if (intent.extras.containsKey(Constants.PERSON)) {
            val person = intent.extras.getParcelable<Person>(Constants.PERSON)
            initToolbar(person)
            showPersonDetailFragment(person)
        } else {
            throw IllegalArgumentException("Bundle must contains a \"person\" key")
        }
    }

    private fun showPersonDetailFragment(person: Person) {
        var currentFragment: Fragment? = getFragmentByTag(PersonDetailFragment::class.java.canonicalName)
        if (currentFragment == null) {
            currentFragment = PersonDetailFragment.newInstance(person)
        }

        replaceFragmentWithTag(currentFragment, R.id.container)
    }

    private fun initToolbar(person: Person) {
        if (supportActionBar != null) {
            image.setImageURI(person.image)

            if (TextUtils.isEmpty(person.image)) {
                collapsingToolbar.setExpandedTitleColor(resources.getColor(android.R.color.white))
            }

            collapsingToolbar.title = person.name
            collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(android.R.color.white))

            supportActionBar?.setDisplayShowTitleEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
