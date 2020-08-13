/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class KhachHang implements Serializable{
    protected String TenKH,SDT;
    protected String MaKH;

    public KhachHang() {
    }

    public KhachHang(String MaKH,String TenKH, String SDT) {
        this.TenKH = TenKH;
        this.SDT = SDT;
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

    public String getMaKH() {
        return MaKH;
    }    
       
    
}
