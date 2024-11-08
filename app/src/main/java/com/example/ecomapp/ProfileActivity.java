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

public class ProfileActivity extends AppCompatActivity {

    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Profile page layout

        // Initialize Firebase Firestore
        db = FirebaseFirestore.getInstance();

        // Button to handle showing the shipping address
        Button shippingAddressButton = findViewById(R.id.shopping_address_button);
        shippingAddressButton.setOnClickListener(v -> showAddress());

        // Set listener for home button to navigate to MainActivity
        Button homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Set listener for cart button to navigate to CartActivity
        Button cartButton = findViewById(R.id.cart_button); // Update this if the ID changes
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, CartActivity.class);
            startActivity(intent);
        });

        Button carttButton = findViewById(R.id.cartt_button); // Update this if the ID changes
        carttButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, CartActivity.class);
            startActivity(intent);
        });

        // Set listener for search bar
        EditText searchInput = findViewById(R.id.search_input);
        searchInput.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, searchActivity.class);
            startActivity(intent);
        });
    }

    // Method to retrieve and display address
    private void showAddress() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String address = documentSnapshot.getString("address");
                        // Show the address in a dialog pop-up
                        new AlertDialog.Builder(ProfileActivity.this)
                                .setTitle("Shipping Address")
                                .setMessage(address)
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        Toast.makeText(ProfileActivity.this, "No address found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ProfileActivity.this, "Error retrieving address", Toast.LENGTH_SHORT).show();
                });
    }

    public void onButton2Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProfileActivity.this, WalletActivity.class);
        startActivity(intent);
    }

    public void onButton5Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProfileActivity.this, CartActivity.class);
        startActivity(intent);
    }

    public void onLogout(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void onForgot(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProfileActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}
