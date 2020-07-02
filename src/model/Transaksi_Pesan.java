/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author fauzimakarim
 */
public class Transaksi_Pesan {
    private Integer Id_transaksi;
    private Barang barang;
    private Login login;
    private Date Tanggal_transaksi;
    private Integer Jum_barang;
    private Double Harga_Total;
    private ArrayList<Transaksi_Pesan> arr_transaksi;

    public Integer getId_transaksi() {
        return Id_transaksi;
    }

    public void setId_transaksi(Integer Id_transaksi) {
        this.Id_transaksi = Id_transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setbarang(Barang barang) {
        this.barang = barang;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Date getTanggal_transaksi() {
        return Tanggal_transaksi;
    }

    public void setTanggal_transaksi(Date Tanggal_transaksi) {
        this.Tanggal_transaksi = Tanggal_transaksi;
    }
    
    public Integer getJum_barang() {
        return Jum_barang;
    }

    public void setJum_barang(Integer Jum_barang) {
        this.Jum_barang = Jum_barang;
    }
    
    public Double getHarga_Total() {
        return Harga_Total;
    }

    public void setHarga_Total(Double Harga_Total) {
        this.Harga_Total = Harga_Total;
    }

    public ArrayList<Transaksi_Pesan> getArr_transaksi() {
        return arr_transaksi;
    }

    public void setArrDetail_transaksi(ArrayList<Transaksi_Pesan> arr_transaksi) {
        this.arr_transaksi = arr_transaksi;
    }
    
    
    
}
