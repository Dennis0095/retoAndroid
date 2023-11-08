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
) : RecyclerView.Adapter<AdapterUser.ViewHolder>(){


    inner class ViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(questionItem: User) {
            /*val objQuestion: Question = questionItem.getFrequentQuestions()
            binding.tvQuestion.text = objQuestion.question

            if (questionItem.tag.compareTo("SI") == 0) {
                // Lógica para cuando el tag es "SI"
            } else {
                // Lógica para otros casos
            }*/

            // Configura eventos de clic u otras lógicas según sea necesario
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
            //ViewAnimation.collapse(lyt_expand_text)
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


    interface OnClickEvent {
        fun onClick(position: Int, tag: String)
    }
}