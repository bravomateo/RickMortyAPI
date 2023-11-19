package com.lopezing.webserviceram.ui.favorite

import android.os.Bundle
import android.system.Os.accept
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.compose.ui.window.Dialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lopezing.webserviceram.R
import com.lopezing.webserviceram.databinding.FragmentFavoriteBinding
import com.lopezing.webserviceram.local.LocalPerson
import com.lopezing.webserviceram.server.model.Person
import java.nio.file.attribute.AclEntry

class FavoriteFragment : Fragment() {

    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteBinding:FragmentFavoriteBinding
    private var personList:ArrayList<LocalPerson> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        favoriteBinding = FragmentFavoriteBinding.inflate(inflater, container, false)
        favoriteViewModel.loadFavorite()
        favoriteAdapter = FavoriteAdapter(personList, onItemClicked ={onItemCliked(it)} ,onLongItemClickListener = {onItemLongClicked(it)})

        favoriteBinding.recyclerViewFavorite.apply {
            layoutManager = LinearLayoutManager(this@FavoriteFragment.context)
            adapter = favoriteAdapter
            setHasFixedSize(false)
        }
        favoriteViewModel.personLoad.observe(viewLifecycleOwner) {result->
            favoriteAdapter.appendItems(result)
        }
        return favoriteBinding.root
    }

    private fun onItemLongClicked(localPerson: LocalPerson) {
        val alertDialog:AlertDialog?=activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage("You want to remove ${localPerson.name} from favorites?")
                setPositiveButton(R.string.accept){ dialog,id ->
                    favoriteViewModel.favoriteDelete(localPerson)
                }
                setNegativeButton(R.string.cancel){dialog,id->
                }
            }
            builder.create()
        }
        alertDialog?.show()
    }


    private fun onItemCliked(localPerson: LocalPerson) {
        val person = Person()
        person.name =localPerson.name
        person.image=localPerson.image
        person.gender=localPerson.gender
        person.species=localPerson.species
        person.location?.name=localPerson.status
        person.origin?.name=localPerson.origin

        findNavController().navigate(FavoriteFragmentDirections.actionNavigationFavoriteToDetailsFavFragment(localPerson))
    }
}