package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log; // Import Log for debugging

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        Button homeButton = findViewById(R.id.homeButton); // Update this if the ID changes
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button profileButton = findViewById(R.id.profileButton); // Update this if the ID changes
        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        Button checkoutButton = findViewById(R.id.checkoutButton); // Update this if the ID changes
        checkoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, OrderSummaryActivity.class);
            startActivity(intent);
        });

    }
}
