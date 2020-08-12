/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Date;


/**
 *
 * @author Khai2
 */
public class HoaDon {
    protected int ID_HDCT;
    protected String ID_HD;
    protected String ID_SP;
    protected String Ten_SP;
    protected String MauSac;
    protected int Size;
    protected int SoLuong;
    protected Date NgayMua;
    protected double Gia;
    protected double Discount;
    protected double ThanhTien;
    protected String TenKH;
    protected String SDT;
    public HoaDon() {
    }

    public HoaDon(int ID_HDCT, String ID_HD, String ID_SP, String Ten_SP, String MauSac, int Size, int SoLuong, Date NgayMua, double Gia, double Discount, double ThanhTien, String TenKH, String SDT) {
        this.ID_HDCT = ID_HDCT;
        this.ID_HD = ID_HD;
        this.ID_SP = ID_SP;
        this.Ten_SP = Ten_SP;
        this.MauSac = MauSac;
        this.Size = Size;
        this.SoLuong = SoLuong;
        this.NgayMua = NgayMua;
        this.Gia = Gia;
        this.Discount = Discount;
        this.ThanhTien = ThanhTien;
        this.TenKH = TenKH;
        this.SDT = SDT;
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

    

    public int getID_HDCT() {
        return ID_HDCT;
    }

    public void setID_HDCT(int ID_HDCT) {
        this.ID_HDCT = ID_HDCT;
    }

    public String getID_HD() {
        return ID_HD;
    }

    public void setID_HD(String ID_HD) {
        this.ID_HD = ID_HD;
    }

    public String getID_SP() {
        return ID_SP;
    }

    public void setID_SP(String ID_SP) {
        this.ID_SP = ID_SP;
    }

    public String getTen_SP() {
        return Ten_SP;
    }

    public void setTen_SP(String Ten_SP) {
        this.Ten_SP = Ten_SP;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}

