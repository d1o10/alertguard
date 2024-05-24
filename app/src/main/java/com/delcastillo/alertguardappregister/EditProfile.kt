package com.delcastillo.alertguardappregister

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R

class EditProfile : AppCompatActivity() {
    private lateinit var profileImageView: ImageView
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var maleRadioButton: RadioButton
    private lateinit var femaleRadioButton: RadioButton
    private lateinit var saveButton: Button

    private var imageUri: Uri? = null

    private val pickImageResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            imageUri = result.data?.data
            profileImageView.setImageURI(imageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        profileImageView = findViewById(R.id.profile_image)
        val editImageIcon: ImageView = findViewById(R.id.edit_image_icon)
        firstNameEditText = findViewById(R.id.first_name)
        lastNameEditText = findViewById(R.id.last_name)
        phoneEditText = findViewById(R.id.phone)
        genderRadioGroup = findViewById(R.id.gender_radio_group)
        maleRadioButton = findViewById(R.id.male_radio_button)
        femaleRadioButton = findViewById(R.id.female_radio_button)
        saveButton = findViewById(R.id.save_profile)

        val currentFirstName = intent.getStringExtra("CURRENT_FIRST_NAME")
        val currentLastName = intent.getStringExtra("CURRENT_LAST_NAME")
        val currentPhone = intent.getStringExtra("CURRENT_PHONE")
        val currentGender = intent.getStringExtra("CURRENT_GENDER")

        firstNameEditText.setText(currentFirstName)
        lastNameEditText.setText(currentLastName)
        phoneEditText.setText(currentPhone)
        when (currentGender) {
            "Male" -> maleRadioButton.isChecked = true
            "Female" -> femaleRadioButton.isChecked = true
        }

        editImageIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImageResultLauncher.launch(intent)
        }

        saveButton.setOnClickListener {
            val newFirstName = firstNameEditText.text.toString()
            val newLastName = lastNameEditText.text.toString()
            val newPhone = phoneEditText.text.toString()
            val newGender = if (maleRadioButton.isChecked) "Male" else "Female"

            val resultIntent = Intent().apply {
                putExtra("NEW_FIRST_NAME", newFirstName)
                putExtra("NEW_LAST_NAME", newLastName)
                putExtra("NEW_PHONE", newPhone)
                putExtra("NEW_GENDER", newGender)
                imageUri?.let { putExtra("NEW_IMAGE_URI", it.toString()) }
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
