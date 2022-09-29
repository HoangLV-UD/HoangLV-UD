/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.SanPham;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SanPhamDao implements InterfaceSanPham{
    private final String INSERT_SQL = "INSERT INTO CTSANPHAM (MASP, MALH, MASIZE, MAMAU,MADV ,MADM,DONGIA,SOLUONG,TRANGTHAI,GHICHU) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE CTSANPHAM SET MALH = ?, MASIZE = ?, MAMAU = ?, MADV = ?, MADM = ?,DONGIA = ?,SOLUONG = ?,TRANGTHAI = ?,GHICHU = ? WHERE MASP = ?";
    private final String DELETE_SQL = "DELETE FROM CTSANPHAM WHERE MASP = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM CTSANPHAM";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM CTSANPHAM WHERE MASP = ?";

    @Override
    public void insert(SanPham sp) {  
        JdbcHelper.update(INSERT_SQL, sp.getMaSp(),sp.getMaLH(),sp.getMaSize(),sp.getMaMau(),sp.getMaDv(),sp.getMaDm(),sp.getDonGia(),
                sp.getSoLuong(),sp.isTrangThai(),sp.getGhiChu());
    }

    @Override
    public void update(SanPham sp) {
       JdbcHelper.update(INSERT_SQL,sp.getMaLH(),sp.getMaSize(),sp.getMaMau(),sp.getMaDv(),sp.getMaDm(),sp.getDonGia(),
                sp.getSoLuong(),sp.isTrangThai(),sp.getGhiChu(), sp.getMaSp());
    }

    @Override
    public void delete(String id) {
       JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectID(String id) {
        List<SanPham> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectBysql(String sql, Object... agrs) {
       List<SanPham> list_sanpham = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("MASP"));
                sp.setMaLH(rs.getString("MALH"));
                sp.setMaSize(rs.getString("MASIZE"));
                sp.setMaMau(rs.getString("MAMAU"));
                sp.setMaDv(rs.getString("MADV"));
                sp.setMaDm(rs.getString("MADM"));
                sp.setDonGia(rs.getFloat("DONGIA"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
                sp.setTrangThai(rs.getBoolean("TRANGTHAI"));
                sp.setGhiChu(rs.getString("GHICHU"));    
                list_sanpham.add(sp);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở Dao san pham");
        }
        return list_sanpham;
    }
    public List<SanPham> selectByKeyword(String keyword){
        String sql = "SELECT * FROM CTSANPHAM WHERE MADM LIKE ?";
        return selectBysql(sql, "%"+keyword+"%");
    }
    public List<SanPham> selectByTenDanhMuc(String keyword){
        String sql = " SELECT *FROM CTSANPHAM WHERE MASP IN (SELECT MASP FROM CTSANPHAM INNER JOIN DANHMUC ON CTSANPHAM.MADM = DANHMUC.MADM WHERE TENDM LIKE ?)";
        return selectBysql(sql, "%"+keyword+"%");
    }
     public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MASP,3,LEN(MASP))as int)) from  CTSANPHAM";
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
