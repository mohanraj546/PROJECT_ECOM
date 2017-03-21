package com.mynewapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mynewapp.Adapters.ProductsAdapter;
import com.mynewapp.Models.Student;
import com.mynewapp.R;
import com.mynewapp.Utils.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Recrosoft on 24-Feb-17.
 */

public class ProductsActivity extends AppCompatActivity implements ProductsAdapter.OnItemClickListener{

    private RecyclerView mRVProducts;
    private ProductsAdapter mProductsAdapter;
    private List<Student> mProducts;
    private LinearLayoutManager mLayoutManager;
    // on scroll

    private static int current_page = 1;

    private int ival = 1;
    private int loadLimit = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        initViews();
    }

    private void initViews() {
        mRVProducts = (RecyclerView) findViewById(R.id.rv_products);

        mLayoutManager = new LinearLayoutManager(this);
        mRVProducts.setLayoutManager(mLayoutManager);
        mProducts = new ArrayList<>();

        loadData(current_page);

        mRVProducts.setHasFixedSize(true);

        // create an Object for Adapter
        mProductsAdapter = new ProductsAdapter(this,mProducts,this);

        // set the adapter object to the Recyclerview
        mRVProducts.setAdapter(mProductsAdapter);

        mRVProducts.setOnScrollListener(new EndlessRecyclerOnScrollListener(
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

            mProducts.add(st);
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

            mProducts.add(st);
            ival++;
        }

        mProductsAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCardItemClicked(Student singlestudent) {
        Toast.makeText(
                this,
                "Data : \n" + singlestudent.getName() + " \n"
                        + singlestudent.getEmailId(),
                Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this,ProductDetailActivity.class);
        in.putExtra("image",getIntent().getIntExtra("image",0));
        startActivity(in);
    }
/*        Call<List<String>> call = api.getMovies(index);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(response.isSuccessful()){

                    //remove loading view
                    mProducts.remove(mProducts.size()-1);

                    List<String> result = response.body();
                    if(result.size()>0){
                        //add loaded data
                        mProducts.addAll(result);
                    }else{//result size 0 means there is no more data available at server
                        mProductsAdapter.setMoreDataAvailable(false);
                        //telling adapter to stop calling load more as no more server data available
                        Toast.makeText(ProductsActivity.this,"No More Data Available", Toast.LENGTH_LONG).show();
                    }
                    mProductsAdapter.notifyDataChanged();
                    //should call the custom method adapter.notifyDataChanged here to get the correct loading status
                }else{
                    Log.e("ProductsActivity"," Load More Response Error "+String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e("ProductsActivity"," Load More Response Error "+t.getMessage());
            }
        });*/

}
