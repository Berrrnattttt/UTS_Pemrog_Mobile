package com.example.bioskopproject.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bioskopproject.Domain.FilmItem;
import com.example.bioskopproject.R;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterNewMovies,adapterUpComming;
private RecyclerView recyclerViewNewMovies, recyclerViewUpcomming;
private RequestQueue mRequestQueue;
private StringRequest mStringRequest, mStringRequest2;
private ProgressBar loading1, loading2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
        sendRequest1();
    }

    private void sendRequest1() {
        mRequestQueue = Volley.newRequestQueue(this);
        loading1.setVisibility(View.VISIBLE);
        mStringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=1", response -> {
        Gson gson = new Gson();
        loading1.setVisibility(View.GONE);

        FilmItem items=gson.fromJson(response, FilmItem.class);
        adapterNewMovies=
        }, error -> {

        });
    }
    private void initView() {
        recyclerViewNewMovies=findViewById(R.id.view1);
        recyclerViewNewMovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewUpcomming=findViewById(R.id.view2);
        recyclerViewUpcomming.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        loading1=findViewById(R.id.loading1);
        loading2=findViewById(R.id.loading2);
        mRequestQueue= Volley.newRequestQueue(this);
    }
}