package com.comercio.retoandroid.ui.feature.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comercio.core.model.create_post.CreatePostResponse
import com.comercio.retoandroid.databinding.ItemPostBinding

class AdapterPost(
    private val itemList: List<CreatePostResponse>
) : RecyclerView.Adapter<AdapterPost.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(postItem: CreatePostResponse) {
            binding.tvTitle.text = postItem.title
            binding.tvDescription.text = postItem.body
            binding.tvDescription.setLineSpacing(2f, 1f)
            binding.tvDescription.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}