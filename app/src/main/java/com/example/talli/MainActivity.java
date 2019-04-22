package com.example.talli;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Layout searchPageLayout;

    FontAwesomeTextView returnButton;
    EditText searchMagnifyingGlass;
    FontAwesomeTextView shoppingCartButton;

    Button peopleButton;
    Button productsButton;
    Button brandButton;

    RecyclerView peopleRecyclerView;
    RecyclerView productsRecycleView;
    RecyclerView brandsRecyclerView;

    InputMethodManager imm;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private CollectionReference user = db.collection("user");
    private CollectionReference products = db.collection("products");
    private CollectionReference brands = db.collection("brands");

    private PeopleAdapter peopleAdapter;
    private ProductAdapter productAdapter;
    private BrandAdapter brandAdapter;
    // not sure if I need this method. Will delete it later to see if it was needed.
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peopleButton = findViewById(R.id.people_button);
        productsButton = findViewById(R.id.products_button);
        brandButton = findViewById(R.id.brands_button);

        peopleButton.setOnClickListener(this);
        productsButton.setOnClickListener(this);
        brandButton.setOnClickListener(this);

        peopleRecyclerView = findViewById(R.id.people_recycleView);
        productsRecycleView = findViewById(R.id.product_recycleView);
        brandsRecyclerView = findViewById(R.id.brands_recycleView);

        returnButton = (FontAwesomeTextView) findViewById(R.id.return_button);

        shoppingCartButton = (FontAwesomeTextView) findViewById(R.id.shopping_cart_button);
        // Typeface cartPlusIcon = Typeface.createFromAsset(getAssets(),"fonts/Pro-Light-300.otf");
        // shoppingCartButton.setTypeface(cartPlusIcon);
        // shoppingCartButton.setText("\uf217");

        //I am not sure if I can set the magnifying glass icon at the beginning of the search bar using a fontawsome icon.
        // Superman: My suggestion is to look at daniel's fragment_camera.xml to see how he overlays com.Talli.Alpha.Development.IconTextView in the TalliAppAndroid Project
        searchMagnifyingGlass = (EditText) findViewById(R.id.search_magnifying_glass);

//the default view before user's input.
        lunchPeopleRecyclerView();
//listener checking for items that are searched.
        searchBar();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.people_button:
                brandsRecyclerView.setVisibility(View.INVISIBLE);
                productsRecycleView.setVisibility(View.INVISIBLE);
                peopleRecyclerView.setVisibility(View.VISIBLE);
                lunchPeopleRecyclerView();
                break;
            case R.id.products_button:
                brandsRecyclerView.setVisibility(View.INVISIBLE);
                peopleRecyclerView.setVisibility(View.INVISIBLE);
                productsRecycleView.setVisibility(View.VISIBLE);
                lunchProductRecyclerView();
                break;
            case R.id.brands_button:
                peopleRecyclerView.setVisibility(View.INVISIBLE);
                productsRecycleView.setVisibility(View.INVISIBLE);
                brandsRecyclerView.setVisibility(View.VISIBLE);
                lunchBrandRecyclerView();
                break;
            default:
                brandsRecyclerView.setVisibility(View.INVISIBLE);
                productsRecycleView.setVisibility(View.INVISIBLE);
                peopleRecyclerView.setVisibility(View.VISIBLE);
                lunchPeopleRecyclerView();
        }
    }

    void lunchPeopleRecyclerView(){
        Query query = user.orderBy("first name", Query.Direction.ASCENDING);

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

    void lunchBrandRecyclerView(){
        Query query = brands.orderBy("id", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<BrandJavaListItem> options = new FirestoreRecyclerOptions.Builder<BrandJavaListItem>()
                .setQuery(query, BrandJavaListItem.class)
                .build();

        brandAdapter = new BrandAdapter(options);

        RecyclerView brandRecyclerView = findViewById((R.id.brands_recycleView));
        brandRecyclerView.setHasFixedSize(true);
        brandRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        brandRecyclerView.setAdapter(brandAdapter);
    }
// For action results conditions must be set. these conditions will check the users' input against Firestore data and
// if they reflect the content of either RecyclerView the View or an item of the view will appear.
    void searchBar(){

        searchMagnifyingGlass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //textView1.setText(searchMagnifyingGlass.getText());
                    //mPlayerEditNameCardView.setVisibility(View.INVISIBLE);
                    imm.hideSoftInputFromWindow(searchMagnifyingGlass.getWindowToken(), 0);
                    //Temporary Toast until Firestore integration.
                    Context context = MainActivity.this.getApplicationContext();
                    CharSequence tempTextForSearch = "I'm AWESOME!";
                    int duration = Toast.LENGTH_LONG;

                    Toast.makeText(context, tempTextForSearch, duration).show();

                    return true;
                }
                return false;
            }
        });
    }


    protected void onStart (){
        super.onStart();
        peopleAdapter.startListening();
//        productAdapter.startListening();
//        brandAdapter.startListening();
    }

    protected void onStop (){
        super.onStop();
        peopleAdapter.stopListening();
//        productAdapter.startListening();
//        brandAdapter.stopListening();
    }

}