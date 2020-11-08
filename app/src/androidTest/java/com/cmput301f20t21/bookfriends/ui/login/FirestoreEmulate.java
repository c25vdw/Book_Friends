package com.cmput301f20t21.bookfriends.ui.login;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;


public class FirestoreEmulate {
    protected static int waitTime = 3000;
    private static boolean emulated = false;

    private static FirestoreEmulate instance;
    static {
        FirestoreEmulate.init();
    }
    private FirestoreEmulate() {

    }

    public static FirestoreEmulate getInstance() {
        if (instance == null) {
            instance = new FirestoreEmulate();
        }
        return instance;
    }

    public void setup() {
        init();
    }

    private static void init() {
        if (!emulated) {
            FirebaseFirestore firestore = FirebaseFirestore.getInstance();
            firestore.useEmulator("10.0.2.2", 8080);
            FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                    .setPersistenceEnabled(false)
                    .build();
            System.out.println("initialized emulator");
            firestore.setFirestoreSettings(settings);
            emulated = true;
        }
    }
}
