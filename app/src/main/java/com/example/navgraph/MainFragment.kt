package com.example.navgraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navgraph.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var personList = arrayListOf<PersonModel>(
        PersonModel("https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728.png","Rick Sanchez","Alive"),
        PersonModel("https://gameir.ie/wp-content/uploads/Rick-and-Morty-How-old-is-Morty-Smith-now.jpg","Morty Smith","Alive"),
        PersonModel("https://e7.pngegg.com/pngimages/739/94/png-clipart-albert-einstein-memorial-scientist-child-hand-thumbnail.png","Albert Einstein","Dead"),
        PersonModel("https://static.wikia.nocookie.net/rickandmorty/images/f/f1/Jerry_Smith.png/revision/latest?cb=20160923151111","Jerry Smith","Alive"),
    )

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainAdapter(personList,this::onClick)
        binding.rvPerson.adapter = adapter
    }

    private fun onClick(personModel: PersonModel) {
        findNavController().navigate(MainFragment.actionMainFragmentToDetailsFragment(personModel))
    }
    }

