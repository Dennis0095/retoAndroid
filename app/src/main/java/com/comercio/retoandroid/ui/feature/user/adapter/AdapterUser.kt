package com.comercio.retoandroid.ui.feature.user.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.comercio.core.model.User
import com.comercio.retoandroid.databinding.ItemUserBinding

class AdapterUser(
    private val itemList: List<User>
) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.tvPhone.text = user.phone
            binding.tvEmail.text = user.email
            binding.tvName.text = user.name
            binding.tvUsername.text = user.username

            val address = user.address
            binding.tvAddress.text = listOf(address.street, address.suite, address.city).joinToString(", ")
            binding.tvWeb.text = user.website
            binding.tvCompany.text = user.company.name

            binding.ibToggle.setOnClickListener {
                toggleSectionText(binding.ibToggle, binding.llExpandText)
            }
        }
    }

    private fun toggleSectionText(view: View, llExpandText: LinearLayout) {
        val show: Boolean = toggleArrow(view)
        if (show) {
            llExpandText.visibility = View.VISIBLE
        } else {
            llExpandText.visibility = View.GONE
        }
    }

    fun toggleArrow(view: View): Boolean {
        return if (view.rotation == 0f) {
            view.animate().setDuration(200).rotation(180f)
            true
        } else {
            view.animate().setDuration(200).rotation(0f)
            false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(
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