package com.ahmedwagdy.startactivitywithresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val firstRequestCode = 1
    private val secondRequestCode = 2
    private var firstNumber:Int? = null
    private var secondNumber:Int? = null
    var checkNumber = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first_text.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent,firstRequestCode)
        }
        second_text.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, secondRequestCode)
        }
        calculate_btn.setOnClickListener{
            if (firstNumber!=null && secondNumber!=null){
                result_txt.text = "${firstNumber!!+secondNumber!!}"
            }
            if(!checkNumber || firstNumber==null || secondNumber==null){
                Toast.makeText(this, "can't calculate the result",
                    Toast.LENGTH_SHORT).show()
                result_txt.text = "NO RESULT"
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == firstRequestCode){
            if(resultCode == RESULT_OK){
                firstNumber = data?.getIntExtra("number1",0)
                first_text.text = "$firstNumber"
                checkNumber = true
            }
            if (resultCode == RESULT_CANCELED){
                first_text.text ="Nothing Selected"
                checkNumber = false
            }
        }

        if (requestCode == secondRequestCode){
            if(resultCode == RESULT_OK){
                secondNumber = data?.getIntExtra("number2",0)
                second_text.text = "$secondNumber"
                checkNumber = true
            }
            if (resultCode == RESULT_CANCELED){
                second_text.text ="Nothing Selected"
                checkNumber = false
            }
        }
    }
}