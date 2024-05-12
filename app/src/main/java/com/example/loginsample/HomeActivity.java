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

    public class HomeActivity extends AppCompatActivity {
        private Button btnReturn;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            String edtUsername1 = getIntent().getStringExtra("edtUsername1");
            TextView txtWelcome = findViewById(R.id.txtWelcome);
            txtWelcome.setText("Bienvenido, " + edtUsername1);

            btnReturn = findViewById(R.id.btnReturn);
            btnReturn.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            });
        }
    }