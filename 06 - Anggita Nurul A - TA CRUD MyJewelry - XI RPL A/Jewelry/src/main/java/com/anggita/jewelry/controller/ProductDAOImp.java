/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anggita.Jewelry.controller;

import com.anggita.jewelry.DB.ConnectionDB;
import com.anggita.Jewelry.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ZenBook
 */
public class ProductDAOImp implements ProductDAO {
    @Override
    public void insert(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "INSERT INTO data_beli (fullName,jenisBeli,bentukBeli,berat,qty,harga) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setString(1, product.getFullName());
            ps.setString(2, product.getJenisBeli());
            ps.setString(3, product.getBentukBeli());
            ps.setInt(4, product.getBerat());
            ps.setInt(5, product.getQty());
            ps.setDouble(6, product.getHarga());
            ps.executeUpdate();
            System.out.println("Data has been saved");
        }  
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot insert into table");
        }
    }   

    @Override
    public void update(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "UPDATE data_beli SET fullName =?, jenisBeli=?, bentukBeli=?, berat=?, qty=?, harga=? WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setString(1, product.getFullName());
            ps.setString(2, product.getJenisBeli());
            ps.setString(3, product.getBentukBeli());
            ps.setInt(4, product.getBerat());
            ps.setInt(5, product.getQty());
            ps.setDouble(6, product.getHarga());
            ps.setInt(7, product.getProductId());
            ps.executeUpdate();
            System.out.println("Data has been update");
        }  
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot update into table");
        }
    }   

    @Override
    public void delete(Product product) {
        try {
            Connection conDB =  ConnectionDB.getConnection();
            String sql = "DELETE FROM data_beli WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, product.getProductId());
            ps.executeUpdate();
            System.out.println("Data has been delete");
        }  
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot delete into table");
        }
    }   

    @Override
    public Product getProduct(int productId) {
        Product product = new Product();
        try {
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM data_beli WHERE productId=?";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                product.setProductId(rs.getInt("productId"));
                product.setFullName(rs.getString("fullName"));
                product.setJenisBeli(rs.getString("jenisBeli"));
                product.setBentukBeli(rs.getString("bentukBeli"));
                product.setBerat(rs.getInt("berat"));
                product.setQty(rs.getInt("qty"));
                product.setHarga(rs.getInt("harga"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot get data from table by using productId");
        }
        return product;
    }

    @Override
    public List<Product> list() {
      
        List<Product> listProduct = new ArrayList<Product>();

        try{
            Connection conDB = ConnectionDB.getConnection();
            String sql = "SELECT * FROM data_beli";
            PreparedStatement ps = conDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setFullName(rs.getString("fullName"));
                product.setJenisBeli(rs.getString("jenisBeli"));
                product.setBentukBeli(rs.getString("bentukBeli"));
                product.setBerat(rs.getInt("berat"));
                product.setQty(rs.getInt("qty"));
                product.setHarga(rs.getInt("harga"));
 
                listProduct.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cannot get data from table");
        }
        return listProduct;
    }
}
