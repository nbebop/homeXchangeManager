package com.example.homeXchangeManager;

import com.google.firebase.database.*;

public class FirebaseConnectionTest {
    public static void main(String[] args) {
        // Initialize Firebase Admin SDK
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        // Perform a simple read operation
        firebaseDatabase.child("test").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Connected to Firebase Realtime Database.");
                // Perform any additional testing or verification here
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Failed to connect to Firebase Realtime Database: " + databaseError.getMessage());
            }
        });

        // Perform a simple write operation
        firebaseDatabase.child("test").setValue("Hello, Firebase!", (error, ref) -> {
            if (error == null) {
                System.out.println("Data written to Firebase Realtime Database successfully.");
                // Perform any additional testing or verification here
            } else {
                System.out.println("Failed to write data to Firebase Realtime Database: " + error.getMessage());
            }
        });
    }
}
