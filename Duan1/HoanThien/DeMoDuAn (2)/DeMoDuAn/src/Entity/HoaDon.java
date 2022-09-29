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
public class HoaDon {
    private String maHd;
    private String maKh;
    private String maNv;
    private String ho_tenkh;
    private String sdt_kh;
    private Date ngayTao;
    private int trangThai;
    private boolean htThanhToan;    
    private float tienShip;
    private float tongTien;
    private String diaChi;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(String maHd, String maKh, String maNv, String ho_tenkh, String sdt_kh, Date ngayTao, int trangThai, boolean htThanhToan, float tienShip, float tongTien, String diaChi, String ghiChu) {
        this.maHd = maHd;
        this.maKh = maKh;
        this.maNv = maNv;
        this.ho_tenkh = ho_tenkh;
        this.sdt_kh = sdt_kh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.htThanhToan = htThanhToan;
        this.tienShip = tienShip;
        this.tongTien = tongTien;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getHo_tenkh() {
        return ho_tenkh;
    }

    public void setHo_tenkh(String ho_tenkh) {
        this.ho_tenkh = ho_tenkh;
    }

    public String getSdt_kh() {
        return sdt_kh;
    }

    public void setSdt_kh(String sdt_kh) {
        this.sdt_kh = sdt_kh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isHtThanhToan() {
        return htThanhToan;
    }

    public void setHtThanhToan(boolean htThanhToan) {
        this.htThanhToan = htThanhToan;
    }

    public float getTienShip() {
        return tienShip;
    }

    public void setTienShip(float tienShip) {
        this.tienShip = tienShip;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
    
}
