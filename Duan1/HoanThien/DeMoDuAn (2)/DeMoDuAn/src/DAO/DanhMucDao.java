/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DanhMuc;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DanhMucDao implements InterfaceDanhMuc{
     private final String INSERT_SQL = "INSERT INTO DANHMUC (MADM,TENDM,MANCC,TRANGTHAI) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE DANHMUC SET TENDM = ?, MANCC = ?, TRANGTHAI = ? WHERE MADM =?" ;
    private final String DELETE_SQL = "DELETE FROM DANHMUC WHERE MADM = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM DANHMUC";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM DANHMUC WHERE MADM = ?";
    @Override
    public void insert(DanhMuc dm) {
        JdbcHelper.update(INSERT_SQL, dm.getMaDm(), dm.getTenDm(), dm.getMaNcc(), dm.isTrangThai());
    }

    @Override
    public void update(DanhMuc dm) {
        JdbcHelper.update(UPDATE_SQL, dm.getTenDm(), dm.getMaNcc(), dm.isTrangThai(), dm.getMaDm());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<DanhMuc> selectAll() {
        return  selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public DanhMuc selectID(String id) {
        List<DanhMuc> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DanhMuc> selectBysql(String sql, Object... agrs) {
       List<DanhMuc> list_dm = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                DanhMuc dm = new DanhMuc();
                dm.setMaDm(rs.getString("MADM"));
                dm.setTenDm(rs.getString("TENDM"));
                dm.setMaNcc(rs.getString("MANCC"));
                dm.setTrangThai(rs.getBoolean("TRANGTHAI"));
                    
                list_dm.add(dm);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return list_dm;
    }
    public List<DanhMuc> selectByKeyword(String keyword){
        String sql = "SELECT * FROM DANHMUC WHERE TENDM LIKE ?";
        return selectBysql(sql, "%"+keyword+"%");
    }
    public DanhMuc selectTenDM(String tenDM) {
        String sql = "SELECT * FROM DANHMUC WHERE TENDM LIKE ?";
        List<DanhMuc> list = selectBysql(sql, tenDM);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MADM,3,LEN(MADM))as int)) from DANHMUC";
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
