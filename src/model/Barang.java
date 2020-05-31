/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author fauzimakarim
 */
public class Barang {
    
    private Integer Id_barang;
    private Jenis Jenis;
    private Kategori Kategori;
    private String Nama_barang;
    private Integer Harga_Satuan;

    public Integer getId_barang() {
        return Id_barang;
    }

    public void setId_barang(Integer Id_barang) {
        this.Id_barang = Id_barang;
    }

    public Jenis getJenis() {
        return Jenis;
    }

    public void setJenis(Jenis Jenis) {
        this.Jenis = Jenis;
    }

    public Kategori getKategori() {
        return Kategori;
    }

    public void setKategori(Kategori Kategori) {
        this.Kategori = Kategori;
    }

    public String getNama_barang() {
        return Nama_barang;
    }

    public void setNama_barang(String Nama_barang) {
        this.Nama_barang = Nama_barang;
    }

    public Integer getHarga_Satuan() {
        return Harga_Satuan;
    }

    public void setHarga_Satuan(Integer Harga_Satuan) {
        this.Harga_Satuan = Harga_Satuan;
    }
}
