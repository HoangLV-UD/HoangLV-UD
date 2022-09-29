/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DonVi;
import Entity.Size;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DonViDao implements InterfaceDonVi{
     private final String INSERT_SQL = "INSERT INTO DONVI (MADV,TENDV,TRANGTHAI) VALUES (?, ?,?)";
    private final String UPDATE_SQL = "UPDATE DANHMUC SET TENDV = ?, TRANGTHAI = ? WHERE MADV =?" ;
    private final String DELETE_SQL = "DELETE FROM DONVI WHERE MADV = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM DONVI";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM DONVI WHERE MADV = ?";
    @Override
    public void insert(DonVi dv) {
       JdbcHelper.update(INSERT_SQL, dv.getMaDon_vi(),dv.getTenDon_vi(), dv.isTrangThai());
       
    }

    @Override
    public void update(DonVi dv) {
        JdbcHelper.update(UPDATE_SQL, dv.getTenDon_vi(), dv.isTrangThai(), dv.getMaDon_vi());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<DonVi> selectAll() {
         return selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public DonVi selectID(String dv) {
        List<DonVi> list = selectBysql(SELECT_BY_ID_SQL, dv);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DonVi> selectBysql(String sql, Object... agrs) {
        List<DonVi> list_donvi = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                DonVi kt = new DonVi();
                kt.setMaDon_vi(rs.getString("MADV"));
                kt.setTenDon_vi(rs.getString("TENDV"));
                kt.setTrangThai(rs.getBoolean("TRANGTHAI"));                   
                list_donvi.add(kt);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return list_donvi;
    }

    public DonVi selectTenDV(String tenDv) {
        String sql = "SELECT * FROM DONVI WHERE TENDV LIKE ?";
        List<DonVi> list = selectBysql(sql, tenDv);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MADV,3,LEN(MADV))as int)) from DONVI";
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
