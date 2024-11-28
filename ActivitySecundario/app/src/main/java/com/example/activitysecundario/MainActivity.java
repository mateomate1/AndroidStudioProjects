package com.example.activitysecundario;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnActivitySecundario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        btnActivitySecundario = findViewById(R.id.btnActivitySecundario);
        btnActivitySecundario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecundarioActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initSecActivity(View view) {
        Toast.makeText(this, "Has hecho clik en el texto", Toast.LENGTH_LONG).show();
    }
}