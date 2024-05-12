package com.example.loginsample;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginsample.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        EditText edtUsername = binding.edtUsername;
        EditText edtPassword = binding.edtPassword;

        Button btnLogin = binding.btnLogin;
        Button btnAddAccount = binding.btnAddAccount;

        btnLogin.setOnClickListener(v -> {
            String edtUsername1 = edtUsername.getText().toString();
            String edtPassword1 = edtPassword.getText().toString();

            if (authenticateUser(edtUsername1, edtPassword1)) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("edtUsername1", edtUsername1);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "error de aunteticacion", Toast.LENGTH_SHORT).show();
            }
        });

        btnAddAccount.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
            startActivity(intent);
        });
    }
    private boolean authenticateUser(String username, String password) {
        String adminUsername = binding.edtUsername.getText().toString();
        String adminPassword = binding.edtPassword.getText().toString();
        return username.equals(adminUsername) && password.equals(adminPassword);
    }
}