package com.example.loginsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;

public class AccountActivity extends AppCompatActivity {
    private EditText edtFirstName, edtLastName, edtEmail, edtPhone, edtUsername, edtPassword;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        edtFirstName = findViewById(R.id.edtFirstname);
        edtLastName = findViewById(R.id.edtLastname);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.editTextPhone);
        edtUsername = findViewById(R.id.edtUsername2);
        edtPassword = findViewById(R.id.edtPassword2);

        Button btnOk = findViewById(R.id.btnOK);
        btnOk.setOnClickListener(v -> {
            String firstname = edtFirstName.getText().toString();
            String lastname = edtLastName.getText().toString();
            String email = edtEmail.getText().toString();
            String phone = edtPhone.getText().toString();
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setFirstname(firstname);
            accountEntity.setLastname(lastname);
            accountEntity.setEmail(email);
            accountEntity.setPhone(phone);
            accountEntity.setUsername(username);
            accountEntity.setPassword(password);

            Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
            //intent.putExtra("accountEntity", (CharSequence) accountEntity);
            startActivity(intent);
            finish();
        });
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(v -> finish());


    }
}
