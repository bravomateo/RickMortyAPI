package com.lopezing.webserviceram.ui.favorite.details

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
import com.lopezing.webserviceram.databinding.FragmentDetailsFavBinding
import com.lopezing.webserviceram.ui.details.DetailsFragmentArgs
import com.lopezing.webserviceram.ui.details.DetailsViewModel
import com.squareup.picasso.Picasso

class DetailsFavFragment : Fragment() {

    private lateinit var detailsBinding: FragmentDetailsFavBinding
    private lateinit var detailsViewModel: DetailsFavViewModel
    private val args: DetailsFavFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsBinding= FragmentDetailsFavBinding.inflate(inflater,container,false)
        detailsViewModel=ViewModelProvider(this)[DetailsFavViewModel::class.java]
        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)

        val person=args.localperson


        with(detailsBinding){
            personTitleTextView.text=person.name
            specieDateTextView.text=person.species
            genderAverageTextView.text=person.gender
            summaryTextView.text="He is "+person.name+", he lives in "+person.status+" from "+person.origin+" and was created in "+person.origin
            Picasso.get().load(person.image).into(posterImageView)

        }
    }

}