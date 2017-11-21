package br.com.faru.a99challenge.presentation.person

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import javax.inject.Inject

import br.com.faru.a99challenge.R
import br.com.faru.a99challenge.di.Injector
import br.com.faru.a99challenge.model.Person
import br.com.faru.a99challenge.util.Constants
import kotlinx.android.synthetic.main.fragment_person_detail.*

class PersonDetailFragment : Fragment(), PersonDetailContract.View {

    @Inject
    lateinit var presenter: PersonDetailPresenter

    private var person: Person? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater?.inflate(R.layout.fragment_person_detail, container, false)

        Injector.getComponent().inject(this)

        if (arguments.containsKey(Constants.PERSON)) {
            person = arguments.getParcelable(Constants.PERSON)
        }

        presenter.setView(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onActivityCreated(person)
    }

    override fun showInfo(person: Person) {
        bio.text = if (TextUtils.isEmpty(person.bio)) getString(R.string.empty_bio) else person.bio
    }

    companion object {

        fun newInstance(person: Person): PersonDetailFragment {
            val fragment = PersonDetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(Constants.PERSON, person)
            fragment.arguments = bundle

            return fragment
        }
    }

}
