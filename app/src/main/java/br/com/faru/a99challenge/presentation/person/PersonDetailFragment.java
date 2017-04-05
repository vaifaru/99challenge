package br.com.faru.a99challenge.presentation.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import br.com.faru.a99challenge.R;
import br.com.faru.a99challenge.di.Injector;
import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.util.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonDetailFragment extends Fragment implements PersonDetailContract.View {

    @BindView(R.id.bio)
    TextView bio;

    @Inject
    PersonDetailPresenter presenter;

    private Person person;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_person_detail, container, false);
        ButterKnife.bind(this, view);

        Injector.getInstance().getComponent().inject(this);

        if (getArguments().containsKey(Constants.PERSON)) {
            person = getArguments().getParcelable(Constants.PERSON);
        }

        presenter.setView(this);
        presenter.onCreate(person);

        return view;
    }

    public static PersonDetailFragment newInstance(Person person) {
        PersonDetailFragment fragment = new PersonDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.PERSON, person);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void showInfo(Person person) {
        bio.setText(TextUtils.isEmpty(person.getBio()) ? getString(R.string.empty_bio) : person.getBio());
    }

}
