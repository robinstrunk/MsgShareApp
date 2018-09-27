package com.greemand.msgshareapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.greemand.msgshareapp.Constants.USER_MESSAGE
import com.greemand.msgshareapp.R
import com.greemand.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            //Code
            Log.i(TAG, "Button Clicked!")
            showToast("Button Clicked!", Toast.LENGTH_LONG)
        }

        btnSendMessageToNextActivity.setOnClickListener {

            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(USER_MESSAGE, message)

            startActivity(intent)


        }

        btnShareToOtherApps.setOnClickListener {
            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/Plain"

            startActivity(Intent.createChooser(intent, "Share message to: "))
        }

        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
