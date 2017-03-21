package com.mynewapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mynewapp.R;

/**
 * Created by Recrosoft on 19-Feb-17.
 */

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView mIvProductImage;
    private TextView mTvProductTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        mIvProductImage = (ImageView) findViewById(R.id.iv_product_image);
        mTvProductTitle = (TextView) findViewById(R.id.tv_product_title);

//        Glide.with(this).load(getIntent().getStringExtra("image")).into(mIvProductImage);
        mIvProductImage.setImageDrawable(getResources().getDrawable(getIntent().getIntExtra("image",0)));
        mTvProductTitle.setText(getIntent().getStringExtra("name"));

    }
}
