package com.example.gadsproj.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import com.example.gadsproj.R

class SubmissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)

        val submitFormButton: Button = findViewById(R.id.goToQuestionPageButton)



        submitFormButton.setOnClickListener(
            showDialog()
        )
    }

    private fun showDialog() {
        val dialog = Dialog(baseContext)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pop_question)
        val yesBtn = dialog.findViewById(R.id.submit) as Button
        val noBtn = dialog.findViewById(R.id.cancel_image) as ImageView
        yesBtn.setOnClickListener {
            
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }
}