/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Barang;
import model.Jenis;
import model.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.Koneksi;
import view.Logingui;

/**
 *
 * @author Administrator
 */
public class LoginController {
    Koneksi koneksi;
    ArrayList<Login> arrlogin;

    public LoginController() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrlogin = new ArrayList<>();
    }

    public ArrayList<Login> getDataLogin(Login p) throws SQLException {
       this.arrlogin.clear();
       ResultSet rs = this.koneksi.getData("SELECT * FROM login_06936 ORDER BY ID_LOGIN ASC");
        while (rs.next()) {
            Login lg = new Login();
            lg.setId_login(rs.getInt("id_login"));
            lg.setUsername(rs.getString("username"));
            lg.setPassword(rs.getString("password"));
            this.arrlogin.add(lg);

        }
        return this.arrlogin;
    }

    public void insertLogin(Login datalogin) {
        this.koneksi.ManipulasiData("INSERT INTO LOGIN VALUES (" + datalogin.getId_login()+ ", '"
                + datalogin.getUsername() + "', '" + datalogin.getPassword() + "')");
    }

    public void deleteLogin(int idLogin) {
        try {
            this.koneksi.ManipulasiData("DELETE LOGIN WHERE ID_OWNER=" + idLogin);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Login dataLogin) {
        String kodeSql = "UPDATE LOGIN SET " + "USERNAME = '" + dataLogin.getUsername()+ "', "
                + "PASSWORD = '" + dataLogin.getPassword() + "'" 
                + "WHERE ID_OWNER = " + dataLogin.getId_login();
        this.koneksi.ManipulasiData(kodeSql);
    }
}