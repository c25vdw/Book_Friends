package com.cmput301f20t21.bookfriends.ui.login;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import org.junit.BeforeClass;

public class FirestoreEmulatedTest {
    protected static boolean emulated = false;
    protected static int waitTime = 30000;

    @BeforeClass
    public static void setUpFirestoreEmulator() {
        if (!emulated) {
            FirebaseFirestore firestore = FirebaseFirestore.getInstance();
            firestore.useEmulator("10.0.2.2", 8080);
            FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                    .setPersistenceEnabled(false)
                    .build();
            firestore.setFirestoreSettings(settings);
            emulated = true;
        }
    }
}
