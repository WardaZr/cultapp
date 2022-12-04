package com.tubes.kelompok9.cultapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tubes.kelompok9.cultapp.entity.ContentNotes;
import com.tubes.kelompok9.cultapp.R;
import com.tubes.kelompok9.cultapp.adapter.ContentNotesAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView content_view;
    private ArrayList<ContentNotes> contentDataList;
    private ContentNotesAdapter adapter;

    TextView tvJudul;
    ImageView imgKonten;

    private ImageButton btnBudaya, btnKuliner, btnTradisi, btnPariwisata;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        tvJudul      = findViewById(R.id.tv_item_judul);
        imgKonten    = findViewById(R.id.img_konten);
        content_view = findViewById(R.id.content_view);

        contentDataList = new ArrayList<>();

        contentDataList.add(new ContentNotes ("Candi Borobudur",R.drawable.content_exp));
        contentDataList.add(new ContentNotes("Tradisi Ngaben",R.drawable.content_exp));
        contentDataList.add(new ContentNotes("Tradisi Mandi Kembang",R.drawable.content_exp));
        contentDataList.add(new ContentNotes("Suku Sunda",R.drawable.content_exp));

        adapter = new ContentNotesAdapter(contentDataList,this);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);

        content_view.setLayoutManager(layoutManager);
        content_view.setAdapter(adapter);

        btnBudaya       = findViewById(R.id.btn_budaya);
        btnTradisi      = findViewById(R.id.btn_tradisi);
        btnKuliner      = findViewById(R.id.btn_kuliner);
        btnPariwisata   = findViewById(R.id.btn_pariwisata);

        btnBudaya.setOnClickListener(view -> {
            if (view.getId() == R.id.btn_budaya) {
                Intent moveToBudaya = new Intent(MainActivity.this, ContentActivity.class);
                moveToBudaya.putExtra(ContentActivity.EXTRA_NAME, "Budaya");
                startActivity(moveToBudaya);
                finish();
            }
        });
        btnTradisi.setOnClickListener(view -> {
            if (view.getId() == R.id.btn_tradisi){
                Intent moveToTradisi = new Intent(MainActivity.this, ContentActivity.class);
                moveToTradisi.putExtra(ContentActivity.EXTRA_NAME, "Tradisi");
                startActivity(moveToTradisi);
                finish();
            }
        });
        btnKuliner.setOnClickListener(view -> {
            if (view.getId() == R.id.btn_kuliner) {
                Intent moveToKuliner = new Intent(MainActivity.this, ContentActivity.class);
                moveToKuliner.putExtra(ContentActivity.EXTRA_NAME, "Kuliner");
                startActivity(moveToKuliner);
                finish();
            }
        });
        btnPariwisata.setOnClickListener(view -> {
            if (view.getId() == R.id.btn_budaya) {
                Intent moveToPar = new Intent(MainActivity.this, ContentActivity.class);
                moveToPar.putExtra(ContentActivity.EXTRA_NAME, "Pariwisata");
                startActivity(moveToPar);
                finish();
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavbar);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent home = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(home);
                        finish();
                        break;
                    case R.id.menu_add:
                        Intent add = new Intent(MainActivity.this, UploadActivity.class);
                        startActivity(add);
                        finish();
                        break;
                    case R.id.menu_profil:
                        Intent user = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(user);
                        finish();
                        break;
                }
                return true;
            }
        });
    }
}