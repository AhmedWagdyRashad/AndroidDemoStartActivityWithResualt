package com.ahmedwagdy.startactivitywithresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.second_enter_btn

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        first_enter_btn.setOnClickListener {
            if(first_number_edit.text.toString().equals("")){
                Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show()
            }else{
                val number = Integer.parseInt(first_number_edit.text.toString())
                val firstNumberIntent = Intent().apply {
                    putExtra("number1",number)
                }
                setResult(RESULT_OK,firstNumberIntent)
                finish()
            }

        }
    }
}