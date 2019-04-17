package com.example.talli;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

/*
Firestore adapter retrieving data from the database and assigning them to class variables.
 */

public class PeopleAdapter extends FirestoreRecyclerAdapter <PeopleJavaListItem, PeopleAdapter.PeopleHolder> {

    PeopleAdapter(@NonNull FirestoreRecyclerOptions<PeopleJavaListItem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PeopleHolder holder, int position, @NonNull PeopleJavaListItem model) {

        holder.userName.setText(model.getUserName());
        holder.userImage.setText(model.getUserImage());

       // Glide.with(holder.userImage).load(model.getUserImage()).into(holder.userImage);
    }

    @NonNull
    @Override
    public PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.people_layout_list_item, viewGroup, false);

        return new PeopleHolder(v);
    }
/*
The holder class mapping instances of ProductJavaListItem Class and initiating them to the super().
 */
    class PeopleHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userImage;

        PeopleHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userImage = itemView.findViewById(R.id.user_image);

        }
    }
}
