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
public class DanhMuc {
    private String maDm;
    private String tenDm;
    private String maNcc;
    private boolean trangThai;

    public DanhMuc() {
    }

    public DanhMuc(String maDm, String tenDm, String maNcc, boolean trangThai) {
        this.maDm = maDm;
        this.tenDm = tenDm;
        this.maNcc = maNcc;
        this.trangThai = trangThai;
    }

    public String getMaDm() {
        return maDm;
    }

    public void setMaDm(String maDm) {
        this.maDm = maDm;
    }

    public String getTenDm() {
        return tenDm;
    }

    public void setTenDm(String tenDm) {
        this.tenDm = tenDm;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
