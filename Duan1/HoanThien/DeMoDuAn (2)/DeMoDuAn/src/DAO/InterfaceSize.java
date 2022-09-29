/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Size;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface InterfaceSize {
    abstract public void insert(Size kt);

    abstract public void update(Size kt);

    abstract public void delete(String id);

    abstract public List<Size> selectAll();

    abstract public Size selectID(String id);

    abstract public List<Size> selectBysql(String sql, Object... agrs);
}
