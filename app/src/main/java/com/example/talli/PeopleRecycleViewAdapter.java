package com.example.talli;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.talli.R.id.parent;
import static com.example.talli.R.id.people_layout_listitem;
import static com.example.talli.R.layout.people_layout_listitem;

/*
ViewHolder adapter is constructed to govern the content of each layout in the RecyclerView.



 */
public class PeopleRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "PeopleRecycleViewAdapter";

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

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = View.inflate(R.layout.people_layout_listitem, viewGroup, false);
        ViewHolder peopleHolder = new ViewHolder(view);

        return peopleHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

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
