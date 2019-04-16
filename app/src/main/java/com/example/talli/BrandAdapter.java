package com.example.talli;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

/*
Firestore adapter retrieving data from the database and assigning them to class variables.
 */

public class BrandAdapter extends FirestoreRecyclerAdapter<BrandJavaListItem, BrandAdapter.BrandHolder> {

    BrandAdapter(@NonNull FirestoreRecyclerOptions<BrandJavaListItem> options) {
    super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BrandHolder holder, int position, @NonNull BrandJavaListItem model) {

    holder.brandName.setText(model.getBrandName());
    holder.brandImage.setText(model.getBrandImage());
    //Glide.with(holder.brandImage).load(model.getBrandImage()).into(holder.brandImage);

}

    @NonNull
    @Override
    public BrandAdapter.BrandHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.brands_layout_list_item, viewGroup, false);

    return new BrandAdapter.BrandHolder(v);
}
/*
The holder class mapping instances of BrandJavaListItem Class and initiating them to the super().
*/
    class BrandHolder extends RecyclerView.ViewHolder {
        TextView brandName;
        TextView brandImage;

        BrandHolder(@NonNull View itemView) {
            super(itemView);
            brandName = itemView.findViewById(R.id.brand_name);
            brandImage = itemView.findViewById(R.id.brand_image);

        }
    }
}
