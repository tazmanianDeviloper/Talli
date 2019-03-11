package com.example.talli;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    Layout searchPageLayout;

    Button returnButton;
    EditText search;
    Button shoppingCartButton;

    Button peopleButton;
    Button productsButton;
    Button barndsButton;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference taymaz = db.collection("taymaz");

    private PeopleAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lunchPeopleRecyclerView();
    }

    void lunchPeopleRecyclerView(){
        Query query = taymaz.orderBy("firstname", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<PeopleJavaListitem> options = new FirestoreRecyclerOptions.Builder<PeopleJavaListitem>()
                .setQuery(query, PeopleJavaListitem.class)
                .build();

        pAdapter = new PeopleAdapter(options);

        RecyclerView peopleRecyclerView = findViewById((R.id.people_recycleView));
        peopleRecyclerView.setHasFixedSize(true);
        peopleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        peopleRecyclerView.setAdapter(pAdapter);
    }

    protected void onStart (){
        super.onStart();
        pAdapter.startListening();
    }

    protected void onStop (){
        super.onStop();
        pAdapter.stopListening();
    }
}

