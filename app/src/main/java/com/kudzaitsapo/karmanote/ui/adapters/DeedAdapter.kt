package com.kudzaitsapo.karmanote.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kudzaitsapo.karmanote.models.DeedEntity
import com.kudzaitsapo.karmanote.models.PeopleEntity
import karmanote.databinding.DeedItemBinding
import karmanote.databinding.PersonItemBinding

class DeedDiffUtil: DiffUtil.ItemCallback<DeedEntity>() {
    override fun areItemsTheSame(oldItem: DeedEntity, newItem: DeedEntity): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DeedEntity, newItem: DeedEntity): Boolean {
        return oldItem == newItem
    }

}

class DeedAdapter (val clickListener: DeedClickListener) : ListAdapter<DeedEntity, DeedAdapter.DeedViewHolder>(DeedDiffUtil()) {

    class DeedViewHolder(val binding: DeedItemBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup) : DeedViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DeedItemBinding.inflate(inflater, parent, false)
                return  DeedViewHolder(binding)
            }
        }

        fun bind(
            item: DeedEntity,
            clickListener: DeedClickListener
        ) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeedViewHolder {
        return DeedViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DeedViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}

class DeedClickListener(val clickListener: (DeedEntity) -> Unit) {
    fun onclick(item: DeedEntity) = clickListener(item)
}
