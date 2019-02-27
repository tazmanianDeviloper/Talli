package com.example.talli;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PeopleAdapter extends FirestoreRecyclerAdapter <PeopleJavaListitem, PeopleAdapter.PeopleHolder>{

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PeopleAdapter(@NonNull FirestoreRecyclerOptions<PeopleJavaListitem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PeopleHolder holder, int position, @NonNull PeopleJavaListitem model) {
        PeopleHolder.peopleName.setText(model.getpPeopleName());

    }

    @NonNull
    @Override
    public PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    static class PeopleHolder extends RecyclerView.ViewHolder {
        static TextView peopleName;
        static ImageView peopleImage;
        static ImageView friendorNot;

        public PeopleHolder(@NonNull View itemView) {
            super(itemView);
            peopleName = itemView.findViewById(R.id.people_name);
            peopleImage = itemView.findViewById(R.id.people_image);
            friendorNot = itemView.findViewById(R.id.already_friend_image);
        }
    }
}
