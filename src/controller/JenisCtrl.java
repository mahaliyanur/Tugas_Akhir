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
import model.Jenis;
/**
 *
 * @author user
 */
public class JenisCtrl {
    Koneksi koneksi;
    ArrayList<Jenis> arrjenis;

    public JenisCtrl() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrjenis = new ArrayList<>();
    }

    public ArrayList<Jenis> getDataJenis(Jenis p) throws SQLException {
       this.arrjenis.clear();
       ResultSet rs = this.koneksi.getData("SELECT * FROM jenis_06936 ORDER BY ID_JENIS ASC");
        while (rs.next()) {
            Jenis lg = new Jenis();
            lg.setId_jenis(rs.getInt("id_jenis"));
            lg.setNama_Jenis(rs.getString("nama_jenis"));
            this.arrjenis.add(lg);

        }
        return this.arrjenis;
    }

    public void insertJenis(Jenis datajenis) {
        this.koneksi.ManipulasiData("INSERT INTO JENIS_06936 VALUES (" + datajenis.getId_jenis()+ ", '"
                + datajenis.getNama_Jenis() + "')");
    }

    public void deleteJenis(int idjenis) {
        try {
            this.koneksi.ManipulasiData("DELETE JENIS_06936 WHERE ID_JENIS=" + idjenis);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Jenis dataJenis) {
        String kodeSql = "UPDATE JENIS_06936 SET " + "NAMA_JENIS = '" + dataJenis.getNama_Jenis()
                + "WHERE ID_JENIS = " + dataJenis.getId_jenis();
        this.koneksi.ManipulasiData(kodeSql);
    }
}
