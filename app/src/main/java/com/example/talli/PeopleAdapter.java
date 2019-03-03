package com.example.talli;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class PeopleAdapter extends FirestoreRecyclerAdapter <PeopleJavaListitem, PeopleAdapter.PeopleHolder>{

    public PeopleAdapter(@NonNull FirestoreRecyclerOptions<PeopleJavaListitem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PeopleHolder holder, int position, @NonNull PeopleJavaListitem model) {
        holder.peopleName.setText(model.getPeopleName());
        /*I am having difficulties with calling my CardViews or ImagesViews when I try to get them
        from my Java class and set them to my Adapter.
         */

       // holder.peopleCircleCardView.setActivated(model.getPeopleCircleCardView());
       // holder.friendStatusCardView.setActivated(model.getFriendStatusCardView());

    }

    @NonNull
    @Override
    public PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.people_layout_listitem, viewGroup, false);

        return new PeopleHolder(v);
    }

    class PeopleHolder extends RecyclerView.ViewHolder {
        private TextView peopleName;
        private CardView peopleCircleCardView;
        private CardView friendStatusCardView;

        public PeopleHolder(@NonNull View itemView, TextView peopleName, CardView peopleCircleCardView, CardView friendStatusCardView) {
            super(itemView);
            this.peopleName = peopleName;
            this.peopleCircleCardView = peopleCircleCardView;
            this.friendStatusCardView = friendStatusCardView;
        }
    }
}
