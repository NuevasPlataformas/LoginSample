    package com.example.loginsample;

    import static com.example.loginsample.R.*;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.TextView;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    import com.google.gson.Gson;

    public class HomeActivity extends AppCompatActivity {
        private Button btnReturn;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            String accountEntityString = getIntent().getStringExtra("ACCOUNT");

            Gson gson = new Gson();
            AccountEntity accountEntity = gson.fromJson(accountEntityString, AccountEntity.class);

            TextView edtFirstname = findViewById(id.edtFirstname_);
            TextView edtLastname = findViewById(id.edtLastname_);
            //TextView edtEmail = findViewById(id.edtEmail);
            //TextView edtPhone = findViewById(id.edtPhone);
            //TextView edtUsername = findViewById(id.edtUsername);
            //TextView edtPassword = findViewById(id.edtPassword);

            edtFirstname.setText(accountEntity.getFirstname());
            edtLastname.setText(accountEntity.getLastname());
            //edtEmail.setText(accountEntity.getEmail());
            //edtPhone.setText(accountEntity.getPhone());
            //edtUsername.setText(accountEntity.getUsername());
            //edtPassword.setText(accountEntity.getPassword());



            btnReturn = findViewById(R.id.btnReturn);
            btnReturn.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }