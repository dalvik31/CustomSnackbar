package com.dalvik.customtoast

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.dalvik.snackbarcustom.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.ContentViewCallback

class CustomSnackbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ContentViewCallback {
    lateinit var tvMsg: TextView
    lateinit var tvAction: TextView
    lateinit var imLeft: ImageView
    lateinit var fabImage: FloatingActionButton
    lateinit var layRoot: TextView

    init {
        View.inflate(context, R.layout.layout_toast, this)
        clipToPadding = false
        this.tvMsg = findViewById(R.id.tv_message)
        this.tvAction = findViewById(R.id.tv_action)
        this.imLeft = findViewById(R.id.im_action_left)
        this.fabImage = findViewById(R.id.fabImage)
        this.layRoot = findViewById(R.id.snack_constraint)
    }

    override fun animateContentIn(delay: Int, duration: Int) {
    //
    }

    override fun animateContentOut(delay: Int, duration: Int) {
      //
    }


}