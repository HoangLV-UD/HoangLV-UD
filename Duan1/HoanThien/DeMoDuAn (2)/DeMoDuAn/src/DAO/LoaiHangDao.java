/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LoaiHang;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoaiHangDao implements InterfaceLoaiHang{
     private final String INSERT_SQL = "INSERT INTO LOAIHANG (MALH,TENLH,TRANGTHAI) VALUES (?, ?,?)";
    private final String UPDATE_SQL = "UPDATE LOAIHANG SET TENLH = ?, TRANGTHAI = ? WHERE MALH =?" ;
    private final String DELETE_SQL = "DELETE FROM LOẠIHANG WHERE MALH = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM LOAIHANG";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM LOAIHANG WHERE MALH = ?";

    @Override
    public void insert(LoaiHang lm) {
       JdbcHelper.update(INSERT_SQL, lm.getMaLoai(), lm.getTenLoai(), lm.isTrangThai());
    }

    @Override
    public void update(LoaiHang lm) {
        JdbcHelper.update(UPDATE_SQL, lm.getTenLoai(), lm.isTrangThai(), lm.getMaLoai());
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<LoaiHang> selectAll() {
        return  selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiHang selectID(String id) {
        List<LoaiHang> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<LoaiHang> selectBysql(String sql, Object... agrs) {
        List<LoaiHang> list_lh = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                LoaiHang lh = new LoaiHang();
                lh.setMaLoai(rs.getString("MALH"));
                lh.setTenLoai(rs.getString("TENLH"));
                lh.setTrangThai(rs.getBoolean("TRANGTHAI"));
                    
                list_lh.add(lh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return list_lh;
    }
    public LoaiHang selectTenLH(String tenDM) {
        String sql = "SELECT * FROM LOAIHANG WHERE TENLH LIKE ?";
        List<LoaiHang> list = selectBysql(sql, tenDM);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MALH,3,LEN(MALH))as int)) from LOAIHANG";
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
