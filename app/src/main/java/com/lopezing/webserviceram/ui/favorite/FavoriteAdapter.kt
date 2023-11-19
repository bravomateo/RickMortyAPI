package com.lopezing.webserviceram.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.lopezing.webserviceram.R
import com.lopezing.webserviceram.databinding.CardViewItemRamBinding
import com.lopezing.webserviceram.local.LocalPerson
import com.squareup.picasso.Picasso

class FavoriteAdapter  (
    private val favoriteList: MutableList<LocalPerson>,
    private val onItemClicked:(LocalPerson) -> Unit,
    private val onLongItemClickListener: (LocalPerson)->Unit
): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val  itemView= LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_ram,parent,false)
        return FavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val  favorite=favoriteList[position]
        holder.bindPerson(favorite)
        holder.itemView.setOnClickListener{onItemClicked(favoriteList[position])}
        holder.itemView.setOnLongClickListener{onLongItemClickListener(favoriteList[position])
        true
        }

    }
    override fun getItemCount(): Int = favoriteList.size
    fun appendItems(newList: ArrayList<LocalPerson>) {
        favoriteList.clear()
        favoriteList.addAll(newList)
        notifyDataSetChanged()
    }
    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding= CardViewItemRamBinding.bind(itemView)

        fun bindPerson(person: LocalPerson){
            with(binding){
                nameTitleTextView.text= person.name
                specieDateTextView.text=person.species
                genderAverageTextView.text=person.gender
                Picasso.get().load(person.image).into(posterImageView)
            }
        }
    }

}