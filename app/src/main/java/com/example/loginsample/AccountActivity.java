package com.example.loginsample;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class AccountActivity extends AppCompatActivity {
    public final static String ACCOUNT_RECORD = "ACCOUNT_RECORD";
    public final static Integer ACCOUNT_ACEPTAR = 100;
    public final static Integer ACCOUNT_CANCELAR = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_account);

        Button btnOk = findViewById(R.id.btnOk);
        Button btnCancel = findViewById(R.id.btnCancel);

        EditText edtFirstname = findViewById(R.id.edtFirstname);
        EditText edtLastname = findViewById(R.id.edtLastname);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPhone = findViewById(R.id.edtPhone);
        EditText edtUsername2 = findViewById(R.id.edtUsername2);
        EditText edtPassword2 = findViewById(R.id.edtPassword2);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountEntity accountEntity = new AccountEntity();

                accountEntity.setFirstname(edtFirstname.getText().toString());
                accountEntity.setLastname(edtLastname.getText().toString());
                accountEntity.setEmail(edtEmail.getText().toString());
                accountEntity.setPhone(edtPhone.getText().toString());
                accountEntity.setUsername(edtUsername2.getText().toString());
                accountEntity.setPassword(edtPassword2.getText().toString());

                Gson gson = new Gson();
                String accountJson = gson.toJson(accountEntity);

                Intent data = new Intent();
                data.putExtra(ACCOUNT_RECORD, accountJson);

                setResult(ACCOUNT_ACEPTAR, data);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(ACCOUNT_CANCELAR);
                finish();
            }
        });
    }
}
