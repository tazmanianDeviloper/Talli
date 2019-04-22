package com.example.talli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* we are using firebase firestore, not firebase database.
 * For firestore see:
 *  0. https://firebase.google.com/docs/android/setup
 *  1. https://firebase.google.com/docs/firestore/quickstart
 *  2. https://github.com/firebase/snippets-android/blob/7d03e65500cd63a26e5bf9b8b6e4d3ab9479806a/firestore/app/src/main/java/com/google/example/firestore/DocSnippets.java#L132-L132
 */
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

/*
ViewHolder adapter is constructed to govern the content of each layout in the RecyclerView.



 */
public class PeopleRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PeopleRecycleViewAdapter";

    /*
    * adding firestore object
    * */
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();
    /*
     * I will let you follow the example for java android in
     * https://firebase.google.com/docs/firestore/quickstart
     * to continue.
     *
     * keep in mind that your your settings in firestore are:
     * Project: talli-development
     * For references: see https://firebase.google.com/docs/firestore/?authuser=0
     * */


    private ArrayList <View> pPeopleImage = new ArrayList<>();
    private ArrayList <String> pPeopleName = new ArrayList<>();
    private ArrayList <View>  fFriendOrNot = new ArrayList<>();
    private Context context;

    public PeopleRecycleViewAdapter(Context context, ArrayList<View> pPeopleImage, ArrayList<String> pPeopleName, ArrayList<View> fFriendOrNot) {
        this.pPeopleImage = pPeopleImage;
        this.pPeopleName = pPeopleName;
        this.fFriendOrNot = fFriendOrNot;
        this.context = context;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_layout_listitem, parent, false);
        ViewHolder peopleViewHolder = new ViewHolder(view);

        return peopleViewHolder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Log.d(TAG , "onBindViewHolder: called.");




    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout peopleLayout;
// ToDo add boolean() for Image or not, and conditions accordingly
        CardView peopleImageHolder;
        ImageView peopleImage;
        ImageView peopleNoImage;

        TextView peopleName;
// ToDo add boolean () for friend or not and the corresponding Image.
        CardView freindStatusHolder;
        ImageView alreadyFriendImage;
        ImageView addFriendImage;

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            peopleLayout = itemView.findViewById(R.id.people_layout_list_item);

            peopleImageHolder = itemView.findViewById(R.id.people_circle_card_view);
            peopleImage = itemView.findViewById(R.id.people_image);
            peopleNoImage = itemView.findViewById(R.id.no_people_image);

            peopleName = itemView.findViewById(R.id.people_name);

            freindStatusHolder = itemView.findViewById(R.id.friend_status_card_view);
            alreadyFriendImage = itemView.findViewById(R.id.already_friend_image);
            addFriendImage = itemView.findViewById(R.id.add_friend_image);

        }

    }
}
