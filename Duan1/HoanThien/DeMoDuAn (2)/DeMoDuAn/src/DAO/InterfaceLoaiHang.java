/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.LoaiHang;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceLoaiHang {
    abstract public void insert(LoaiHang lm);

    abstract public void update(LoaiHang lm);

    abstract public void delete(String id);

    abstract public List<LoaiHang> selectAll();

    abstract public LoaiHang selectID(String id);

    abstract public List<LoaiHang> selectBysql(String sql, Object... agrs);
}
