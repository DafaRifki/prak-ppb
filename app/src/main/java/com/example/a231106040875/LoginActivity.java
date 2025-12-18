package com.example.a231106040875;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.edtUsername);
        password = findViewById(R.id.edtPassword);
        btLogin = findViewById(R.id.btnLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });
    }

    private void doLogin() {
        String userKey = username.getText().toString();
        String passKey = password.getText().toString();

        // if sukses (cocok)
        if (userKey.equals("admin") && passKey.equals("admin123")){
            Toast.makeText(getApplicationContext(), "Login berhasil..", Toast.LENGTH_LONG).show();
            Intent dash = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(dash);
        }
        // jika tidak sesuai
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("Username atau Password tidak sesuai!")
                    .setNegativeButton("Silahkan coba lagi...", null).create().show();
        }
    }
}