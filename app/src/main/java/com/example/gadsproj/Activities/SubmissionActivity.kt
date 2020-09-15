package com.example.gadsproj.Activities

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.gadsproj.Api.ApiPostClient
import com.example.gadsproj.Api.ApiPostInterface
import com.example.gadsproj.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)

        val submitFormButton: Button = findViewById(R.id.goToQuestionPageButton)

        val emailInput: EditText = findViewById(R.id.email_input)
        val firstNameInput: EditText = findViewById(R.id.first_name_input)
        val lastNameInput: EditText = findViewById(R.id.last_name_input)
        val githubLinkInput: EditText = findViewById(R.id.github_link_input)

        val emailParsed = emailInput.text.toString()
        val firstNameParsed = firstNameInput.text.toString()
        val lastNameParsed = lastNameInput.text.toString()
        val githubLinkParsed = githubLinkInput.text.toString()

        val clickListener = View.OnClickListener { view ->

            when (view.id) {
                R.id.goToQuestionPageButton -> checkEmptyFields(
                    emailParsed,
                    firstNameParsed,
                    lastNameParsed,
                    githubLinkParsed
                )
            }
        }
        submitFormButton.setOnClickListener(clickListener)


    }

    private fun checkEmptyFields(
        email: String,
        name: String,
        lastName: String,
        github: String
    ) {

        if (email.trim().isEmpty() or name.trim()
                .isEmpty() or lastName.trim().isEmpty() or github.trim().isEmpty()
        ) {
            showEmptyDialog()
        } else {
            showDialog(email, name, lastName, github)
        }


    }

    private fun showDialog(email: String?, name: String?, lastName: String?, github: String?) {
        val dialog = Dialog(baseContext)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.pop_question)
        val yesBtn = dialog.findViewById(R.id.submit) as Button
        val noBtn = dialog.findViewById(R.id.cancel_image) as ImageView
        yesBtn.setOnClickListener {

            val postDataUrl = ApiPostClient.buildService(ApiPostInterface::class.java)
            val submissionOfData = postDataUrl.submitProject(email, name, lastName, github)

            submissionOfData!!.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    val statusCode = response.code()
                    if (statusCode == 200) {
                        if (response.isSuccessful) {
                            val successDialog = Dialog(applicationContext)
                            successDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                            successDialog.setCancelable(true)
                            successDialog.setContentView(R.layout.pop_successful)
                            successDialog.show()
                        }
                    }
                    val failureDialog = Dialog(applicationContext)
                    failureDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    failureDialog.setCancelable(true)
                    failureDialog.setContentView(R.layout.pop_not_successful)
                    failureDialog.show()
                    TODO("Not yet implemented")
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    val failureDialog = Dialog(applicationContext)
                    failureDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    failureDialog.setCancelable(true)
                    failureDialog.setContentView(R.layout.pop_not_successful)
                    failureDialog.show()
                    TODO("Not yet implemented")
                }

            })

        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }

    private fun showEmptyDialog() {
        val dialog = Dialog(applicationContext)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.empty_field_dialog)
        val backBtn = dialog.findViewById(R.id.goBackToSubmissionPage) as Button

        backBtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }
}