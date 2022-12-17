package com.example.Adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.PrecomputedTextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.Room.Entities.NoteEntity
import com.example.kotlincourse.R
import com.example.kotlincourse.databinding.PinnedRvItemsBinding

class PinnedRvAdapter(private var data: ArrayList<NoteEntity> , private var listener: CardClickListener) : RecyclerView.Adapter<PinnedRvAdapter.PinnedRvViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinnedRvViewHolder {

        val PinnedRvItemsBinding : PinnedRvItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context) ,
            R.layout.pinned_rv_items , parent , false)

        return PinnedRvViewHolder(PinnedRvItemsBinding)
    }

    override fun onBindViewHolder(holder: PinnedRvViewHolder, position: Int) {
        holder.bind(data[position] , listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PinnedRvViewHolder(private var binding: PinnedRvItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(noteEntity: NoteEntity, listener: CardClickListener) {
            binding.pinnedtitle.setTextFuture(
                PrecomputedTextCompat.getTextFuture(
                    noteEntity.NoteModel.title , binding.pinnedtitle.textMetricsParamsCompat , null
                )
            )

            binding.pinnedcardview.setCardBackgroundColor(Color.parseColor(noteEntity.NoteModel.color))

            binding.pinneddescription.text = noteEntity.NoteModel.note

            binding.pinnedcardview.setOnClickListener {
                listener.onItemClickListener(noteEntity)
            }

            binding.imageFilterButton.setOnClickListener{
                listener.onMenuItemClickListener(it , noteEntity)
            }

            binding.executePendingBindings()
        }


    }

}