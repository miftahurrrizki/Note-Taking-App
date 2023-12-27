/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zakim
 */
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Notes {
    private String username, judul, isi;
    private Timestamp tanggal;

    public Notes(String judul, String isi, Timestamp tanggal) {
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public Notes(String username, String judul, String isi, Timestamp tanggal) {
        this.username = username;
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }
    
    public Notes(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Timestamp getTanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return judul;
    }
}

