package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
    }
    public void onButton2Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductActivity.this, ProductDetailsActivity.class);
        startActivity(intent);
    }
    public void onProfile(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
    public void onWallet(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductActivity.this, WalletActivity.class);
        startActivity(intent);
    }
    public void onCart(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductActivity.this, CartActivity.class);
        startActivity(intent);
    }
    public void onHome(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(ProductActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
