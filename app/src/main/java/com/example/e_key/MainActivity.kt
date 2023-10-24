package com.example.e_key

import android.R
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.e_key.R.layout.activity_main)
        val inputText = findViewById<EditText>(com.example.e_key.R.id.inputText)
        val transformButton = findViewById<Button>(com.example.e_key.R.id.transformButton)
        val outputText = findViewById<TextView>(com.example.e_key.R.id.outputText)
        transformButton.setOnClickListener {
            val inputSentence = inputText.text.toString()
            val transformedSentence = transformSentence(inputSentence)
            outputText.text = "Your Decoded message:\n $transformedSentence"
        }
    }

    private fun transformSentence(inputSentence: String): String {
        // Implement your Python code logic here
        // For simplicity, you can use the same Python code logic
        val result = StringBuilder()
        for (c in inputSentence.toCharArray()) {
            if (Character.isLetter(c)) {
                var prevChar: Char
                prevChar = if (Character.isLowerCase(c)) {
                    if (c != 'a') (c.code - 1).toChar() else 'z'
                } else {
                    if (c != 'A') (c.code - 1).toChar() else 'Z'
                }
                result.append(prevChar)
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }
}