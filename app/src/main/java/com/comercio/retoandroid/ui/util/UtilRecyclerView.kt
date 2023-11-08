package com.comercio.retoandroid.ui.util

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object UtilRecyclerView {
    fun config(reciclerView: RecyclerView, isVertical: Boolean, context: Context) {
        reciclerView.setHasFixedSize(true)
        val layoutManager = if (isVertical) {
            LinearLayoutManager(context)
        } else {
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
        reciclerView.layoutManager = layoutManager
    }
}