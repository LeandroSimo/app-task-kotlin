package com.leandro.taskapp.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.leandro.taskapp.R
import com.leandro.taskapp.databinding.BottomSheetBinding

fun Fragment.initToolBar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressed()
    }
}

fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    messageDialog: Int,
    titleButton: Int? = null,
    onClick: () -> Unit = {}
) {

    val bottomSheetDialog = BottomSheetDialog(
        requireContext(),
//        R.style.BottomSheetDialog
    )
    val bottomSheetBinding: BottomSheetBinding =
        BottomSheetBinding.inflate(layoutInflater, null, false)

    bottomSheetBinding.txtTitle.text = getText(titleDialog ?: R.string.text_title_warning)
    bottomSheetBinding.txtMessage.text = getText(messageDialog)
    bottomSheetBinding.btnOk.text = getText(titleButton ?: R.string.text_button_warning)
    bottomSheetBinding.btnOk.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }

    bottomSheetDialog.setContentView(bottomSheetBinding.root)
    bottomSheetDialog.show()

}