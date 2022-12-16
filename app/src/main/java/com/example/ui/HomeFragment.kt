package com.example.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.Adapters.CardClickListener
import com.example.Adapters.PinnedRvAdapter
import com.example.Adapters.UpcomingRvAdapter
import com.example.Models.NotesModel
import com.example.Room.Entities.NoteEntity
import com.example.ViewModel.AppViewModel
import com.example.kotlincourse.R
import com.example.kotlincourse.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class HomeFragment : Fragment() , CardClickListener{

    private val viewModel: AppViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        //variable in data tag xml
        binding.fragmentHome = this

        setupPinnedRecyclerview()
        setupUpcomingRecyclerview()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setupUpcomingRecyclerview() {

        viewModel.liveData.observe(viewLifecycleOwner) {

            val data: ArrayList<NoteEntity> = ArrayList()

            it.forEach {
                if (!it.NoteModel.pinned) {
                    data.add(it)
                }
            }

            if (data.isEmpty()) {
                binding.textView3.visibility = View.VISIBLE
            } else {
                binding.textView3.visibility = View.GONE

                binding.upcomingRv.adapter = UpcomingRvAdapter(data , this)

            }
        }


    }

    private fun setupPinnedRecyclerview() {
        viewModel.liveData.observe(viewLifecycleOwner) {

            val data: ArrayList<NoteEntity> = ArrayList()

            it.forEach {
                if (it.NoteModel.pinned) {
                    data.add(it)
                }
            }

            if (data.isEmpty())
                binding.pinnedCon.visibility = View.GONE
            else
                binding.pinnedCon.visibility = View.VISIBLE

            binding.pinnedRv.adapter = PinnedRvAdapter(data , this)
        }
    }

    fun fabOnClick(view: View) {
        view.findNavController().navigate(R.id.action_homeFragment_to_singleNoteFragment)
    }

    override fun onItemClickListener(noteEntity: NoteEntity) {

        val bundle = bundleOf("datamodel" to noteEntity)

        Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_singleNoteFragment , bundle)


    }

}