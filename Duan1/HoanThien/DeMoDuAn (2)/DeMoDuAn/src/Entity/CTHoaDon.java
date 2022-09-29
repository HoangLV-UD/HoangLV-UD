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
public class CTHoaDon {
    private String ma_hoadon;
    private String ma_sanpham;
    private int so_luong;
    private String donVi;
    private Float don_gia;
    private Float thanh_tien;
    private boolean trang_thai;
    private String ghi_chu;

    public CTHoaDon() {
    }

    public CTHoaDon(String ma_hoadon, String ma_sanpham, int so_luong, String donVi, Float don_gia, Float thanh_tien, boolean trang_thai, String ghi_chu) {
        this.ma_hoadon = ma_hoadon;
        this.ma_sanpham = ma_sanpham;
        this.so_luong = so_luong;
        this.donVi = donVi;
        this.don_gia = don_gia;
        this.thanh_tien = thanh_tien;
        this.trang_thai = trang_thai;
        this.ghi_chu = ghi_chu;
    }

    public String getMa_hoadon() {
        return ma_hoadon;
    }

    public void setMa_hoadon(String ma_hoadon) {
        this.ma_hoadon = ma_hoadon;
    }

    public String getMa_sanpham() {
        return ma_sanpham;
    }

    public void setMa_sanpham(String ma_sanpham) {
        this.ma_sanpham = ma_sanpham;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Float getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(Float don_gia) {
        this.don_gia = don_gia;
    }

    public Float getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(Float thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
    
}
