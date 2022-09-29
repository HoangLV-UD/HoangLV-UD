/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceNhanVien {
   abstract public void insert(NhanVien nv);

    abstract public void update(NhanVien nv);

    abstract public void delete(String id);

    abstract public List<NhanVien> selectAll();

    abstract public NhanVien selectID(String id);
    abstract public NhanVien selectByPhone(String sdt);
    abstract public NhanVien selectByEmail(String email);

    abstract public List<NhanVien> selectBysql(String sql, Object... agrs); 
}
