/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class DonVi {
    private String maDon_vi;
    private String tenDon_vi;
    private boolean trangThai;

    public DonVi() {
    }

    public DonVi(String maDon_vi, String tenDon_vi, boolean trangThai) {
        this.maDon_vi = maDon_vi;
        this.tenDon_vi = tenDon_vi;
        this.trangThai = trangThai;
    }

    public String getMaDon_vi() {
        return maDon_vi;
    }

    public void setMaDon_vi(String maDon_vi) {
        this.maDon_vi = maDon_vi;
    }

    public String getTenDon_vi() {
        return tenDon_vi;
    }

    public void setTenDon_vi(String tenDon_vi) {
        this.tenDon_vi = tenDon_vi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
