
package com.delcastillo.alertguardappregister



import android.content.Intent


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.delcastillo.appregister.R

class ProfileFragment : Fragment(R.layout.activity_profile) {
//    private lateinit var profileImageView: ImageView
//    private lateinit var nameTextView: TextView
//    private lateinit var phoneTextView: TextView
//    private lateinit var genderTextView: TextView
//
//    private val firestore by lazy { FirebaseFirestore.getInstance() }
//    private val storage by lazy { FirebaseStorage.getInstance() }
//    private val auth by lazy { FirebaseAuth.getInstance() }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        profileImageView = findViewById(R.id.profile_image)
//        nameTextView = findViewById(R.id.textview_name)
//        phoneTextView = findViewById(R.id.textview_phone)
//        genderTextView = findViewById(R.id.textview_gender)
//
//        fetchUserProfile()
//
//        val profilesett: Button = findViewById(R.id.settingsprof)
//        profilesett.setOnClickListener {
//            val intent = Intent(this, Settings::class.java)
//            startActivity(intent)
//        }
//
//        val profilemerge: Button = findViewById(R.id.emergency_contacts)
//        profilemerge.setOnClickListener {
//            val intent = Intent(this, EmergencyContact::class.java)
//            startActivity(intent)
//        }
//
//
//        val logoutBtn = findViewById<Button>(R.id.logout)
//        logoutBtn.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//            finish()
//        }
//    }
//
//    private fun fetchUserProfile() {
//        val uid = auth.currentUser?.uid ?: return
//
//        firestore.collection("userprofile").document(uid).get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    val firstName = document.getString("firstName")
//                    val lastName = document.getString("lastName")
//                    val phone = document.getString("phone")
//                    val gender = document.getString("gender")
//                    val imageUrl = document.getString("imageUrl")
//
//                    nameTextView.text = "$firstName $lastName"
//                    phoneTextView.text = "Phone: $phone"
//                    genderTextView.text = "Gender: $gender"
//
//                    if (!imageUrl.isNullOrEmpty()) {
//                        loadProfileImage(imageUrl)
//                    } else {
//                        Log.e("Profile", "Image URL is null or empty")
//                    }
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.e("Profile", "Error fetching profile", exception)
//            }
//    }
//
//    private fun loadProfileImage(imageUrl: String) {
//        val storageRef = storage.reference.child(imageUrl)
//        storageRef.downloadUrl.addOnSuccessListener { uri ->
//            Glide.with(this).load(uri).into(profileImageView)
//        }.addOnFailureListener { exception ->
//            Log.e("Profile", "Error loading image", exception)
//        }
//    }
}