package com.example.third;

import android.app.AlertDialog;
import android.graphics.Color;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etNIM, etProdi, etAlamat;
    private Button btnDialog, btnToast, btnGantiWarna, btnResetWarna, btnReset, btnKeluar;
    private View mainLayout;
    private int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Bind View
        mainLayout = findViewById(R.id.mainLayout);
        etNama = findViewById(R.id.etNama);
        etNIM = findViewById(R.id.etNIM);
        etProdi = findViewById(R.id.etProdi);
        etAlamat = findViewById(R.id.etAlamat);
        btnDialog = findViewById(R.id.btnDialog);
        btnToast = findViewById(R.id.btnToast);
        btnGantiWarna = findViewById(R.id.btnGantiWarna);
        btnResetWarna = findViewById(R.id.btnResetWarna);
        btnReset = findViewById(R.id.btnReset);
        btnKeluar = findViewById(R.id.btnKeluar);

        // Simpan warna default
        defaultColor = Color.WHITE;

        // Alert Dialog
        btnDialog.setOnClickListener(view -> {
            String nama = etNama.getText().toString();
            String nim = etNIM.getText().toString();
            String prodi = etProdi.getText().toString();
            String alamat = etAlamat.getText().toString();

            String message = "Nama: " + nama + "\nNIM: " + nim + "\nProdi: " + prodi + "\nAlamat: " + alamat;

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Data Inputan")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show();
        });

        // Toast
        btnToast.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Tombol Toast Ditekan!", Toast.LENGTH_SHORT).show();
        });

        // Ganti Warna Background
        btnGantiWarna.setOnClickListener(view -> {
            Random random = new Random();
            int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            mainLayout.setBackgroundColor(color);
        });

        // Reset Warna
        btnResetWarna.setOnClickListener(view -> mainLayout.setBackgroundColor(defaultColor));

        // Reset Input
        btnReset.setOnClickListener(view -> {
            etNama.setText("");
            etNIM.setText("");
            etProdi.setText("");
            etAlamat.setText("");
        });

        // Keluar Aplikasi
        btnKeluar.setOnClickListener(view -> finish());
    }
}
