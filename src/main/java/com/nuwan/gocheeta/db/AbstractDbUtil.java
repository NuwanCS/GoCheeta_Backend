package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.BaseEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nuwan
 * @param <T>
 */
public interface AbstractDbUtil<T extends BaseEntity> {
    
    T getOne(Long id) throws SQLException;

    List<T> getAll() throws SQLException;

    boolean add(T t) throws SQLException;

    boolean delete(Long id) throws SQLException;

    boolean update(T t) throws SQLException;
    
}
