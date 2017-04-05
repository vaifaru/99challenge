package br.com.faru.a99challenge.presentation.person;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import br.com.faru.a99challenge.R;
import br.com.faru.a99challenge.model.Person;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Person> personList;
    private PersonsFragment.OnPersonClickListener onClickListener;

    public PersonsAdapter(PersonsFragment.OnPersonClickListener onClickListener) {
        this.personList = new ArrayList<>();
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false), onClickListener);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Person person = personList.get(position);
        viewHolder.image.setImageURI(person.getImage());
        viewHolder.name.setText(person.getName());
    }

    public void add(List<Person> personList) {
        this.personList.addAll(personList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return personList == null ? 0 : personList.size();
    }

    public Person getItem(int position) {
        return personList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        public SimpleDraweeView image;

        @BindView(R.id.name)
        public TextView name;

        private PersonsFragment.OnPersonClickListener onPersonClickListener;

        public ViewHolder(View itemView, PersonsFragment.OnPersonClickListener onPersonClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.onPersonClickListener = onPersonClickListener;
        }

        @OnClick(R.id.character)
        public void onClick() {
            onPersonClickListener.onClick(getItem(getAdapterPosition()));
        }

    }

}
