package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class ProductDetailsActivity extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details); // Ensure this matches your layout file

        db = FirebaseFirestore.getInstance();

        Button specsButton = findViewById(R.id.specsButton);
        specsButton.setOnClickListener(v -> showSpecs());

        // Set up the back button
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            finish(); // Close the current activity and return to the previous one
        });

        // Set up the home button
        Button homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailsActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Optional: Call finish() to remove this activity from the back stack
        });

        // Set up the profile button
        Button profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailsActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish(); // Optional: Call finish() to remove this activity from the back stack
        });

        // Set up the cart button
        Button cartButton = findViewById(R.id.cart_button);
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailsActivity.this, CartActivity.class);
            startActivity(intent);
            finish(); // Optional: Call finish() to remove this activity from the back stack
        });
    }

    public void onWallet(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductDetailsActivity.this, WalletActivity.class);
        startActivity(intent);
    }

    public void onCart(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductDetailsActivity.this, CartActivity.class);
        startActivity(intent);
    }

    private void showSpecs() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        String address = documentSnapshot.getString("specs");
                        // Show the address in a dialog pop-up
                        new AlertDialog.Builder(ProductDetailsActivity.this)
                                .setTitle("Specifications")
                                .setMessage(address)
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        Toast.makeText(ProductDetailsActivity.this, "No specs found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(ProductDetailsActivity.this, "Error retrieving specs", Toast.LENGTH_SHORT).show();
                });
    }
}
