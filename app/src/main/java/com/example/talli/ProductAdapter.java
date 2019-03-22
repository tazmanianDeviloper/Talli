package com.example.talli;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.bumptech.glide.Glide;


public class ProductAdapter extends FirestoreRecyclerAdapter <ProductJavaListItem, ProductAdapter.ProductHolder>{

ProductAdapter(@NonNull FirestoreRecyclerOptions<ProductJavaListItem> options) {
        super(options);
        }


@Override
protected void onBindViewHolder(@NonNull ProductHolder holder, int position, @NonNull ProductJavaListItem model) {

        holder.productName.setText(model.getProductBrandName());
        Glide.with(holder.productImage)
        .load(model.getProductBrandImage())
        .into(holder.productImage);

        }

@NonNull
@Override
public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_layout_list_item, viewGroup, false);

        return new ProductHolder(v);
        }

class ProductHolder extends RecyclerView.ViewHolder {
    TextView productName;
    ImageView productImage;

    ProductHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.product_name);
        productImage = itemView.findViewById(R.id.product_image);

    }
}
}
