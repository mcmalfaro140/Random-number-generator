package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.CheckBox
import java.util.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateNumberButton: Button = findViewById(R.id.button1)
        val result: TextView = findViewById(R.id.resultview)
        val from: EditText = findViewById(R.id.from)
        val to: EditText = findViewById(R.id.to)
        val wReplacement: CheckBox = findViewById(R.id.checkBox)
        val usedNumbers = mutableListOf<Int>()

        fun checkNumber( num: Int): Boolean{
            for (i in usedNumbers.indices) {
                if(usedNumbers[i] === num){
                    return true
                    break
                }
            }
            return false
        }

        fun getNewNumber() {
            val fromRange = from.text.toString();
            val toRange = to.text.toString();

            if(wReplacement.isChecked()){
                var  ran = Random().nextInt((toRange.toInt()+1) - fromRange.toInt() ) + fromRange.toInt()
                if(usedNumbers.size > 0 && usedNumbers.size < (toRange.toInt()+1) - fromRange.toInt()){
                    while (checkNumber(ran)){
                        ran = Random().nextInt((toRange.toInt()+1) - fromRange.toInt() ) + fromRange.toInt()
                    }
                    result.text = ran.toString()
                    usedNumbers.add(ran)
                }else if(usedNumbers.size === ((toRange.toInt()+1) - fromRange.toInt())){
                    result.text = "All numbers have been used."
                }else{
                    result.text = ran.toString()
                    usedNumbers.add(ran)
                }
            }else{
                val ran = Random().nextInt((toRange.toInt()+1) - fromRange.toInt() ) + fromRange.toInt()
                result.text = ran.toString()
            }

        }

        generateNumberButton.setOnClickListener{getNewNumber()}

    }


}


