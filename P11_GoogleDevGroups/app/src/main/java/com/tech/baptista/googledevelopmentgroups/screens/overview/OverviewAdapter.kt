package com.tech.baptista.googledevelopmentgroups.screens.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tech.baptista.googledevelopmentgroups.databinding.OverviewItemBinding
import com.tech.baptista.googledevelopmentgroups.repository.network.DevGroupChapter

class OverviewAdapter(val clickListener: ItemClickListener): ListAdapter<DevGroupChapter, OverviewAdapter.OverviewViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<DevGroupChapter>() {
        override fun areItemsTheSame(oldItem: DevGroupChapter, newItem: DevGroupChapter): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DevGroupChapter, newItem: DevGroupChapter): Boolean {
            return oldItem == newItem
        }
    }

    class OverviewViewHolder(private var binding: OverviewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: ItemClickListener, chapter: DevGroupChapter) {
            binding.chapter = chapter
            binding.clickListener = listener
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): OverviewViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = OverviewItemBinding.inflate(layoutInflater, parent, false)
                return OverviewViewHolder(binding)
            }
        }
    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs a new [ViewHolder].
     *
     * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
     * to the RecyclerView such as where on the screen it was last drawn during scrolling.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder.from(parent)

    }

    /**
     * Part of the RecyclerView adapter, called when RecyclerView needs to show an item.
     *
     * The ViewHolder passed may be recycled, so make sure that this sets any properties that
     * may have been set previously.
     */
    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }
}

class ItemClickListener(val clickListener: (chapter: DevGroupChapter) -> Unit) {
    fun onClick(chapter: DevGroupChapter) = clickListener(chapter)
}
