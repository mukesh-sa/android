package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class ForgotPasswordActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private EditText enteredName, enteredMail, newpassword, newpassword2;
    private Button buttonchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);  // Ensure the XML layout file name is correct

        try {
            // Initialize Firestore instance
            db = FirebaseFirestore.getInstance();

            // Initialize the views
            enteredName = findViewById(R.id.editTextRegisterName);  // Make sure this ID exists in XML
            enteredMail = findViewById(R.id.editTextPhone);  // Make sure this ID exists in XML
            newpassword = findViewById(R.id.editTextEmail);  // Make sure this ID exists in XML
            newpassword2 = findViewById(R.id.editTextAddress);  // Make sure this ID exists in XML
            buttonchange = findViewById(R.id.newButtonBelowConfirmPassword);  // Make sure this ID exists in XML

            // Ensure all views were successfully found
            if (enteredName == null || enteredMail == null || newpassword == null || newpassword2 == null || buttonchange == null) {
//                Log.e("ForgotPasswordActivity", "One or more views are not properly initialized.");
                Toast.makeText(this, "Error loading the page", Toast.LENGTH_SHORT).show();
                return;  // Exit early if views are not found
            }

            // Set up the button click listener
            buttonchange.setOnClickListener(v -> change());

        } catch (Exception e) {
//            Log.e("ForgotPasswordActivity", "Error in onCreate: " + e.getMessage());
            Toast.makeText(this, "Initialization failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void change() {
        String username = enteredName.getText().toString().trim();
        String mail = enteredMail.getText().toString().trim();
        String password1 = newpassword.getText().toString().trim();
        String password2 = newpassword2.getText().toString().trim();

        if (password1.isEmpty() || password2.isEmpty()) {
            Toast.makeText(this, "Passwords cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password1.equals(password2)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Access the document from Firestore
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String dusername = documentSnapshot.getString("username");
                        String dmail = documentSnapshot.getString("mail");

                        if (username.equals(dusername) && mail.equals(dmail)) {
                            db.collection("mikes").document("mikes")
                                    .update("password", password1)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(ForgotPasswordActivity.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();  // Optionally finish activity so the user can't go back
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(ForgotPasswordActivity.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            Toast.makeText(ForgotPasswordActivity.this, "Username or email is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ForgotPasswordActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                });
    }
}
