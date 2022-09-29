/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDao implements InterfaceNhanVien{
    private final String INSERT_SQL = "INSERT INTO NHANVIEN (MANV, HOTEN, GIOITINH,NGAYSINH,EMAIL,SDT,MATKHAU,DIACHI,VAITRO,HINHANH,TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
    private final String UPDATE_SQL = "UPDATE NHANVIEN SET HOTEN = ?, GIOITINH = ?,NGAYSINH = ?,EMAIL = ?,SDT = ?,MATKHAU=?,DIACHI = ?,VAITRO = ?,HINHANH = ?,TRANGTHAI = ? WHERE MANV = ?";
    private final String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MANV = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MANV = ?";
    private final String SELECT_BY_PHONE_SQL = "SELECT * FROM NHANVIEN WHERE SDT = ?";
    private final String SELECT_BY_EMAIL_SQL = "SELECT * FROM NHANVIEN WHERE EMAIL = ?";
    
    @Override
    public void insert(NhanVien nv) {
        JdbcHelper.update(INSERT_SQL, nv.getMaNv(),nv.getHo_ten(),nv.isGioi_tinh(),nv.getNgay_sinh(),nv.getEmail(),nv.getSdt(),nv.getMat_khau(),nv.getDia_chi(),nv.isVai_tro(),nv.getHinh_anh(),nv.isTrang_thai());
    }

    @Override
    public void update(NhanVien nv) {
        JdbcHelper.update(UPDATE_SQL, nv.getHo_ten(),nv.isGioi_tinh(),nv.getNgay_sinh(),nv.getEmail(),nv.getSdt(),nv.getMat_khau(),nv.getDia_chi(),nv.isVai_tro(),nv.getHinh_anh(),nv.isTrang_thai(),nv.getMaNv());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectID(String id) {
        List<NhanVien> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBysql(String sql, Object... agrs) {
        List<NhanVien> list_nhanvien = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                NhanVien kh = new NhanVien();                
                kh.setMaNv(rs.getString("MANV"));
                kh.setHo_ten(rs.getString("HOTEN"));
                kh.setGioi_tinh(rs.getBoolean("GIOITINH"));
                kh.setNgay_sinh(rs.getDate("NGAYSINH"));
                kh.setEmail(rs.getString("EMAIL"));
                kh.setSdt(rs.getString("SDT"));
                kh.setMat_khau(rs.getString("MATKHAU"));
                kh.setVai_tro(rs.getBoolean("VAITRO"));
                kh.setHinh_anh(rs.getString("HINHANH"));
                kh.setTrang_thai(rs.getBoolean("TRANGTHAI"));   
                list_nhanvien.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở DAONV");
        }
        return list_nhanvien;
    }

    @Override
    public NhanVien selectByPhone(String sdt) {
        List<NhanVien> list = selectBysql(SELECT_BY_PHONE_SQL, sdt);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<NhanVien> selectByKeyword(String keyword){
        String sql = "SELECT * FROM NHANVIEN WHERE HOTEN LIKE ?";
        return selectBysql(sql, "%"+keyword+"%");
    }
    public List<NhanVien> selectTrangThai(int id){
        String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI = ?";
        return selectBysql(sql, id);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MANV,3,LEN(MANV))as int)) from  NHANVIEN";
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public NhanVien selectByEmail(String email) {
        List<NhanVien> list = selectBysql(SELECT_BY_EMAIL_SQL, email);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public void update_pass(NhanVien nv){
        String sql = "UPDATE NhanVien SET MATKHAU = ? WHERE MANV LIKE ?";
        JdbcHelper.update(sql,nv.getMat_khau(),nv.getMaNv());
    }
}
