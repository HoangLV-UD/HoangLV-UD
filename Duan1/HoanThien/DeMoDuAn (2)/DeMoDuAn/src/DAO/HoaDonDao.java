/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HoaDon;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonDao implements InterfaceHoaDon{
    private final String INSERT_SQL = "INSERT INTO HOADON (MAHD,MAKH,TENKH,SDT, MANV, NGAYTAO, TRANGTHAI, HTTHANHTOAN,TIENSHIP,TONGTIEN,DIACHI,GHICHU) VALUES (?, ?,? ,?, ?, ?, ?, ?, ?, ?,?,?)";
    private final String UPDATE_SQL = "UPDATE HOADON SET MAKH = ?, TENKH = ?, SDT = ?, MANV = ?, NGAYTAO = ?, TRANGTHAI = ?, HTTHANHTOAN = ?,TIENSHIP = ?,TONGTIEN = ?,DIACHI = ?,GHICHU = ? WHERE MAHD = ?";
    private final String DELETE_SQL = "DELETE FROM HOADON WHERE MAKH = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM HOADON";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM HOADON WHERE MAHD = ?";
    private final String SELECT_BY_PHONE_SQL = "SELECT * FROM HOADON WHERE SDT = ?";
    @Override
    public void insert(HoaDon kh) {
        JdbcHelper.update(INSERT_SQL, kh.getMaHd(),kh.getMaKh(),kh.getHo_tenkh(),kh.getSdt_kh(),kh.getMaNv(),kh.getNgayTao(),kh.getTrangThai(),kh.isHtThanhToan(),
                kh.getTienShip(),kh.getTongTien(),kh.getDiaChi(),kh.getGhiChu());
    }

    @Override
    public void update(HoaDon kh) {
        JdbcHelper.update(UPDATE_SQL,kh.getMaKh(),kh.getHo_tenkh(),kh.getSdt_kh(),kh.getMaNv(),kh.getNgayTao(),kh.getTrangThai(),kh.isHtThanhToan(),
                kh.getTienShip(),kh.getTongTien(),kh.getDiaChi(),kh.getGhiChu(), kh.getMaHd());
    }

    @Override
    public void delete(String kh) {
        JdbcHelper.update(DELETE_SQL, kh);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectID(String kh) {
       List<HoaDon> list = selectBysql(SELECT_BY_ID_SQL, kh);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBysql(String sql, Object... agrs) {
        List<HoaDon> list_hoadon = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                HoaDon hd = new HoaDon();
                  hd.setMaHd(rs.getString("MAHD"));
                  hd.setMaKh(rs.getString("MAKH"));
                  hd.setHo_tenkh(rs.getString("TENKH"));
                  hd.setSdt_kh(rs.getString("SDT"));
                  hd.setMaNv(rs.getString("MANV"));
                  hd.setNgayTao(rs.getDate("NGAYTAO"));
                  hd.setTrangThai(rs.getInt("TRANGTHAI"));
                  hd.setHtThanhToan(rs.getBoolean("HTTHANHTOAN"));                 
                  hd.setTienShip(rs.getFloat("TIENSHIP"));
                  hd.setTongTien(rs.getFloat("TONGTIEN"));
                  hd.setDiaChi(rs.getString("DIACHI"));
                  hd.setGhiChu(rs.getString("GHICHU"));
                list_hoadon.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở daohoadon");
        }
        return list_hoadon;
    }
    @Override
    public HoaDon selectPhone(String phone) {
       List<HoaDon> list = selectBysql(SELECT_BY_PHONE_SQL, phone);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MAHD,3,LEN(MAHD))as int)) from  HOADON";
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<HoaDon> selectByTrangThai(int keyword){
        String sql = "SELECT * FROM HOADON WHERE TRANGTHAI LIKE ?";
        return selectBysql(sql, keyword);
    }
    public void update_TT(HoaDon hd){
        String sql = "UPDATE HOADON SET TRANGTHAI = ? WHERE MAHD LIKE ?";
        JdbcHelper.update(sql,hd.getTrangThai(),hd.getMaHd());
    }
    public List<HoaDon> selectByMAHD(String keyword){
        String sql = "SELECT * FROM HOADON WHERE MAHD LIKE ?";
        return selectBysql(sql, keyword);
    }
    
}
