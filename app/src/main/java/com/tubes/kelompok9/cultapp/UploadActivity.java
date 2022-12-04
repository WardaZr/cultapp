package com.tubes.kelompok9.cultapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tubes.kelompok9.cultapp.R;

public class UploadActivity extends AppCompatActivity {
    private RecyclerView content_view;

    EditText edtJudul;
    private Button btnSubmit;
    BottomNavigationView bottomNavigationView;

    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        this.getSupportActionBar().hide();

        btnSubmit = findViewById(R.id.btn_submit);
        edtJudul          = findViewById(R.id.edt_judul);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent home = new Intent(UploadActivity.this, MainActivity.class);
                        startActivity(home);
                        finish();
                        break;
                    case R.id.menu_add:
                        Intent lap_peng = new Intent(UploadActivity.this, UploadActivity.class);
                        startActivity(lap_peng);
                        finish();
                        break;
                    case R.id.menu_profil:
                        Intent user = new Intent(UploadActivity.this, UserActivity.class);
                        startActivity(user);
                        finish();
                        break;
                }
                return true;
            }
        });
    }
}
