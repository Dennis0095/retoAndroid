package com.comercio.retoandroid.ui.feature.user.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.comercio.retoandroid.R
import com.comercio.retoandroid.databinding.DialogCreatePostBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DialogCreatePost(
    val listener: ActionDialogCreatePost,
) : BottomSheetDialogFragment() {

    lateinit var binding: DialogCreatePostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogCreatePostBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        initOnClick()
        return binding.root
    }

    private fun initOnClick() {
        binding.btnCreatePost.setOnClickListener {
            if(binding.tieTitle.text.toString().trim().isNotBlank() && binding.tieDescription.text.toString().trim().isNotBlank()){
                dismiss()
                listener.clickCreatepost(binding.tieTitle.text.toString(), binding.tieDescription.text.toString())
            }
        }
        binding.ibClose.setOnClickListener { dismiss() }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    interface ActionDialogCreatePost {
        fun clickCreatepost(title: String, description: String)
    }
}