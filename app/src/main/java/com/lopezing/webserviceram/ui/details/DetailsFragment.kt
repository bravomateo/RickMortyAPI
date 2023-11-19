package com.lopezing.webserviceram.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.lopezing.webserviceram.R
import com.lopezing.webserviceram.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private lateinit var detailsBinding: FragmentDetailsBinding
    private lateinit var detailsViewModel: DetailsViewModel
    private var favoriteOn  = false
    private val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsBinding= FragmentDetailsBinding.inflate(inflater,container,false)
        detailsViewModel=ViewModelProvider(this)[DetailsViewModel::class.java]
        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val person=args.person
        detailsViewModel.personFavorite.observe(viewLifecycleOwner) {result->
            if(result == true) {
                detailsBinding.imgeFavorite.setImageResource(R.drawable.ic_favorite_good)
                favoriteOn=true
            }
            else {detailsBinding.imgeFavorite.setImageResource(R.drawable.ic_favorite_no)}
        }
        detailsViewModel.favoriteOn(person)
        with(detailsBinding){

            personTitleTextView.text = person.name
            specieDateTextView.text = person.species
            genderAverageTextView.text = person.gender
            summaryTextView.text = "The individual is "+person.name+", resides in "+ person.location?.name+" was born in  "+person.origin?.name+"  and was created on "+person.created
            Picasso.get().load(person.image).into(posterImageView)
            imgeFavorite.setOnClickListener{
                if (favoriteOn) {
                    Toast.makeText(requireActivity()," ${person.name} is already in favorites", Toast.LENGTH_LONG).show()
                }
                else {
                    detailsViewModel.addPersonToFavorites(person)
                    detailsBinding.imgeFavorite.setImageResource(R.drawable.ic_favorite_good)
                    favoriteOn=true
                    Toast.makeText(requireActivity()," ${person.name} added to favorites", Toast.LENGTH_LONG).show()

                }
            }
            }
    }
}


