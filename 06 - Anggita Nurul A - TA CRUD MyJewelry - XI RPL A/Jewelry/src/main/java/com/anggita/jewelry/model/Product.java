/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anggita.Jewelry.model;

/**
 *
 * @author ZenBook
 */
public class Product {

    private int productId;
    private String fullName;
    private String jenisBeli;
    private String bentukBeli;
    private int berat;
    private int qty;
    private double harga;

    public int getProductId() {
        return productId;
    }
 
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJenisBeli() {
        return jenisBeli;
    }
 
    public void setJenisBeli(String jenisBeli) {
        this.jenisBeli = jenisBeli;
    }
    
    public String getBentukBeli() {
        return bentukBeli;
    }
 
    public void setBentukBeli(String bentukBeli) {
        this.bentukBeli = bentukBeli;
    }

    public int getBerat() {
        return berat;
    }
 
    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getQty() {
        return qty;
    }
 
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public double getHarga() {
        return harga;
    }
 
    public void setHarga(double harga) {
        this.harga = harga;
    }

}
