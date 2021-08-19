package com.kudzaitsapo.karmanote.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.kudzaitsapo.karmanote.models.PeopleEntity


@BindingAdapter("format_initials")
fun TextView.format_initials(item: PeopleEntity) {
    val initials = item.fullName.split(' ')
        .mapNotNull { it.firstOrNull()?.toString() }
        .reduce { acc, s -> acc + s }

    text = initials
}