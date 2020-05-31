/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Barang;
import model.Jenis;
import model.Kategori;

/**
 *
 * @author user
 */
public class BarangCtrl {
    
    Koneksi koneksi;
    ArrayList<Barang> arrBarang;

    public BarangCtrl() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrBarang = new  ArrayList<>();
    }
    
        public ArrayList<Barang> getDataBarang(Barang p) throws SQLException {

        this.arrBarang.clear();
        ResultSet rs = this.koneksi.getData("select * from barang_06936 join kategori_06936 on barang_06936.id_kategori = kategori_06936.id_kategori join jenis_06936 on jenis_06936.id_jenis = barang_06936.id_jenis");
        while (rs.next()) {

            Jenis jenis = new Jenis();
            jenis.setId_jenis(rs.getInt("id_jenis"));
            jenis.setNama_Jenis(rs.getString("nama_jenis"));
            
            Kategori kategori = new Kategori();
            kategori.setId_Kategori(rs.getInt("id_kategori"));
            kategori.setNama_Kategori(rs.getString("nama_kategori"));

            Barang produk = new Barang();
            produk.setId_barang(rs.getInt("id_barang"));
            produk.setJenis(jenis);
            produk.setKategori(kategori);
            produk.setNama_barang(rs.getString("nama_barang"));
            produk.setHarga_Satuan(rs.getInt("harga_barang"));
            this.arrBarang.add(produk);
        }
        return this.arrBarang;
    }
        
    public void insertBarang(Barang databarang) {
        this.koneksi.ManipulasiData("INSERT INTO BARANG_06936 VALUES (" + databarang.getId_barang()+ ", '" + databarang.getJenis().getId_jenis() + ", '"
                + databarang.getKategori().getId_Kategori()+ ", '" + databarang.getNama_barang()+ ", '" + databarang.getHarga_Satuan() + "')");
    }

    public void deleteBarang(int idbarang) {
        try {
            this.koneksi.ManipulasiData("DELETE BARANG_06936 WHERE ID_BARANG=" + idbarang);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   /* public void update(Jenis dataJenis) {
        String kodeSql = "UPDATE JENIS_06936 SET " + "NAMA_JENIS = '" + dataJenis.getNama_Jenis()
                + "WHERE ID_JENIS = " + dataJenis.getId_jenis();
        this.koneksi.ManipulasiData(kodeSql);
    }*/
}
