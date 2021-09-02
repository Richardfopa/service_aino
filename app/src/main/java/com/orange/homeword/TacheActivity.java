package com.orange.homeword;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.type.DateTime;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TacheActivity extends AppCompatActivity {
    private final LinkedList<Tache> tacheList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    LinearLayout lnly;
    CardView card;
    FirebaseFirestore db
            = FirebaseFirestore.getInstance();
//    private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache);

        Task<QuerySnapshot> users = db.collection("users").get();
        Log.d("USERS:",users.toString());

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerviewtache);
        card = findViewById(R.id.cardtaches);
        // Create an adapter and supply the data to be displayed.
        lnly = findViewById(R.id.linear_tache);
        TacheAdapter tacheAdapter = new TacheAdapter(this);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(tacheAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Gestion du clic sur le bouton flottant

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TacheActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = TacheActivity.this.getLayoutInflater();
                Log.d("Click","click sur le btn floatant");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                View formView = inflater.inflate(R.layout.dialog_tache, null);
                EditText username  = formView.findViewById(R.id.username);
                builder.setView(formView)
                        //
                        .setTitle("Fixez vous un nouvel objectifs")
                        // Add action buttons
                        .setPositiveButton("Enregistrer ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                String strob = username.getText().toString();
                                int idstr = tacheList.size() + 1;
//                                tacheList.addLast(new Tache(idstr, strob, new Timestamp(new Date())));

                                FirebaseUtil.addTask(new Tache(idstr, strob,new Timestamp(new Date())));
                                mRecyclerView.getAdapter().notifyItemInserted(tacheList.size());
                                mRecyclerView.smoothScrollToPosition(tacheList.size());

                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dismissDialog(id);
                            }
                        }).show();
                }
        });
    }

}