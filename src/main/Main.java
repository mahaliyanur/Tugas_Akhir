/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.SQLException;
import java.text.ParseException;
import view.Admin;
import view.Transaksiview;


public class Main {
    public static void main(String[] args) throws SQLException,ParseException{
        new Transaksiview().show();
        //new Admin().show();
    }
}
