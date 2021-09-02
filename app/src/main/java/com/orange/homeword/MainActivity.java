package com.orange.homeword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<Recipes> recipesList = new LinkedList<>();
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
                Intent intent = new Intent(view.getContext(),TacheActivity.class);
                startActivity(intent);
            }
        });

        // Create an adapter and supply the data to be displayed.
        RecipesAdapter mRadapter = new RecipesAdapter(this, recipesList, card, lnly);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mRadapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}