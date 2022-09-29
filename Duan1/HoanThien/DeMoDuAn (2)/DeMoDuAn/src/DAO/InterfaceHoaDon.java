/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HoaDon;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceHoaDon {
    abstract public void insert(HoaDon hd);

    abstract public void update(HoaDon hd);

    abstract public void delete(String id);

    abstract public List<HoaDon> selectAll();

    abstract public HoaDon selectID(String id);

    abstract public List<HoaDon> selectBysql(String sql, Object... agrs);
    abstract public HoaDon selectPhone(String phone);
}
