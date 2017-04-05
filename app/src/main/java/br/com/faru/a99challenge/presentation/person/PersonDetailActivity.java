package br.com.faru.a99challenge.presentation.person;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.facebook.drawee.view.SimpleDraweeView;

import br.com.faru.a99challenge.R;
import br.com.faru.a99challenge.model.Person;
import br.com.faru.a99challenge.presentation.BaseActivity;
import br.com.faru.a99challenge.util.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.image)
    SimpleDraweeView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        if (getIntent().getExtras().containsKey(Constants.PERSON)) {
            Person person = getIntent().getExtras().getParcelable(Constants.PERSON);
            initToolbar(person);
            showPersonDetailFragment(person);
        } else {
            throw new IllegalArgumentException("Bundle must contains a \"person\" key");
        }
    }

    private void showPersonDetailFragment(Person person) {
        Fragment currentFragment = getFragmentByTag(PersonDetailFragment.class.getCanonicalName());
        if (currentFragment == null) {
            currentFragment = PersonDetailFragment.newInstance(person);
        }

        replaceFragmentWithTag(currentFragment, R.id.container);
    }

    private void initToolbar(Person person) {
        if (getSupportActionBar() != null) {
            image.setImageURI(person.getImage());

            if (TextUtils.isEmpty(person.getImage())) {
                collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.white));
            }

            collapsingToolbar.setTitle(person.getName());
            collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));

            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
