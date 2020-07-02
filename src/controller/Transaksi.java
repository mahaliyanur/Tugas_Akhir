/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.Kategori;
import model.Login;
import model.Jenis;
import model.Barang;
import model.Transaksi_Pesan;

/**
 *
 * @author mahaliyanur
 */

public class Transaksi {

    Koneksi koneksi;
    ArrayList<Login> arrLogin;
    ArrayList<Barang> arrBarang;
    ArrayList<Transaksi_Pesan> arrTransaksi;

    public Transaksi() throws SQLException {

        this.koneksi = new Koneksi();
        this.arrLogin = new ArrayList<>();
        this.arrBarang = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();

    }

    public ArrayList<Barang> getDataBarang() throws SQLException {

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

    public ArrayList<Login> getDataLogin() throws SQLException {

        this.arrLogin.clear();

        ResultSet rs = this.koneksi.getData("select * from login_06936");

        while (rs.next()) {

            Login login = new Login();
            login.setId_login(rs.getInt("id_login"));
            login.setUsername(rs.getNString("username"));
            login.setPassword(rs.getNString("password"));

            this.arrLogin.add(login);

        }

        return this.arrLogin;

    }

    public ArrayList<Transaksi_Pesan> getDataPemesanan(Transaksi_Pesan p) throws SQLException {

        this.arrTransaksi.clear();

        ResultSet rs = this.koneksi.getData("SELECT LOGIN_06936.*,BARANG_06936.*,JENIS_06936.*,KATEGORI_06936.*, TRANSAKSI.* FROM TRANSAKSI_06936 JOIN LOGIN_06936 ON TRANSAKSI_06936.ID_LOGIN = "
                + "LOGIN_06936.ID_LOGIN, JOIN BARANG_06936 ON TRANSASI_06936.ID_BARANG = BARANG_06936.ID_BARANG JOIN JENIS_06936 ON BARANG_06936.ID_JENIS = JENIS_06936.ID_JENIS JOIN KATEGORI_06936 ON BARANG_06936.ID_KATEGORI = KATEGORI_06936.ID_KATEGORI ORDER BY ID_TRANSAKSI DESC");
        while (rs.next()) {

            Login login = new Login();
            login.setId_login(rs.getInt("id_login"));
            login.setUsername(rs.getNString("username"));
            login.setPassword(rs.getNString("password"));
            
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
            produk.setHarga_Satuan(rs.getInt("harga_satuan"));

            Transaksi_Pesan pemesanan = new Transaksi_Pesan();
            pemesanan.setId_transaksi(rs.getInt("id_transaksi"));
            pemesanan.setLogin(login);
            pemesanan.setbarang(produk);
            pemesanan.setTanggal_transaksi(rs.getDate("tanggal_transaksi"));
            pemesanan.setJum_barang(rs.getInt("Jum_barang"));
            pemesanan.setHarga_Total(rs.getDouble("harga_total"));

            this.arrTransaksi.add(pemesanan);
        }

        return this.arrTransaksi;
    }

    public void insertTransaksi(Transaksi_Pesan pemesanan) {

        try {

            String datePemesanan = new SimpleDateFormat("dd/MM/yyyy").format(pemesanan.getTanggal_transaksi());
            this.koneksi.ManipulasiData("INSERT INTO TRANSAKSI_06936"
                    + "(ID_TRANSAKSI, ID_LOGIN, ID_BARANG, TANGGAL_TRANSAKSI, JUM_BARANG, HARGA_TOTAL)\n"
                    + "VALUES(ID_TRANSAKSI.NEXTVAL, " + pemesanan.getLogin().getId_login() + ", " + pemesanan.getBarang().getId_barang() + ", TO_DATE('" + datePemesanan + "','dd/MM/yyyy'),'" + pemesanan.getJum_barang() + "', " + pemesanan.getHarga_Total().toString() + ")");
            ResultSet rsp = this.koneksi.getData("select id_transaksi.currval from dual");
            rsp.next();
            int id_transaksi = rsp.getInt("currval");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
