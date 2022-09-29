/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.KhachHang;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhachHangDao implements  InterfaceKhachHang{
    private final String INSERT_SQL = "INSERT INTO KHACHHANG (MAKH, HOTEN, GIOITINH, NGAYSINH,EMAIL,SDT,TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE KHACHHANG SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?,EMAIL = ?,SDT = ?,TRANGTHAI = ? WHERE MAKH = ?";
    private final String DELETE_SQL = "DELETE FROM KHACHHANG WHERE MAKH = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM KHACHHANG WHERE MAKH = ?";
     private final String SELECT_BY_PHONE_SQL = "SELECT * FROM KHACHHANG WHERE SDT = ?";
    @Override
    public void insert(KhachHang kh) {
        JdbcHelper.update(INSERT_SQL,kh.getMaKh(),kh.getHoTen(),kh.isGioiTinh(),kh.getNgaySinh(),kh.getEmail(),kh.getPhone(),kh.isTrangThai());
    }
    @Override
    public void update(KhachHang kh) {
       JdbcHelper.update(UPDATE_SQL,kh.getHoTen(),kh.isGioiTinh(),kh.getNgaySinh(),kh.getEmail(),kh.getPhone(),kh.isTrangThai(),kh.getMaKh());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectID(String id) {
        List<KhachHang> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectBysql(String sql, Object... agrs) {
        List<KhachHang> list_khachhang = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                KhachHang kh = new KhachHang();                
                kh.setMaKh(rs.getString("MAKH"));
                kh.setHoTen(rs.getString("HOTEN"));
                kh.setNgaySinh(rs.getDate("NGAYSINH"));
                kh.setEmail(rs.getString("EMAIL"));
                kh.setPhone(rs.getString("SDT"));
                kh.setTrangThai(rs.getBoolean("TRANGTHAI"));   
                list_khachhang.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở daokh");
        }
        return list_khachhang;
    }

    @Override
    public KhachHang selectByPhone(String sdt) {
       List<KhachHang> list_sdt = selectBysql(SELECT_BY_PHONE_SQL, sdt);
        if (list_sdt.isEmpty()) {
            return null;
        }
        return list_sdt.get(0);
    }
    
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MAKH,3,LEN(MAKH))as int)) from  KHACHHANG";
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<KhachHang> selectByKeyword(String keyword){
        String sql = "SELECT * FROM KHACHHANG WHERE HOTEN LIKE ?";
        return selectBysql(sql, "%"+keyword+"%");
    }
}
