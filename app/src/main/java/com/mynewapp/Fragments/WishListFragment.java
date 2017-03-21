package com.mynewapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mynewapp.Adapters.ProductsAdapter;
import com.mynewapp.Models.Student;
import com.mynewapp.R;
import com.mynewapp.Utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

public class WishListFragment extends Fragment implements ProductsAdapter.OnItemClickListener{

    private Context mContext;
    private RecyclerView mRVWishList;
    private ProductsAdapter mProductsAdapter;
    private List<Student> mWishList;
    private LinearLayoutManager mLayoutManager;
    // on scroll

    private static int current_page = 1;

    private int ival = 1;
    private int loadLimit = 10;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frag_wishlist,container,false);

        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mRVWishList = (RecyclerView) view.findViewById(R.id.rv_products);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRVWishList.setLayoutManager(mLayoutManager);
        mWishList = new ArrayList<>();

        loadData(current_page);

        mRVWishList.setHasFixedSize(true);

        // create an Object for Adapter
        mProductsAdapter = new ProductsAdapter(mContext,mWishList,this);

        // set the adapter object to the Recyclerview
        mRVWishList.setAdapter(mProductsAdapter);

        mRVWishList.setOnScrollListener(new EndlessRecyclerOnScrollListener(
                mLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                // do somthing...

                loadMoreData(current_page);

            }

        });

    }

    private void loadData(int current_page) {

        // I have not used current page for showing demo, if u use a webservice
        // then it is useful for every call request

        for (int i = ival; i <= loadLimit; i++) {
            Student st = new Student("Student " + i, "androidstudent" + i
                    + "@gmail.com", false);

            mWishList.add(st);
            ival++;

        }

    }

    private void loadMoreData(int current_page) {

        // I have not used current page for showing demo, if u use a webservice
        // then it is useful for every call request

        loadLimit = ival + 10;

        for (int i = ival; i <= loadLimit; i++) {
            Student st = new Student("Product " + i, "androidstudent" + i
                    + "@gmail.com", false);

            mWishList.add(st);
            ival++;
        }

        mProductsAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCardItemClicked(Student singlestudent) {
        Toast.makeText(
                mContext,
                "Data : \n" + singlestudent.getName() + " \n"
                        + singlestudent.getEmailId(),
                Toast.LENGTH_SHORT).show();
    }
}
