package com.hafidzmrizky.mybio.Model;

public class UserModel {
    String nama;
    String alamat;
    String kota;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    boolean jenis_kelamin;
    String gambarUser;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public boolean isJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(boolean jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getGambarUser() {
        return gambarUser;
    }

    public void setGambarUser(String gambarUser) {
        this.gambarUser = gambarUser;
    }
}
