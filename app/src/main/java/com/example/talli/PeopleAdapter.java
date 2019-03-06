package com.example.talli;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.List;

public class PeopleAdapter extends FirestoreRecyclerAdapter <PeopleJavaListitem, PeopleAdapter.PeopleHolder>{

    public PeopleAdapter(@NonNull FirestoreRecyclerOptions<PeopleJavaListitem> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull PeopleHolder holder, int position, @NonNull PeopleJavaListitem model) {

        holder.peopleName.setText(model.getPeopleName());
        Glide.with(holder.peopleImage)
                .load(model.getPeopleImageUrl())
                .into(holder.peopleImage);

    }

    @NonNull
    @Override
    public PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.people_layout_listitem, viewGroup, false);

        return new PeopleHolder(v);
    }

    class PeopleHolder extends RecyclerView.ViewHolder {
        TextView peopleName;
        ImageView peopleImage;

        PeopleHolder(@NonNull View itemView) {
            super(itemView);
            peopleName = itemView.findViewById(R.id.people_name);
            peopleImage = itemView.findViewById(R.id.people_image);

        }
    }
}
