package br.com.faru.a99challenge.presentation.person

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import javax.inject.Inject

import br.com.faru.a99challenge.R
import br.com.faru.a99challenge.app.Navigator
import br.com.faru.a99challenge.di.Injector
import br.com.faru.a99challenge.model.Person
import kotlinx.android.synthetic.main.fragment_persons.*

class PersonsFragment : Fragment(), PersonsContract.View {

    @Inject
    lateinit var presenter: PersonsPresenter

    private var adapter: PersonsAdapter? = null
    private var v: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Injector.getComponent().inject(this)
        v = inflater?.inflate(R.layout.fragment_persons, container, false)

        adapter = PersonsAdapter(this::onClick)
        presenter.setView(this)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listView.adapter = adapter
        presenter.onActivityCreated()
    }

    override fun showResults(persons: List<Person>) {
        adapter?.add(persons)
    }

    override fun setProgressIndicator(active: Boolean) {
        progressView.visibility = if (active) View.VISIBLE else View.GONE
    }

    override fun goToPerson(person: Person) {
        Navigator.toPersonDetail(context, person)
    }

    override fun showMessage(message: String) {
        v?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_SHORT).show()
        }
    }

    fun onClick(person: Person) {
        presenter.onClick(person)
    }

    companion object {

        fun newInstance(): PersonsFragment {
            return PersonsFragment()
        }
    }

}
