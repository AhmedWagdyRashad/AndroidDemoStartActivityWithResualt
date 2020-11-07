package com.ahmedwagdy.startactivitywithresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.Integer.parseInt

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        second_enter_btn.setOnClickListener {
            if(second_number_edit.text.toString().equals("")){
                Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show()
            }else{
                val number = parseInt(second_number_edit.text.toString())
                val secondNumberIntent = Intent().apply {
                    putExtra("number2",number)
                }
                setResult(RESULT_OK,secondNumberIntent)
                finish()
            }

        }
    }
}