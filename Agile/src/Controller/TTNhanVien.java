/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Date;

/**
 *
 * @author Khai2
 */
public class TTNhanVien {
    protected int MaNV;
    protected String HoTen;
    protected Date NgaySinh;
    protected String DaiChi;
    protected String GioiTinh;
    protected String ChucVu;
    protected String User;
    protected String Password;
    protected String ComfimPassword;
    protected String Email;
    protected String SDT;
    protected String Images;

    public TTNhanVien() {
    }

    public TTNhanVien(int MaNV, String HoTen, Date NgaySinh, String DaiChi, String GioiTinh, String ChucVu, String User, String Password, String ComfimPassword, String Email, String SDT, String Images) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.DaiChi = DaiChi;
        this.GioiTinh = GioiTinh;
        this.ChucVu = ChucVu;
        this.User = User;
        this.Password = Password;
        this.ComfimPassword = ComfimPassword;
        this.Email = Email;
        this.SDT = SDT;
        this.Images = Images;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDaiChi() {
        return DaiChi;
    }

    public void setDaiChi(String DaiChi) {
        this.DaiChi = DaiChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getComfimPassword() {
        return ComfimPassword;
    }

    public void setComfimPassword(String ComfimPassword) {
        this.ComfimPassword = ComfimPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }

    
    
    
    
}
