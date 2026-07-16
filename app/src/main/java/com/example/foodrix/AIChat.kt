package com.example.foodrix

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class AIChat : AppCompatActivity() {

    private val conversationHistory = StringBuilder() // Stores the history of conversation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aichat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


                val eTPrompt = findViewById<EditText>(R.id.eTPrompt)
                val btnSubmit = findViewById<Button>(R.id.btnSubmit)
                val tVResult = findViewById<TextView>(R.id.tVResult)

                btnSubmit.setOnClickListener {
                    val prompt = eTPrompt.text.toString()

                    // Add the current user input to the history
                    conversationHistory.append("User: $prompt\n")

                    val generativeModel = GenerativeModel(
                        modelName = "gemini-1.5-flash",
                        apiKey = "AIzaSyCcGDLLah6CLLVIRt-eVXd5BeibF8CLqDk " // ENTER YOUR KEY
                    )

                    runBlocking {
                        // Send the conversation history as context to Gemini
                        val response = generativeModel.generateContent(conversationHistory.toString())
                        conversationHistory.append("AI: ${response.text}\n") // Add AI response to history

                        // Update the UI with the AI's response
                        tVResult.text = response.text
                    }

                    // Clear the EditText after processing
                    eTPrompt.setText("")
                }
            }
        }
