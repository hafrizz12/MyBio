package com.hafidzmrizky.mybio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hafidzmrizky.mybio.Core.User;
import com.hafidzmrizky.mybio.Model.UserModel;

public class Biodata extends AppCompatActivity {

    TextView namaUser, alamat, kota, jenisKelamin;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        User user = User.getInstance();
        UserModel userModel = user.getUserById(1).iterator().next();

        namaUser = findViewById(R.id.namaUser);
        namaUser.setText(userModel.getNama());

        alamat = findViewById(R.id.alamatUser);
        alamat.setText(userModel.getAlamat());

        kota = findViewById(R.id.kotaUser);
        kota.setText(userModel.getKota());

        jenisKelamin = findViewById(R.id.jenisKelaminUser);
        if (userModel.isJenis_kelamin()) {
            jenisKelamin.setText("Laki-laki");
        } else {
            jenisKelamin.setText("Perempuan");
        }

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> {
            user.clearData();
            finish();
        });




    }
}