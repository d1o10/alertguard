package com.delcastillo.alertguardappregister

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

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
        val editImageIcon: ImageButton = findViewById(R.id.edit_image_icon)
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

            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser != null) {
                val uid = currentUser.uid
                if (imageUri != null) {
                    uploadImageAndSaveProfile(uid, newFirstName, newLastName, newPhone, newGender)
                } else {
                    saveProfile(uid, newFirstName, newLastName, newPhone, newGender, null)
                }
            } else {
                Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun uploadImageAndSaveProfile(uid: String, firstName: String, lastName: String, phone: String, gender: String) {
        val storageReference = FirebaseStorage.getInstance().reference.child("profile_images/$uid.jpg")
        imageUri?.let {
            storageReference.putFile(it)
                .addOnSuccessListener { taskSnapshot ->
                    taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                        saveProfile(uid, firstName, lastName, phone, gender, uri.toString())
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed to upload image: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }



    private fun saveProfile(uid: String, firstName: String, lastName: String, phone: String, gender: String, imageUrl: String?) {
        val userProfile = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName,
            "phone" to phone,
            "gender" to gender,
            "imageUrl" to imageUrl
        )

        val db = FirebaseFirestore.getInstance()

        db.collection("userprofile").document(uid).set(userProfile)
            .addOnSuccessListener {
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                val resultIntent = Intent().apply {
                    putExtra("NEW_FIRST_NAME", firstName)
                    putExtra("NEW_LAST_NAME", lastName)
                    putExtra("NEW_PHONE", phone)
                    putExtra("NEW_GENDER", gender)
                    imageUrl?.let { putExtra("NEW_IMAGE_URL", it) }
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to update profile: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
