package com.orange.homeword;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.Timestamp;

import java.util.Date;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<Recipes> recipesList = new LinkedList<>();

//    private static final Uri locationForPhotos = "/image";

    static final int REQUEST_SELECT_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //// Put initial data into the recipes list.
        recipesList.addLast(new Recipes("Kumbo Espresso ","Natural Coffee 100 % arabica Cameroonians La méthode AJAX a comme qualité de rester dans les standards HTTP, en plus d'être du côté client : c'est donc une méthode qui est totalement transparente dans les échanges standards entre un client et un serveur, donc avec tous les langages de programmes qui supportent une connexion socket classique. C'est important à garder à l'esprit dans des environnements mixtes : un serveur Apache / PHP pour la génération de pages maîtresses et un contenu déployé dans un autre langage.\n" + "Ne pas confondre possible et souhaitable :",R.drawable.image_100,"Nous sommes une équipe de passionnés dont l'objectif est d'améliorer la vie de chacun à l'aide de produits innovants."," Nous construisons des produits remarquables pour résoudre les problèmes de votre entreprise."));
        recipesList.addLast(new Recipes("Baham Espresso ","Natural Coffee 100 % arabica CamerooniansLa méthode AJAX a comme qualité de rester dans les standards HTTP, en plus d'être du côté client : c'est donc une méthode qui est totalement transparente dans les échanges standards entre un client et un serveur, donc avec tous les langages de programmes qui supportent une connexion socket classique. C'est important à garder à l'esprit dans des environnements mixtes : un serveur Apache / PHP pour la génération de pages maîtresses et un contenu déployé dans un autre langage.\n" +
                "Ne pas confondre possible et souhaitable :",R.drawable.image_101,"Nous sommes une équipe de passionnés dont l'objectif est d'améliorer la vie de chacun à l'aide de produits innovants."," Nous construisons des produits remarquables pour résoudre les problèmes de votre entreprise."));
        recipesList.addLast(new Recipes("Baham Espresso ","Natural Coffee 100 % arabica CamerooniansLa méthode AJAX a comme qualité de rester dans les standards HTTP, en plus d'être du côté client : c'est donc une méthode qui est totalement transparente dans les échanges standards entre un client et un serveur, donc avec tous les langages de programmes qui supportent une connexion socket classique. C'est important à garder à l'esprit dans des environnements mixtes : un serveur Apache / PHP pour la génération de pages maîtresses et un contenu déployé dans un autre langage.\n" +
                "Ne pas confondre possible et souhaitable :",R.drawable.image_101,"Nous sommes une équipe de passionnés dont l'objectif est d'améliorer la vie de chacun à l'aide de produits innovants."," Nous construisons des produits remarquables pour résoudre les problèmes de votre entreprise."));
        recipesList.addLast(new Recipes("Baham Espresso ","Natural Coffee 100 % arabica CamerooniansLa méthode AJAX a comme qualité de rester dans les standards HTTP, en plus d'être du côté client : c'est donc une méthode qui est totalement transparente dans les échanges standards entre un client et un serveur, donc avec tous les langages de programmes qui supportent une connexion socket classique. C'est important à garder à l'esprit dans des environnements mixtes : un serveur Apache / PHP pour la génération de pages maîtresses et un contenu déployé dans un autre langage.\n" +
                "Ne pas confondre possible et souhaitable :",R.drawable.image_101,"Nous sommes une équipe de passionnés dont l'objectif est d'améliorer la vie de chacun à l'aide de produits innovants."," Nous construisons des produits remarquables pour résoudre les problèmes de votre entreprise."));
        recipesList.addLast(new Recipes("Baham Lungo ","Natural Coffee 100 % arabica CamerooniansLa méthode AJAX a comme qualité de rester dans les standards HTTP, en plus d'être du côté client : c'est donc une méthode qui est totalement transparente dans les échanges standards entre un client et un serveur, donc avec tous les langages de programmes qui supportent une connexion socket classique. C'est important à garder à l'esprit dans des environnements mixtes : un serveur Apache / PHP pour la génération de pages maîtresses et un contenu déployé dans un autre langage.\n" +
                "Ne pas confondre possible et souhaitable :",R.drawable.image_102,"Nous sommes une équipe de passionnés dont l'objectif est d'améliorer la vie de chacun à l'aide de produits innovants."," Nous construisons des produits remarquables pour résoudre les problèmes de votre entreprise."));
        recipesList.addLast(new Recipes("Kumbo Espresso ","When the REST API was merged into WordPress core the ?filtWhen the REST API was merged into WordPress core the ?filtWhen the REST API was merged into WordPress core the ?filter query parameter was removed to prevent future compatibility and maintenance issues. The ability to pass arbitrary WP_Query arguments to the API using a ?filter query parameter was necessary at the genesis of the REST API project, but most API response filtering functionality has been superseded by more robust query parameters like ?categories=, ?slug= and ?per_page= ",R.drawable.image_105,"Double-click on a resource to have the Resource Manager display more detailed information. If you have multiple versions of a resource, this detailed view displays each version along with any associated qualifiers, as shown in figure 2. From here, you can also double-click on a specific version to open it in an editor window","Double-click on a resource to have the Resource Manager display more detailed information. If you have multiple versions of a resource, this detailed view displays each version along with any associated qualifiers, as shown in figure 2. From here, you can also double-click on a specific version to open it in an editor window"));
        // Get a handle to the RecyclerView.
        RecyclerView mRecyclerView = findViewById(R.id.recylcerview);
        CardView card = findViewById(R.id.card);
        LinearLayout lnly = findViewById(R.id.linear_layout);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                Log.d("Click","click sur le btn floatant");

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                View formView = inflater.inflate(R.layout.add_services_item, null);
                EditText addtitle  = formView.findViewById(R.id.add_title);
                EditText adddescription = formView.findViewById(R.id.add_description);
                Button add_button = formView.findViewById(R.id.add_photo);
//                add_button.setOnClickListener(onClickListener);
                ImageView addimageview = formView.findViewById(R.id.add_imageView);
                builder.setView(formView)
                        //
                        .setTitle("Ajouter un nouveau service !")
                        // Add action buttons
                        .setPositiveButton("Enregistrer ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(view.getContext(),"Click sur cancel button ", Toast.LENGTH_LONG);

                            }
                        }).show();
                    }
                });


        // Create an adapter and supply the data to be displayed.
        RecipesAdapter mRadapter = new RecipesAdapter(this, recipesList, card, lnly);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mRadapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void add_photo(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        String[] type = {"image/png","image/jpg","image/jpeg"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,type);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_SELECT_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            Log.d("URIDETAILS:",contactUri.toString());
            // Do something with the selected contact at contactUri
        }
    }
}