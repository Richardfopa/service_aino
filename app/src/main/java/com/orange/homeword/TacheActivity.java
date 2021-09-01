package com.orange.homeword;

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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class TacheActivity extends AppCompatActivity {
    private final LinkedList<Tache> tacheList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    LinearLayout lnly;
    CardView card;
//    private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tache);
        Tache t1 = new Tache(0,"Revoir les notions de la POO");
        Tache t2 = new Tache(1,"Revoir les notions de la POO");
        Tache t3 = new Tache(2,"Revoir les notions de la POO");
        Tache t4 = new Tache(3,"Revoir les notions de la POO");
        Tache t5 = new Tache(4,"Revoir les notions de la POO");
        Tache t6 = new Tache(5,"Revoir les notions de la POO");
        tacheList.addLast(t1);
        tacheList.addLast(t2);
        tacheList.addLast(t3);
        tacheList.addLast(t4);
        tacheList.addLast(t5);
        tacheList.addLast(t6);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerviewtache);
        card = findViewById(R.id.cardtaches);
        // Create an adapter and supply the data to be displayed.
        lnly = findViewById(R.id.linear_tache);
        TacheAdapter tacheAdapter = new TacheAdapter(this,tacheList,lnly,card);
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

                                //EditText objectif = findViewById(R.id.username);
                                String strob = username.getText().toString();
                                int idstr = tacheList.size() + 1;
                                tacheList.addLast(new Tache(idstr, strob));
                                mRecyclerView.getAdapter().notifyItemInserted(tacheList.size());
                                mRecyclerView.smoothScrollToPosition(tacheList.size());
//                                tacheAdapter.notifyItemInserted(idstr);
//                                tacheAdapter.notifyAll();
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