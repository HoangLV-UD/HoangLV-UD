/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DanhMuc;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceDanhMuc {
    abstract public void insert(DanhMuc dm);

    abstract public void update(DanhMuc dm);

    abstract public void delete(String id);

    abstract public List<DanhMuc> selectAll();

    abstract public DanhMuc selectID(String id);

    abstract public List<DanhMuc> selectBysql(String sql, Object... agrs);
}
