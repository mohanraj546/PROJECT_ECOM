package com.mynewapp.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mynewapp.Models.Album;
import com.mynewapp.R;

import java.util.List;

/**
 * Created by Arun1234 on 2/18/2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder>
{
    private Context mContext;
    private List<Album> albumList;
    private OnItemClickListener mListener;


    public AlbumsAdapter(Context mContext, List<Album> albumList,OnItemClickListener listener) {
        this.mContext = mContext;
        this.albumList = albumList;
        mListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        Album album = albumList.get(position);
        holder.title.setText(album.getCategoryName());
//        holder.count.setText(album.getNumOfSongs() + " songs");

        Glide.with(mContext).load(album.getCategoryThumb()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public interface OnItemClickListener {
        void onCardItemClicked(int pos);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView title, count;
        ImageView thumbnail,overflow;
        CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            cardView = (CardView) view.findViewById(R.id.card_view);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Log.e("Adapter","onclick"+view.getId());
            switch (view.getId())
            {
                case R.id.card_view:
                    mListener.onCardItemClicked(getAdapterPosition());
                    break;
            }
        }
    }
}
