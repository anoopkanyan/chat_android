package com.recodecommerce.chatandbuy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.recodecommerce.chatandbuy.R;
import com.recodecommerce.chatandbuy.activities.MessagingActivity;
import com.recodecommerce.chatandbuy.app.AppController;
import com.recodecommerce.chatandbuy.app.Config;
import com.recodecommerce.chatandbuy.models.Product;

import java.util.List;

/**
 * Adapter class to bind data(product details) to the RecycleView
 */

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsViewHolders> {

    private List<Product> productList;
    private Context context;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public ProductsRecyclerViewAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        this.context = context;
    }

    @Override
    public ProductsViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list, null);
        ProductsViewHolders rcv = new ProductsViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ProductsViewHolders holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Config.USER_EMAIL.equals(productList.get(position).getSeller_token())) {
                    Intent intent = new Intent(view.getContext(), MessagingActivity.class);
                    intent.putExtra("RECIPIENT_ID", productList.get(position).getSeller_token());
                    view.getContext().startActivity(intent);
                } else {
                    Toast.makeText(context, "Own product", Toast.LENGTH_LONG).show();
                }
            }
        });


        holder.productName.setText(productList.get(position).getName());
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        holder.productPhoto.setImageUrl(productList.get(position).getPhoto(), imageLoader);
    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }
}