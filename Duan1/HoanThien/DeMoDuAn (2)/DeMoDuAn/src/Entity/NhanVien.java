/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String maNv;
    private String ho_ten;
    private boolean gioi_tinh;
    private Date ngay_sinh;
    private String email;
    private String sdt;
    private String mat_khau;
    private String dia_chi;
    private boolean vai_tro;
    private String hinh_anh;
    private boolean trang_thai;

    public NhanVien() {
    }

    public NhanVien(String maNv, String ho_ten, boolean gioi_tinh, String email, String sdt, String mat_khau, String dia_chi, boolean vai_tro, String hinh_anh, boolean trang_thai) {
        this.maNv = maNv;
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.email = email;
        this.sdt = sdt;
        this.mat_khau = mat_khau;
        this.dia_chi = dia_chi;
        this.vai_tro = vai_tro;
        this.hinh_anh = hinh_anh;
        this.trang_thai = trang_thai;
    }

    

    public NhanVien(String maNv, String ho_ten, boolean gioi_tinh, Date ngay_sinh, String email, String sdt, String mat_khau, String dia_chi, boolean vai_tro, String hinh_anh, boolean trang_thai) {
        this.maNv = maNv;
        this.ho_ten = ho_ten;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
        this.sdt = sdt;
        this.mat_khau = mat_khau;
        this.dia_chi = dia_chi;
        this.vai_tro = vai_tro;
        this.hinh_anh = hinh_anh;
        this.trang_thai = trang_thai;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public boolean isGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public boolean isVai_tro() {
        return vai_tro;
    }

    public void setVai_tro(boolean vai_tro) {
        this.vai_tro = vai_tro;
    }

    public String getHinh_anh() {
        return hinh_anh;
    }

    public void setHinh_anh(String hinh_anh) {
        this.hinh_anh = hinh_anh;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
}
