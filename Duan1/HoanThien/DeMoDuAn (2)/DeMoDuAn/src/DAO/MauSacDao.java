/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.MauSac;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class MauSacDao implements MauSacInterface{
    private final String INSERT_SQL = "INSERT INTO MAUSAC (MAMAU,TENMAU,TRANGTHAI) VALUES (?, ?,?)";
    private final String UPDATE_SQL = "UPDATE DANHMUC SET TENMAU = ?, TRANGTHAI = ? WHERE MAMAU =?" ;
    private final String DELETE_SQL = "DELETE FROM MAUSAC WHERE MAMAU = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM MAUSAC";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM MAUSAC WHERE MAMAU = ?";
    @Override
    public void insert(MauSac ms) {
        JdbcHelper.update(INSERT_SQL, ms.getMaMau(),ms.getTenMau(),ms.isTrangThai());
    }

    @Override
    public void update(MauSac ms) {
        JdbcHelper.update(UPDATE_SQL,ms.getTenMau(),ms.isTrangThai(), ms.getMaMau());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<MauSac> selectAll() {
       return  selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public MauSac selectID(String id) {
        List<MauSac> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<MauSac> selectBysql(String sql, Object... agrs) {
        List<MauSac> list_mau = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                MauSac ms = new MauSac();
                ms.setMaMau(rs.getString("MAMAU"));
                ms.setTenMau(rs.getString("TENMAU"));
                ms.setTrangThai(rs.getBoolean("TRANGTHAI"));
                    
                list_mau.add(ms);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return list_mau;
    }
    public MauSac selectTenMau(String tenMau) {
        String sql = "SELECT * FROM MAUSAC WHERE TENMAU LIKE ?";
        List<MauSac> list = selectBysql(sql, tenMau);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
   public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MAMAU,3,LEN(MAMAU))as int)) from  MAUSAC";
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
