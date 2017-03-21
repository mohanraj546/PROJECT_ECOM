package com.mynewapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mynewapp.Activities.ProductDetailActivity;
import com.mynewapp.Models.Student;
import com.mynewapp.R;

import java.util.List;

/**
 * Created by Recrosoft on 24-Feb-17.
 */

public class ProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public final int TYPE_MOVIE = 0;
    public final int TYPE_LOAD = 1;
    private List<Student> mProducts;
    private Context context;
    private OnItemClickListener mListener;


    public ProductsAdapter(Context context,List<Student> products,OnItemClickListener listener){
        this.context = context;
        this.mProducts = products;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType==TYPE_MOVIE){
            return new MyViewHolder(inflater.inflate(R.layout.product_item,parent,false));
        }else{
            return new LoadHolder(inflater.inflate(R.layout.footer,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;

        viewHolder.tvName.setText(mProducts.get(position).getName());

        viewHolder.singlestudent=mProducts.get(position);
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public interface OnItemClickListener {
        void onCardItemClicked(Student student);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tvName;
        Student singlestudent;
        LinearLayout llItem;

        public MyViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_product_name);
            llItem = (LinearLayout) view.findViewById(R.id.ll_item);
            llItem.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Log.e("Adapter","onclick"+view.getId());
            switch (view.getId())
            {
                case R.id.ll_item:
                    mListener.onCardItemClicked(singlestudent);

                    break;
            }
        }
    }

    static class LoadHolder extends RecyclerView.ViewHolder{
        public LoadHolder(View itemView) {
            super(itemView);
        }
    }

    // Now define getItemViewType of your own.

    @Override
    public int getItemViewType(int position) {
        if (position == mProducts.size()) {
            // This is where we'll add footer.
            return TYPE_LOAD;
        }
        return super.getItemViewType(position);
    }


}


