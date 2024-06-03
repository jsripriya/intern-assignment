package com.assignment.demo;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import java.util.concurrent.ExecutionException;

@Service
public class CRUDService {

    public String createCrud(CRUD crud) throws InterruptedException,ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collectionFuture(s:"crud_user").document(crud.getDocumentId().set(crud));
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public CRUD getCrud(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(s:"crud_user").document(documentId);
        ApiFuture<DocumentSnapshot> future =documentReference.get();
        DocumentSnapshot document = future.get();
        CRUD crud;
        if (document.exists()) {
            crud = document.toObject(CRUD.class);
            return crud;
        } else {
            crud = null;
        }
        return null;
    }

    public String updateeCrud(CRUD crud) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collectionFuture(s:"crud_user").document(crud.getName().set(crud));
        return collectionApiFuture.get().getUpdateTime().toString();

        return "";
    }

    public String createCrud(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(s:"crud_user").delete();

        return "Successfully deleted " + documentId;
    }

}
