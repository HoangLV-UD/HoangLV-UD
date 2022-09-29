/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.CTHoaDon;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceCTHoaDon {
    abstract public void insert(CTHoaDon ct);

    abstract public void update(CTHoaDon ct);

    abstract public void delete(String idHD, String idSP);

    abstract public List<CTHoaDon> selectAll();

    abstract public CTHoaDon selectID(String idHD, String idSP);

    abstract public List<CTHoaDon> selectBysql(String sql, Object... agrs);
}
