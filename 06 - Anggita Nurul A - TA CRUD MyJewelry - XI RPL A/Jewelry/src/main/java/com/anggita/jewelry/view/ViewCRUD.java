/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anggita.Jewelry.view;

import com.anggita.Jewelry.controller.ProductDAOImp;
import com.anggita.Jewelry.model.Product;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ZenBook
 */
public class ViewCRUD {
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader); 
    static Scanner inputUser = new Scanner(System.in);   

    public static void showMenu() {
        System.out.println("\n========= MENU UTAMA SI PRODUK HP =========");
        System.out.println("1. Tampilkan Produk");
        System.out.println("2. Search Produk Berdasarkan ID Produk");
        System.out.println("3. Insert Produk");
        System.out.println("4. Update Produk");
        System.out.println("5. Delete Produk");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    insertProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showProduct() {
        try {
            ProductDAOImp productDAO = new ProductDAOImp();
            List<Product> listProduct = productDAO.list();
            
            // Show
            System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                             DATA PEMBELIAN PERHIASAN (MY JEWELRY)                                                                                    |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|  ID Produk  |  Nama Pembeli  |  Jenis Perhiasan  |  Bentuk Perhiasan  |  Berat Perhiasan (gram)  |  Kuantitas  |  Harga (Rp.)  |");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------+");

            for(Product product: listProduct)
            {
                int productId = product.getProductId();
                String fullName = product.getFullName();
                String jenisBeli = product.getJenisBeli();
                String bentukBeli = product.getBentukBeli();
                int berat = product.getBerat();
                int qty = product.getQty();
                double harga = product.getHarga();
                System.out.println(String.format("|      %d      |  %s           |  %s    |  %s            |  %d                       |  %d          |  %.2f    |", productId, fullName, jenisBeli, bentukBeli, berat, qty, harga));
            }    
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void searchProduct() {
        try {        
            // Ambil input dari user
            System.out.println("\n========= SEARCH PRODUK =========");
            System.out.println("ID Produk yang mau dicari: ");
            int productId = Integer.parseInt(input.readLine());

            // Search
            ProductDAOImp dao = new ProductDAOImp();
            Product productDAO = dao.getProduct(productId);
            int getProductId = productDAO.getProductId();
            String fullName = productDAO.getFullName();
            String jenisBeli = productDAO.getJenisBeli();
            String bentukBeli = productDAO.getBentukBeli();
            int berat = productDAO.getBerat();
            int qty = productDAO.getQty();
            double harga = productDAO.getHarga();

            System.out.println(String.format("ID Produk : %d ", getProductId));
            System.out.println(String.format("Nama Pembeli : %s ", fullName));
            System.out.println(String.format("Jenis Perhiasan : %s ", jenisBeli));
            System.out.println(String.format("Bentuk Perhiasan : %s ", bentukBeli));
            System.out.println(String.format("Berat Perhiasan (gram) : %d ", berat));
            System.out.println(String.format("Kuantitas : %d ", qty));
            System.out.println(String.format("Harga (Rp.): %.2f ", harga));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insertProduct() {
        try {
            // Ambil input dari user
            System.out.println("\n========= INSERT PRODUK =========");
            System.out.println("Nama Pembeli : ");
            String fullName = input.readLine().trim();
            System.out.println("Jenis Perhiasan : ");
            String jenisBeli = input.readLine().trim();
            System.out.println("Bentuk Perhiasan : ");
            String bentukBeli = input.readLine().trim();
            System.out.println("Berat Perhiasan (gram) : ");
            int berat = inputUser.nextInt();
            System.out.println("Kuantitas : ");
            int qty = inputUser.nextInt();
            System.out.println("Harga (Rp.) : ");
            double harga = inputUser.nextDouble();
 
            // Insert
            Product product = new Product();
            product.setFullName(fullName);
            product.setJenisBeli(jenisBeli);
            product.setBentukBeli(bentukBeli);
            product.setBerat(berat);
            product.setQty(qty);
            product.setHarga(harga);
        
            ProductDAOImp dao = new ProductDAOImp();
            dao.insert(product);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void updateProduct() {
        try {
            // Ambil input dari user
            System.out.println("\n========= UPDATE PRODUK =========");
            System.out.println("ID Produk  yang mau diupdate: ");
            int productId = Integer.parseInt(input.readLine());
            System.out.println("Nama Pembeli : ");
            String fullName = input.readLine().trim();
            System.out.println("Jenis Perhiasan : ");
            String jenisBeli = input.readLine().trim();
            System.out.println("Bentuk Perhiasan : ");
            String bentukBeli = input.readLine().trim();
            System.out.println("Berat Perhiasan (gram) : ");
            int berat = inputUser.nextInt();
            System.out.println("Kuantitas : ");
            int qty = inputUser.nextInt();
            System.out.println("Harga (Rp.) : ");
            double harga = inputUser.nextDouble();
 
            // Update
            Product product = new Product();
            product.setFullName(fullName);
            product.setJenisBeli(jenisBeli);
            product.setBentukBeli(bentukBeli);
            product.setBerat(berat);
            product.setQty(qty);
            product.setHarga(harga);
            product.setProductId(productId);
        
            ProductDAOImp dao = new ProductDAOImp();
            dao.update(product);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteProduct() {
        try {
            // Ambil input dari user
            System.out.println("\n========= DELETE PRODUK =========");
            System.out.println("ID Produk yang mau didelete: ");
            int productId = Integer.parseInt(input.readLine());

            // Delete
            Product product = new Product();
            product.setProductId(productId);
            ProductDAOImp dao = new ProductDAOImp();
            dao.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
