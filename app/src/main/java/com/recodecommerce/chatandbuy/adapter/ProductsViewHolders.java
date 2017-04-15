package com.recodecommerce.chatandbuy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.recodecommerce.chatandbuy.R;
import com.recodecommerce.chatandbuy.models.Product;

import java.util.List;

/**
 * holds references to View components of each item i.e our products
 */
public class ProductsViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView productName;
    public NetworkImageView productPhoto;
    private List<Product> productList;


    public ProductsViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        productPhoto = (NetworkImageView) itemView
                .findViewById(R.id.product_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();

    }
}