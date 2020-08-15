/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Administrator
 */
public class DoanhThu {
    protected String NgayBan;
    protected String ID_SP;
    protected int SumHD;
    protected int SumSP;
    protected long TongTien;
//    protected String Images;

    public DoanhThu() {
    }

    public DoanhThu(String NgayBan, String ID_SP, int SumHD, int SumSP, long TongTien) {
        this.NgayBan = NgayBan;
        this.ID_SP = ID_SP;
        this.SumHD = SumHD;
        this.SumSP = SumSP;
        this.TongTien = TongTien;
//        this.Images = Images;
    }

    public String getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(String NgayBan) {
        this.NgayBan = NgayBan;
    }

    public String getID_SP() {
        return ID_SP;
    }

    public void setID_SP(String ID_SP) {
        this.ID_SP = ID_SP;
    }

    public int getSumHD() {
        return SumHD;
    }

    public void setSumHD(int SumHD) {
        this.SumHD = SumHD;
    }

    public int getSumSP() {
        return SumSP;
    }

    public void setSumSP(int SumSP) {
        this.SumSP = SumSP;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

//    public String getImages() {
//        return Images;
//    }
//
//    public void setImages(String Images) {
//        this.Images = Images;
//    }
    
    
}
