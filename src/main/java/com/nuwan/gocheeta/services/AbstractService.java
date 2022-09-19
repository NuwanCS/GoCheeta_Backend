package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.model.BaseEntity;
import com.nuwan.gocheeta.model.City;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nuwan
 * @param <T>
 */
public abstract class AbstractService<T extends BaseEntity> {
    
    private final AbstractDbUtil utils;

    public AbstractService(AbstractDbUtil utils) {
        this.utils = utils;
    }  
    

    public T getOne(Long id) throws SQLException{
        return (T) utils.getOne(id);
    }

    public List<T> getAll() throws SQLException{
        return utils.getAll();
    }

    public boolean add(T t) throws SQLException{
        return utils.add(t);
    }

    public boolean delete(Long id) throws SQLException{
        return utils.delete(id);
    }


    public boolean update(T t) throws SQLException{
        return utils.update(t);
    }

    public boolean login(City student) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

