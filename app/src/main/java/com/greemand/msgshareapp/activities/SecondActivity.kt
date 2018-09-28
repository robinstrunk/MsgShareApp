package com.greemand.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.greemand.msgshareapp.Constants.USER_MESSAGE
import com.greemand.msgshareapp.R
import com.greemand.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        //Safe Call ?.
        //Safe Call with let ?.let { }

        bundle?.let{
            val msg = bundle.getString(USER_MESSAGE)
            showToast(msg)
            txvUserMessage.text = msg
        }



    }
}