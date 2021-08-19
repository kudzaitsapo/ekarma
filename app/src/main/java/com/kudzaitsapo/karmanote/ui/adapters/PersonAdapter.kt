package com.kudzaitsapo.karmanote.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kudzaitsapo.karmanote.models.PeopleEntity
import karmanote.databinding.PersonItemBinding


class PersonDiffUtil: DiffUtil.ItemCallback<PeopleEntity>() {
    override fun areItemsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity): Boolean {
        return  oldItem.personId == newItem.personId
    }

    override fun areContentsTheSame(oldItem: PeopleEntity, newItem: PeopleEntity): Boolean {
        return oldItem == newItem
    }

}

class PersonAdapter(val clickListener: ItemClickListener) : ListAdapter<PeopleEntity, PersonAdapter.PersonViewHolder>(PersonDiffUtil()) {

    class PersonViewHolder(val binding: PersonItemBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup) : PersonViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = PersonItemBinding.inflate(inflater, parent, false)
                return  PersonViewHolder(binding)
            }
        }

        fun bind(
            item: PeopleEntity,
            clickListener: ItemClickListener
        ) {
            binding.data = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }


}

class ItemClickListener(val clickListener: (PeopleEntity) -> Unit) {
    fun onclick(item: PeopleEntity) = clickListener(item)
}
