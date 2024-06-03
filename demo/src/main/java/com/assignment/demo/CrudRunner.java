package com.assignment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class CRUDRunner {
    public static void main(String[] args) throws IOException {
        ClassLoader cl = CRUDRunner.class.getClassLoader();

        // Load the serviceAccountKey.json from the resources folder
        File file = new File(Objects.requireNonNull(cl.getResource("serviceAccountKey.json")).getFile());
        FileInputStream serviceAccount = new FileInputStream(file);

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://assignment-intern.firebaseio.com/")
            .build();

        FirebaseApp.initializeApp(options);

        SpringApplication.run(CRUDRunner.class, args);
    }
}
