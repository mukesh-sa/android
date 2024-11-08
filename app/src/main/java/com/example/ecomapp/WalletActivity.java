package com.example.ecomapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;

public class WalletActivity extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);

        // Initialize Firebase
        db = FirebaseFirestore.getInstance();


        // Button to display wallet balance
        Button walletBalanceButton = findViewById(R.id.wallet_balance);
        walletBalanceButton.setOnClickListener(v -> showBalance());

        Button tenButton = findViewById(R.id.ten);
        tenButton.setOnClickListener(v -> addten());

        Button hundredButton = findViewById(R.id.hundred);
        hundredButton.setOnClickListener(v -> addhundred());

        Button fivehundredButton = findViewById(R.id.fivehundred);
        fivehundredButton.setOnClickListener(v -> addfivehundred());

        Button thousandButton = findViewById(R.id.thousand);
        thousandButton.setOnClickListener(v -> addthousand());
    }

    private void showBalance() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve the balance as an Object and cast it to a Number
                        Object balanceObj = documentSnapshot.get("balance");
                        if (balanceObj instanceof Number) {
                            Number balance = (Number) balanceObj;
                            // Show the balance in a dialog pop-up
                            new AlertDialog.Builder(WalletActivity.this)
                                    .setTitle("Balance")
                                    .setMessage("$" + balance)
//                                    .setMessage(String.valueOf(balance))
                                    .setPositiveButton("OK", null)
                                    .show();
                        } else {
                            Toast.makeText(WalletActivity.this, "Balance is not a number", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(WalletActivity.this, "No balance found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(WalletActivity.this, "Error retrieving balance", Toast.LENGTH_SHORT).show();
                });
    }

    private void addten() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve the balance as an Object and cast it to a Number
                        Object balanceObj = documentSnapshot.get("balance");
                        if (balanceObj instanceof Number) {
                            Number balance = (Number) balanceObj;
                            // Add 10 to the current balance
                            double newBalance = balance.doubleValue() + 10;

                            // Update the balance field in the database
                            db.collection("mikes").document("mikes")
                                    .update("balance", newBalance)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(WalletActivity.this, "Balance updated successfully!", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(WalletActivity.this, "Failed to update balance", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            Toast.makeText(WalletActivity.this, "Balance is not a number", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(WalletActivity.this, "No balance found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(WalletActivity.this, "Error retrieving balance", Toast.LENGTH_SHORT).show();
                });
    }

    private void addhundred() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve the balance as an Object and cast it to a Number
                        Object balanceObj = documentSnapshot.get("balance");
                        if (balanceObj instanceof Number) {
                            Number balance = (Number) balanceObj;
                            // Add 10 to the current balance
                            double newBalance = balance.doubleValue() + 100;

                            // Update the balance field in the database
                            db.collection("mikes").document("mikes")
                                    .update("balance", newBalance)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(WalletActivity.this, "Balance updated successfully!", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(WalletActivity.this, "Failed to update balance", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            Toast.makeText(WalletActivity.this, "Balance is not a number", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(WalletActivity.this, "No balance found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(WalletActivity.this, "Error retrieving balance", Toast.LENGTH_SHORT).show();
                });
    }

    private void addfivehundred() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve the balance as an Object and cast it to a Number
                        Object balanceObj = documentSnapshot.get("balance");
                        if (balanceObj instanceof Number) {
                            Number balance = (Number) balanceObj;
                            // Add 10 to the current balance
                            double newBalance = balance.doubleValue() + 500;

                            // Update the balance field in the database
                            db.collection("mikes").document("mikes")
                                    .update("balance", newBalance)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(WalletActivity.this, "Balance updated successfully!", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(WalletActivity.this, "Failed to update balance", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            Toast.makeText(WalletActivity.this, "Balance is not a number", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(WalletActivity.this, "No balance found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(WalletActivity.this, "Error retrieving balance", Toast.LENGTH_SHORT).show();
                });
    }

    private void addthousand() {
        // Access the document named "mikes" in the "mikes" collection
        db.collection("mikes").document("mikes").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve the balance as an Object and cast it to a Number
                        Object balanceObj = documentSnapshot.get("balance");
                        if (balanceObj instanceof Number) {
                            Number balance = (Number) balanceObj;
                            // Add 10 to the current balance
                            double newBalance = balance.doubleValue() + 1000;

                            // Update the balance field in the database
                            db.collection("mikes").document("mikes")
                                    .update("balance", newBalance)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(WalletActivity.this, "Balance updated successfully!", Toast.LENGTH_SHORT).show();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(WalletActivity.this, "Failed to update balance", Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            Toast.makeText(WalletActivity.this, "Balance is not a number", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(WalletActivity.this, "No balance found", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(WalletActivity.this, "Error retrieving balance", Toast.LENGTH_SHORT).show();
                });
    }
    public void onButton1Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(WalletActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onButton2Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(WalletActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onButton5Click(View view) {
        Log.d("MainActivity", "Button 4 clicked"); // Debug log
        Intent intent = new Intent(WalletActivity.this, CartActivity.class);
        startActivity(intent);
    }

}
