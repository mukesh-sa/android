package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private EditText editTextName, editTextPassword;
    private Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();

        Button shippingAddressButton = findViewById(R.id.buttonLogin);
        shippingAddressButton.setOnClickListener(v -> checkcredentials());
    }

    private void checkcredentials() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        String username = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String dusername = documentSnapshot.getString("username");
                        String dpassword = documentSnapshot.getString("password");


                        if (username.equals(dusername) && password.equals(dpassword)) {
                            // Credentials match, redirect to MainActivity
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();  // Optionally finish LoginActivity so that user cannot go back to it
                        } else {
                            // Incorrect credentials, show popup
                            Toast.makeText(LoginActivity.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // No document found
                        Toast.makeText(LoginActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(LoginActivity.this, "Error retrieving", Toast.LENGTH_SHORT).show();
                });
    }

}
