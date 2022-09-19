package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.wordle.FourLetterWordList.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wordToGuess = getRandomFourLetterWord()

        val editText = findViewById<EditText>(R.id.editText)
        val guessButton = findViewById<Button>(R.id.button)
        var userInput = ""
        var generatedOutput = ""

        var counter = 0

        val firstGuess = findViewById<TextView>(R.id.textView7)
        val checkFirst = findViewById<TextView>(R.id.textView8)

        val secondGuess = findViewById<TextView>(R.id.textView9)
        val checkSecond = findViewById<TextView>(R.id.textView13)

        val thirdGuess = findViewById<TextView>(R.id.textView14)
        val checkThird = findViewById<TextView>(R.id.textView15)

        val reveal = findViewById<TextView>(R.id.textView18)



        fun checkGuess(guess: String): String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                } else if (guess[i] in wordToGuess) {
                    result += "+"
                } else {
                    result += "X"
                }
            }
            return result
        }

        guessButton.setOnClickListener{
            if (counter == 0){
                userInput = editText.text.toString().uppercase()
                generatedOutput = checkGuess(userInput)

                if (userInput == wordToGuess.uppercase()) {
                    counter = 3


                }

                firstGuess.text = userInput
                checkFirst.text = generatedOutput
                editText.text.clear()
                counter++


            }

            else if (counter == 1){
                userInput = editText.text.toString().uppercase()
                generatedOutput = checkGuess(userInput)

                if (userInput == wordToGuess.uppercase()){
                    counter = 3


                }
                secondGuess.text = userInput
                checkSecond.text = generatedOutput
                editText.text.clear()
                counter++
        }
            else if (counter == 2){
                userInput = editText.text.toString().uppercase()
                generatedOutput = checkGuess(userInput)

                if (userInput == wordToGuess.uppercase()){
                    counter = 3
                }
                thirdGuess.text = userInput
                checkThird.text = generatedOutput
                editText.text.clear()
                counter++
            }

            else if (counter >= 3){
                Toast.makeText(it.context, "Done Guessing!", Toast.LENGTH_LONG).show()
                editText.visibility = View.INVISIBLE
                reveal.text = wordToGuess
            }

    }
}}