package br.com.faru.a99challenge.presentation.person

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

import br.com.faru.a99challenge.R
import br.com.faru.a99challenge.model.Person
import com.facebook.drawee.view.SimpleDraweeView

class PersonsAdapter(private val onClick: (p: Person) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val personList: MutableList<Person>

    init {
        this.personList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_person, parent, false), onClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(personList[position])
    }

    fun add(personList: List<Person>) {
        this.personList.addAll(personList)
        notifyDataSetChanged()
    }

    override fun getItemCount() = personList.size

    fun getItem(position: Int) = personList[position]

    inner class ViewHolder(itemView: View, private val onClick: (p: Person) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val image by lazy { itemView.findViewById(R.id.image) as SimpleDraweeView }
        private val name by lazy { itemView.findViewById(R.id.name) as TextView }
        private val character by lazy { itemView.findViewById(R.id.character) as View }

        fun bind(person: Person) {
            image.setImageURI(person.image)
            name.text = person.name
            listener()
        }

        private fun listener() = character.setOnClickListener({ onClick(getItem(adapterPosition)) })
    }

}
