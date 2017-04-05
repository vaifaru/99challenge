package br.com.faru.a99challenge.presentation.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import br.com.faru.a99challenge.R;
import br.com.faru.a99challenge.presentation.BaseActivity;

public class PersonsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        showPersonsFragment();
    }

    private void showPersonsFragment() {
        Fragment currentFragment = getFragmentByTag(PersonDetailFragment.class.getCanonicalName());
        if (currentFragment == null) {
            currentFragment = PersonsFragment.newInstance();
        }

        replaceFragmentWithTag(currentFragment, R.id.container);
    }

}
