package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Link the XML layout to this activity
        setContentView(R.layout.order_summary);
    }

    public void onHome(View view) {
        Log.d("MainActivity", "Button 3 clicked"); // Debug log
        Intent intent = new Intent(OrderSummaryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onProfile(View view) {
        Log.d("MainActivity", "Button 3 clicked"); // Debug log
        Intent intent = new Intent(OrderSummaryActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onWallet(View view) {
        Log.d("MainActivity", "Button 3 clicked"); // Debug log
        Intent intent = new Intent(OrderSummaryActivity.this, WalletActivity.class);
        startActivity(intent);
    }

    public void onCart(View view) {
        Log.d("MainActivity", "Button 3 clicked"); // Debug log
        Intent intent = new Intent(OrderSummaryActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
