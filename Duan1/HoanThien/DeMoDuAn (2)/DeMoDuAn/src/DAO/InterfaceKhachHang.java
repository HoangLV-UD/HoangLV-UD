/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.KhachHang;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceKhachHang {
    abstract public void insert(KhachHang kh);

    abstract public void update(KhachHang kh);

    abstract public void delete(String id);

    abstract public List<KhachHang> selectAll();

    abstract public KhachHang selectID(String id);

    abstract public List<KhachHang> selectBysql(String sql, Object... agrs);
    abstract public KhachHang selectByPhone(String sdt);
}
