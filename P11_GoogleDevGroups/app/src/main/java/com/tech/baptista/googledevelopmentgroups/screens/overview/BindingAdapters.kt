package com.tech.baptista.googledevelopmentgroups.screens.overview

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tech.baptista.googledevelopmentgroups.repository.network.DevGroupChapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DevGroupChapter>?) {
    val adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(data) {
        // scroll the list to the top after the diffs are calculated and posted
        recyclerView.scrollToPosition(0)
    }
}

@BindingAdapter("showOnlyWhenEmpty")
fun View.showOnlyWhenEmpty(data: List<DevGroupChapter>?) {
    visibility = when {
        data == null || data.isEmpty() -> View.VISIBLE
        else -> View.GONE
    }
}