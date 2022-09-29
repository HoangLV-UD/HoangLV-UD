/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.CTHoaDon;
import JDBC.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CTHoaDonDao implements InterfaceCTHoaDon{
     private final String INSERT_SQL = "INSERT INTO CTHOADON (MAHD,MASP, SOLUONG, DONVI, DONGIA,THANHTIEN ,TRANGTHAI,GHICHU) VALUES (?, ?,?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE CTSANPHAM SET  SOLUONG = ?,DONGIA = ?,SOLUONG = ?,TRANGTHAI = ?,GHICHU = ? WHERE MAHD = ? AND MASP = ?";
    private final String DELETE_SQL = "DELETE FROM CTHOADON WHERE MASP = ? AND MAHD = ?";
    private final String SELECT_ALL_SQL = "SELECT * FROM CTHOADON";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM CTHOADON WHERE MASP = ? AND MAHD = ?";
    @Override
    public void insert(CTHoaDon ct) {
        JdbcHelper.update(INSERT_SQL, ct.getMa_hoadon(),ct.getMa_sanpham(),ct.getSo_luong(),ct.getDonVi(),
                ct.getDon_gia(),ct.getThanh_tien(),ct.isTrang_thai(),ct.getGhi_chu());
    }

    @Override
    public void update(CTHoaDon ct) {
       JdbcHelper.update(UPDATE_SQL,ct.getSo_luong(),ct.getDonVi(),
                ct.getDon_gia(),ct.getThanh_tien(),ct.isTrang_thai(),ct.getGhi_chu(), ct.getMa_hoadon(),ct.getMa_sanpham());
    }

    @Override
    public void delete(String idHD, String idSP) {
       JdbcHelper.update(DELETE_SQL, idHD,idSP);
    }

    @Override
    public List<CTHoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CTHoaDon selectID(String idHD, String idSP) {
       List<CTHoaDon> list = selectBysql(SELECT_BY_ID_SQL, idSP);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CTHoaDon> selectBysql(String sql, Object... agrs) {
        List<CTHoaDon> list_cthd = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, agrs);
            while(rs.next()){
                CTHoaDon ct = new CTHoaDon();
                ct.setMa_hoadon(rs.getString("MAHD"));
                ct.setMa_sanpham(rs.getString("MASP"));                
                ct.setDon_gia(rs.getFloat("DONGIA"));
                ct.setSo_luong(rs.getInt("SOLUONG"));
                ct.setDonVi(rs.getString("DONVI"));
                ct.setThanh_tien(rs.getFloat("THANHTIEN"));
                ct.setTrang_thai(rs.getBoolean("TRANGTHAI"));
                ct.setGhi_chu(rs.getString("GHICHU"));    
                list_cthd.add(ct);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở Dao CTHD");
        }
        return list_cthd;
    }
    public List<CTHoaDon> selectByIdHoaDon(String idHoaDon){
        String sql = "SELECT * FROM CTHOADON WHERE MAHD LIKE ?";
        return selectBysql(sql, idHoaDon);
    }
    public void deleteHD(String idHD) {
        String DELETE_SQL = "DELETE FROM CTHOADON WHERE MAHD = ?";
       JdbcHelper.update(DELETE_SQL, idHD);
    }
}
