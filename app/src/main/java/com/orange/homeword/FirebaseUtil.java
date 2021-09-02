package com.orange.homeword;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {
    static CollectionReference mRefCollection;
    static final String TASK_COLLECTION = "TASCHES";
    public static CollectionReference getReferenceFirestore(String CollectionName){
        if(mRefCollection == null){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            mRefCollection = db.collection(CollectionName);
            return mRefCollection;
        }
        return mRefCollection;
    }

    public static void addTask(Tache tache){
        getReferenceFirestore(TASK_COLLECTION)
                .add(tache)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("SUCCES","Insertion reussi !");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ECHECS","Insertion echouer ");
                    }
                });
    }

    public static CollectionReference getCollection(String CollectionName){

        CollectionReference cr = getReferenceFirestore(TASK_COLLECTION)
                .getFirestore().collection(CollectionName);

        Log.d("STRUCT:",cr.toString());

        return cr;
    }
}
