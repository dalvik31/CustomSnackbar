package com.dalvik.customsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dalvik.customtoast.CustomSnackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CustomSnackbar.showSuccessToast(findViewById(R.id.container),"message")
    }
}