package com.example.a231106040875;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {
    private Button btnProfile;
    private Button btnMk;
    private Button btnProdi;
    private Button btnKalkulator;

    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnProfile = findViewById(R.id.btnProfile);
        btnProdi = findViewById(R.id.btnProdi);
        btnMk = findViewById(R.id.btnMataKuliah);
        btnKalkulator = findViewById(R.id.btnKalkulator);
        btnLogout = findViewById(R.id.btnLogout);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Akses profile...", Toast.LENGTH_LONG).show();
                Intent profile = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(profile);
            }
        });

        btnMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mk = new Intent(DashboardActivity.this, MataKuliahActivity.class);
                startActivity(mk);
            }
        });

        btnProdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prodi = new Intent(DashboardActivity.this, ProdiActivity.class);
                startActivity(prodi);
            }
        });

        btnKalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kalkulator = new Intent(DashboardActivity.this, KalkulatorActivity.class);
                startActivity(kalkulator);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logout berhasil..", Toast.LENGTH_LONG).show();
                Intent logout = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(logout);
                finish();
            }
        });
    }
}