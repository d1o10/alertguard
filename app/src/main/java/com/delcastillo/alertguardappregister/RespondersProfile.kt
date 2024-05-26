package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.delcastillo.appregister.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.bumptech.glide.Glide

class RespondersProfile : Fragment() {
    private lateinit var profileImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var genderTextView: TextView

    private val firestore by lazy { FirebaseFirestore.getInstance() }
    private val storage by lazy { FirebaseStorage.getInstance() }
    private val auth by lazy { FirebaseAuth.getInstance() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profileImageView = view.findViewById(R.id.profile_image)
        nameTextView = view.findViewById(R.id.textview_name)
        phoneTextView = view.findViewById(R.id.textview_phone)
        genderTextView = view.findViewById(R.id.textview_gender)

        fetchUserProfile()

        val helpsup: Button = view.findViewById(R.id.helpSupport)
        helpsup.setOnClickListener {
            val intent = Intent(requireContext(), HelpandSupport::class.java)
            startActivity(intent)
        }

        val aboutbt: Button = view.findViewById(R.id.About)
        aboutbt.setOnClickListener {
            val intent = Intent(requireContext(), About::class.java)
            startActivity(intent)
        }

        val profilesett: Button = view.findViewById(R.id.settingsprof)
        profilesett.setOnClickListener {
            // Handle click event for settings button
            // Example: Navigate to Settings activity
            val intent = Intent(requireContext(), Settings::class.java)
            startActivity(intent)
        }

        val profilemerge: Button = view.findViewById(R.id.emergency_contacts)
        profilemerge.setOnClickListener {
            // Handle click event for emergency contacts button
            // Example: Navigate to EmergencyContact activity
            val intent = Intent(requireContext(), EmergencyContact::class.java)
            startActivity(intent)
        }

        val logoutBtn = view.findViewById<Button>(R.id.logout)
        logoutBtn.setOnClickListener {
            // Handle click event for logout button
            // Example: Logout user and navigate to LoginActivity
            auth.signOut()
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }

    private fun fetchUserProfile() {
        val uid = auth.currentUser?.uid ?: return

        firestore.collection("userprofile").document(uid).get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val firstName = document.getString("firstName")
                    val lastName = document.getString("lastName")
                    val phone = document.getString("phone")
                    val gender = document.getString("gender")
                    val imageUrl = document.getString("imageUrl")

                    nameTextView.text = "$firstName $lastName"
                    phoneTextView.text = "Phone: $phone"
                    genderTextView.text = "Gender: $gender"

                    if (!imageUrl.isNullOrEmpty()) {
                        loadProfileImage(imageUrl)
                    } else {
                        Log.e("Profile", "Image URL is null or empty")
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.e("Profile", "Error fetching profile", exception)
            }
    }

    private fun loadProfileImage(imageUrl: String) {
        val storageRef = storage.reference.child(imageUrl)
        storageRef.downloadUrl.addOnSuccessListener { uri ->
            Glide.with(this).load(uri).into(profileImageView)
        }.addOnFailureListener { exception ->
            Log.e("Profile", "Error loading image", exception)
        }
    }
}
