package com.hafidzmrizky.mybio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.hafidzmrizky.mybio.Core.User;
import com.hafidzmrizky.mybio.Model.UserModel;

public class MainActivity extends AppCompatActivity {

    EditText namaBiodata, alamatBiodata;
    Spinner kotaBiodata;
    RadioGroup jenisKelaminBiodata;
    ImageButton simpanBiodata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namaBiodata = findViewById(R.id.namaBiodata);
        alamatBiodata = findViewById(R.id.alamatBiodata);
        kotaBiodata = findViewById(R.id.kotaBiodata);
        jenisKelaminBiodata = findViewById(R.id.jenisKelaminBiodata);
        simpanBiodata = findViewById(R.id.simpanBiodata);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.listKota, R.layout.spinnercolor);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kotaBiodata.setAdapter(adapter);

        simpanBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (namaBiodata.getText().toString().isEmpty()) {
                    namaBiodata.setError("Nama tidak boleh kosong");
                    namaBiodata.requestFocus();
                    return;
                }

                if (alamatBiodata.getText().toString().isEmpty()) {
                    alamatBiodata.setError("Alamat tidak boleh kosong");
                    alamatBiodata.requestFocus();
                    return;
                }

                if (kotaBiodata.getSelectedItem().toString().equals("Pilih Kota")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Kota tidak boleh kosong", Toast.LENGTH_SHORT);
                    toast.show();
                    kotaBiodata.requestFocus();
                    return;
                }

                if (jenisKelaminBiodata.getCheckedRadioButtonId() == -1) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Jenis kelamin tidak boleh kosong", Toast.LENGTH_SHORT);
                    toast.show();
                    jenisKelaminBiodata.requestFocus();
                    return;
                }

                saveToModel();
            }
        });



    }

    private void saveToModel() {
        String nama  = namaBiodata.getText().toString();
        String alamat = alamatBiodata.getText().toString();
        String kota = kotaBiodata.getSelectedItem().toString();
        boolean jenisKelamin;

        int getChoice = jenisKelaminBiodata.getCheckedRadioButtonId();
        RadioButton choosen = findViewById(getChoice);
        if (choosen.getText().toString().equals("Laki-laki")) {
            jenisKelamin = true;
        } else {
            jenisKelamin = false;
        }

        UserModel userModel = new UserModel();
        userModel.setId(1);
        userModel.setNama(nama);
        userModel.setAlamat(alamat);
        userModel.setKota(kota);
        userModel.setJenis_kelamin(jenisKelamin);

        User user = User.getInstance();
        user.addUser(userModel);

        Intent intent = new Intent(this, Biodata.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}