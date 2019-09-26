package com.haritsdeveloper.recyclerview;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//Add in pada Komponent
    private MovieAdapter movieAdapter;
    RecyclerView rvMain;
    Toolbar toolbar;
    ArrayList<ModelMovie>arrayList;
    private String[] id = {"1001","1002","1003"};
    private String[] judul = {"seribu satu orang hebat", "Temukan Jati diri disini", "siapa Saya in"};
    private String[] subJudul = {"Orang Hebat", "Pejuang Dakwah","Petani Kode"};
    private String[] gambar = {"8bRIfPGDnmWgdy65LO8xtdcFmFP.jpg","1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg","hpgda6P9GutvdkDX5MUJ92QG9aj.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        //Cari id komponent saya!! 
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        arrayList = new ArrayList<>();
        setData();
        rvMain = findViewById(R.id.rvMain);
        rvMain.setHasFixedSize(true);
        movieAdapter = new MovieAdapter(arrayList);
        rvMain.setAdapter(movieAdapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setData(){
        int count = 0;
        for(String id : id){
            arrayList.add(new ModelMovie(id,judul[count], subJudul[count],gambar[count]));
            count++;
        }
    }
    
    //Method Search
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        search(searchView);
        return true;
    }

    private void search(SearchView searchView){
        searchView.setOnQueryTextListener((new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (movieAdapter!=null)movieAdapter.getFilter().filter(s);
                return true;
            }
        }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.changeLanguage:
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
