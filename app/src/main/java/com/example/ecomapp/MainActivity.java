package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import Log for debugging
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

//    private FirebaseAuth auth;
    private FirebaseFirestore db;// Declare FirebaseAuth instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize FirebaseAuth instance
//        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // Check if the user is already signed in
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if (currentUser == null) {
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent);
//            finish(); // Prevent user from returning to MainActivity without logging in
//            return;
//        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // If the user is authenticated, proceed with additional logic or UI setup
//        Log.d("MainActivity", "User ID: " + currentUser.getUid()); // Log user ID
        // You can also implement any other functionalities you need here.
    }

    // Launch the ProfileActivity when Button 1 is clicked
    public void onButton1Click(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    // Launch the ProductDetailsActivity when Button 2 is clicked
    public void onButton2Click(View view) {
        Log.d("MainActivity", "Button 2 clicked"); // Debug log
        Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
        startActivity(intent);
    }

    // Launch the CartActivity when Button 3 is clicked
    public void onButton3Click(View view) {
        Log.d("MainActivity", "Button 3 clicked"); // Debug log
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }

    public void onButton4Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(MainActivity.this, WalletActivity.class);
        startActivity(intent);
    }

    public void onButton35Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(MainActivity.this, ProductActivity.class);
        startActivity(intent);
    }
}
