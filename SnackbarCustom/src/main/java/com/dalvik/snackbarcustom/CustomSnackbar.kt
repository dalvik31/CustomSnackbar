package com.dalvik.customtoast

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.dalvik.snackbarcustom.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class CustomSnackbar(
    parent: ViewGroup,
    content: CustomSnackbarView
) : BaseTransientBottomBar<CustomSnackbar>(parent, content, content) {


    init {
        getView().setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                android.R.color.transparent
            )
        )
        getView().setPadding(0, 0, 0, 0)
    }

    companion object {

        fun make(
            view: View,
            message: String?, duretion: Int,
            listener: View.OnClickListener?, icon: Int, action_lable: String?, bg_color: Int
        ): CustomSnackbar? {

            // First we find a suitable parent for our custom view
           /* val parent = view.findSuitableParent() ?: throw IllegalArgumentException(
                "No suitable parent found from the given view. Please provide a valid view."
            )*/
            val parent = view.parent as ViewGroup
            // We inflate our custom view
            try {
                val customView = LayoutInflater.from(view.context).inflate(
                    R.layout.custom_view_inflation,
                    parent,
                    false
                ) as CustomSnackbarView
                // We create and return our Snackbar
                if (message == null || message.isEmpty()) {
                    customView.tvMsg.text = ""
                } else {
                    customView.tvMsg.text = message
                }
                action_lable?.let {
                    customView.tvAction.text = action_lable
                    customView.tvAction.setOnClickListener {
                        listener?.onClick(customView.tvAction)
                    }
                }
                customView.fabImage.setImageResource(icon)
                customView.layRoot.setBackgroundResource(bg_color)
                return CustomSnackbar(
                    parent,
                    customView
                ).setDuration(duretion)
            } catch (e: Exception) {
                e.message?.let { Log.v("exception ", it) }
            }

            return null
        }

        fun showErrorToast(view: View, message: String) {
            make(
                view, message, Snackbar.LENGTH_SHORT, null,
                R.drawable.ic_error_toast, null, R.drawable.toast_error_background
            )?.show()
        }

        fun showWarningToast(view: View, message: String) {
            make(
                view, message, Snackbar.LENGTH_SHORT, null,
                R.drawable.ic_warning_toast, null, R.drawable.toast_warning_background
            )?.show()
        }

        fun showSuccessToast(view: View, message: String) {
            make(
                view, message, Snackbar.LENGTH_SHORT, null,
                R.drawable.ic_success, null, R.drawable.toast_success_background
            )?.show()
        }
    }


}