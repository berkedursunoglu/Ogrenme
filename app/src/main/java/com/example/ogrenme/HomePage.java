package com.example.ogrenme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class HomePage extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;
    private RecyclerView recyclerView ;
    private RvAdapter adapter;
    private ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
    private Veritabani vt;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        vt = new Veritabani(HomePage.this);
        FloatingActionButton fb = findViewById(R.id.fb);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Öğrenme");
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewOgrenme);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        kelimelerArrayList = KelimelerDao.kelimeler(vt);
        adapter = new RvAdapter(HomePage.this,kelimelerArrayList);
        recyclerView.setAdapter(adapter);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ApplyActivty.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        kelimeAraIng(query);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        kelimeAraIng(newText);
        return false;
    }

    public void kelimeAraIng(String kelime){
        kelimelerArrayList = new KelimelerDao().kelimeAra(vt,kelime);
        adapter = new RvAdapter(getApplicationContext(),kelimelerArrayList);
        recyclerView.setAdapter(adapter);
    }



}
