package com.example.gamehigherorlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var btnGuess: Button
    private lateinit var layout: ConstraintLayout
    private var secretNumber: Int = 0

    fun randomNumber(): Int = (1..20).random()


    fun init(){
        editText = findViewById(R.id.etNumber)
        btnGuess = findViewById(R.id.btnGuess)
        layout = findViewById(R.id.layout)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        secretNumber = randomNumber()

        btnGuess.setOnClickListener {
            var num: Int? = Integer.parseInt(editText.text.toString())

            if(num!=null){
                if(num<secretNumber){
                    layout.setBackgroundColor(resources.getColor(R.color.red))
                    Toast.makeText(this, "HIGHER!!!",Toast.LENGTH_SHORT).show()
                }else if(num>secretNumber){
                    layout.setBackgroundColor(resources.getColor(R.color.green))
                    Toast.makeText(this, "LOWER!!!",Toast.LENGTH_SHORT).show()
                }else{
                    layout.setBackgroundColor(resources.getColor(R.color.blue))
                    Toast.makeText(this, "YOU GOT IT!!! Try again!",Toast.LENGTH_SHORT).show()
                    secretNumber = randomNumber()
                }
            }else{
                Toast.makeText(this, "Enter number!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}