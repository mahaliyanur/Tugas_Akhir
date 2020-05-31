/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.Koneksi;
import model.Kategori;

/**
 *
 * @author user
 */
public class KategoriCtrl {
    Koneksi koneksi;
    ArrayList<Kategori> arrkategori;

    public KategoriCtrl() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrkategori = new ArrayList<>();
    }

    public ArrayList<Kategori> getDataKategori(Kategori p) throws SQLException {
       this.arrkategori.clear();
       ResultSet rs = this.koneksi.getData("SELECT * FROM kategori_06936 ORDER BY ID_KATEGORI ASC");
        while (rs.next()) {
            Kategori lg = new Kategori();
            lg.setId_Kategori(rs.getInt("id_kategori"));
            lg.setNama_Kategori(rs.getString("nama_kategori"));
            this.arrkategori.add(lg);

        }
        return this.arrkategori;
    }

    public void insertLogin(Kategori datakategori) {
        this.koneksi.ManipulasiData("INSERT INTO KATEGORI_06936 VALUES (" + datakategori.getId_Kategori()+ ", '"
                + datakategori.getNama_Kategori() + "')");
    }

    public void deleteLogin(int idkategori) {
        try {
            this.koneksi.ManipulasiData("DELETE KATEGORI_06936 WHERE ID_OWNER=" + idkategori);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Kategori dataKategori) {
        String kodeSql = "UPDATE LOGIN SET " + "NAMA_KATEGORI = '" + dataKategori.getNama_Kategori()
                + "WHERE ID_KATEGORI = " + dataKategori.getId_Kategori();
        this.koneksi.ManipulasiData(kodeSql);
    }
}
