package com.example.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.Room.Entities.NoteEntity
import com.example.kotlincourse.R
import com.example.kotlincourse.databinding.UpcomingRvItemsBinding

class UpcomingRvAdapter(private var data : ArrayList<NoteEntity> , private var listener: CardClickListener) : RecyclerView.Adapter<UpcomingRvAdapter.UpcimoingRvViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcimoingRvViewHolder {
        val UpcomingRvItemsBinding : UpcomingRvItemsBinding =  DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.upcoming_rv_items , parent , false)

        return UpcimoingRvViewHolder(UpcomingRvItemsBinding)
    }

    override fun onBindViewHolder(holder: UpcimoingRvViewHolder, position: Int) {
        holder.bind(data[position] , listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class UpcimoingRvViewHolder(private val binding: UpcomingRvItemsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(noteEntity: NoteEntity, listener: CardClickListener){

            binding.upcomingCard.setCardBackgroundColor(Color.parseColor(noteEntity.NoteModel.color))

            binding.pinnedtitle.text = noteEntity.NoteModel.title

            binding.pinneddescription.text = noteEntity.NoteModel.note

            binding.upcomingCard.setOnClickListener {
                listener.onItemClickListener(noteEntity)
            }

            binding.imageFilterButton2.setOnClickListener{
                listener.onMenuItemClickListener(it , noteEntity)
            }

            binding.executePendingBindings()
        }
    }
}