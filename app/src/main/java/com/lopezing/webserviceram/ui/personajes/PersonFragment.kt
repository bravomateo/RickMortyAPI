package com.lopezing.webserviceram.ui.personajes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lopezing.webserviceram.databinding.FragmentHomeBinding
import com.lopezing.webserviceram.server.model.Person

class PersonFragment : Fragment() {

    private lateinit var personViewModel : PersonViewModel
    private lateinit var personAdapter: PersonAdapter
    private lateinit var homeBinding: FragmentHomeBinding
    private var personList: ArrayList<Person> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        personViewModel = ViewModelProvider(this)[PersonViewModel::class.java]
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personAdapter =PersonAdapter(personList, onItemClicked = { onPersonItemClicked(it)})
        personViewModel.personObserve.observe(viewLifecycleOwner){ result ->
            onMoviesLoadedSubscribe(result)
        }
        homeBinding.moviesRecyclerView.apply {
            layoutManager=LinearLayoutManager(this@PersonFragment.requireContext())
            adapter=personAdapter
            setHasFixedSize(false)
        }
        personViewModel.getRaM()

    }

    private fun onPersonItemClicked(person: Person) {
        findNavController().navigate(PersonFragmentDirections.actionNavigationHomeToDetailsFragment(person))
    }
    private fun onMoviesLoadedSubscribe(personsList: ArrayList<Person>?) {
        personsList?.let { personsList->
            personAdapter.appendItems(personsList)
        }
    }
}