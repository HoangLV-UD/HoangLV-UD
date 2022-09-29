/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.MauSac;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface MauSacInterface {
    abstract public void insert(MauSac ms);

    abstract public void update(MauSac ms);

    abstract public void delete(String id);

    abstract public List<MauSac> selectAll();

    abstract public MauSac selectID(String id);

    abstract public List<MauSac> selectBysql(String sql, Object... agrs);
}
