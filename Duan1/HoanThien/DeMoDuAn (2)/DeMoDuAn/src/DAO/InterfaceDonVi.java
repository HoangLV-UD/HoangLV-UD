/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.DonVi;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceDonVi {
    abstract public void insert(DonVi dv);

    abstract public void update(DonVi dv);

    abstract public void delete(String dv);

    abstract public List<DonVi> selectAll();

    abstract public DonVi selectID(String dv);

    abstract public List<DonVi> selectBysql(String sql, Object... agrs);
}
