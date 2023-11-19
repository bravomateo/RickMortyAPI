package com.lopezing.webserviceram.ui.personajes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lopezing.webserviceram.R
import com.lopezing.webserviceram.databinding.CardViewItemRamBinding
import com.lopezing.webserviceram.server.model.Person
import com.squareup.picasso.Picasso

class PersonAdapter (
    private val personsList: MutableList<Person>,
    private val onItemClicked:(Person) -> Unit
    ): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val  itemView= LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_ram,parent,false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val  person=personsList[position]
        holder.bindPerson(person)
        holder.itemView.setOnClickListener{onItemClicked(personsList[position])}

    }
    override fun getItemCount(): Int = personsList.size

    fun appendItems(newList: List<Person>) {
        personsList.clear()
        personsList.addAll(newList)
        notifyDataSetChanged()
    }
    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding= CardViewItemRamBinding.bind(itemView)

        fun bindPerson(person:Person){
            with(binding){
                nameTitleTextView.text= person.name
                specieDateTextView.text=person.species
                genderAverageTextView.text=person.gender
                Picasso.get().load(person.image).into(posterImageView)
            }
        }
    }

}