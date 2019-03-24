package com.example.talli;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Layout searchPageLayout;

    Button returnButton;
    EditText search;
    Button shoppingCartButton;

    Button peopleButton;
    Button productsButton;
    Button barndsButton;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private CollectionReference user = db.collection("user");
    private CollectionReference products = db.collection("products");

    private PeopleAdapter peopleAdapter;
    private ProductAdapter productAdapter;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button peopleButton = findViewById(R.id.people_button);
        Button productButton = findViewById(R.id.products_button);
        Button brandButton = findViewById(R.id.brands_button);

        peopleButton.setOnClickListener(this);
        productButton.setOnClickListener(this);
        brandButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.people_button:
                lunchPeopleRecyclerView();
                break;
            case R.id.products_button:
                peopleButton.setVisibility(View.INVISIBLE);
                productsButton.setVisibility(View.VISIBLE);
                lunchProductRecyclerView();
                break;
            case R.id.brands_button:
                peopleButton.setVisibility(View.INVISIBLE);
                productsButton.setVisibility(View.INVISIBLE);
                break;

        }
    }

    void lunchPeopleRecyclerView(){
        Query query = user.orderBy("firstname", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<PeopleJavaListItem> options = new FirestoreRecyclerOptions.Builder<PeopleJavaListItem>()
                .setQuery(query, PeopleJavaListItem.class)
                .build();

        peopleAdapter = new PeopleAdapter(options);

        RecyclerView peopleRecyclerView = findViewById((R.id.people_recycleView));
        peopleRecyclerView.setHasFixedSize(true);
        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        peopleRecyclerView.setAdapter(peopleAdapter);
    }

    void lunchProductRecyclerView(){
        Query query = products.orderBy("id", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<ProductJavaListItem> options = new FirestoreRecyclerOptions.Builder<ProductJavaListItem>()
                .setQuery(query, ProductJavaListItem.class)
                .build();

        productAdapter = new ProductAdapter(options);

        RecyclerView productRecyclerView = findViewById((R.id.product_recycleView));
        productRecyclerView.setHasFixedSize(true);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(peopleAdapter);
    }

    protected void onStart (){
        super.onStart();
        peopleAdapter.startListening();
        productAdapter.startListening();
    }

    protected void onStop (){
        super.onStop();
        peopleAdapter.stopListening();
        productAdapter.startListening();
    }

}

