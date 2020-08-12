/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import java.sql.Date;

/**
 *
 * @author Khai2
 */
public class QLDH {
    protected String MaHD;
    protected String NgayBan;
    protected String MaNV;
    protected String TenNV;
    protected String MaKH;
    protected String TenKH;
    protected String SDT;
    protected String MaSP;
    protected String TenSP;
    protected double GiaSP;
    protected int SoLuong;
    protected String MauSac;
    protected double Discount;
    protected int Size;
    protected double ThanhTien;

    public QLDH() {
    }

    public QLDH(String MaHD, String NgayBan, String MaNV, String TenNV, String MaKH, String TenKH, String SDT, String MaSP, String TenSP, double GiaSP, int SoLuong, String MauSac, double Discount, int Size, double ThanhTien) {
        this.MaHD = MaHD;
        this.NgayBan = NgayBan;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.GiaSP = GiaSP;
        this.SoLuong = SoLuong;
        this.MauSac = MauSac;
        this.Discount = Discount;
        this.Size = Size;
        this.ThanhTien = ThanhTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(String NgayBan) {
        this.NgayBan = NgayBan;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(double GiaSP) {
        this.GiaSP = GiaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
