/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Size;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SizeDao implements InterfaceSize{
    private final String INSERT_SQL = "INSERT INTO SIZE (MASIZE,TENSIZE,TRANGTHAI) VALUES (?, ?,?)";
    private final String UPDATE_SQL = "UPDATE SIZE SET TENSIZE = ?, TRANGTHAI = ? WHERE MASIZE =?" ;
    private final String DELETE_SQL = "DELETE FROM SIZE WHERE MASIZE = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM SIZE";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM SIZE WHERE MASIZE = ?";
    @Override
    public void insert(Size kt) {
         JdbcHelper.update(INSERT_SQL, kt.getMaSize(),kt.getTenSize(),kt.isTrangThai());
    }

    @Override
    public void update(Size kt) {
        JdbcHelper.update(UPDATE_SQL, kt.getTenSize(),kt.isTrangThai(), kt.getMaSize());
    }

    @Override
    public void delete(String id) {
         JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<Size> selectAll() {
       return  selectBysql(SELECT_ALL_SQL);
    }

    @Override
    public Size selectID(String id) {
        List<Size> list = selectBysql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Size> selectBysql(String sql, Object... agrs) {
        List<Size> list_size = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                Size kt = new Size();
                kt.setMaSize(rs.getString("MASIZE"));
                kt.setTenSize(rs.getString("TENSIZE"));
                kt.setTrangThai(rs.getBoolean("TRANGTHAI"));
                    
                list_size.add(kt);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return list_size;
    }
    public Size selectTenSize(String tenSize) {
        String sql = "SELECT * FROM SIZE WHERE TENSIZE LIKE ?";
        List<Size> list = selectBysql(sql, tenSize);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(MASIZE,2,LEN(MASIZE))as int)) from  SIZE";
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
