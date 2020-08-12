/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import java.util.Date;

/**
 *
 * @author Khai2
 */
public class SanPham {
    protected String ID_SP;
    protected String Ten_SP;
    protected String Loai_SP;
    protected String MauSac;
    protected int Size;
    protected String Image;
    protected  double GiaTien;
    protected String Ngaynhap;
    protected int SoLuong;
    protected String TrangThai;

    public SanPham() {
    }

    public SanPham(String ID_SP, String Ten_SP, String Loai_SP, String MauSac, int Size, String Image, double GiaTien, String Ngaynhap, int SoLuong, String TrangThai) {
        this.ID_SP = ID_SP;
        this.Ten_SP = Ten_SP;
        this.Loai_SP = Loai_SP;
        this.MauSac = MauSac;
        this.Size = Size;
        this.Image = Image;
        this.GiaTien = GiaTien;
        this.Ngaynhap = Ngaynhap;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
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

    public String getLoai_SP() {
        return Loai_SP;
    }

    public void setLoai_SP(String Loai_SP) {
        this.Loai_SP = Loai_SP;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getNgaynhap() {
        return Ngaynhap;
    }

    public void setNgaynhap(String Ngaynhap) {
        this.Ngaynhap = Ngaynhap;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
