package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.Mapel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public interface MapelDao {
    void insert(Mapel mapel) throws SQLException;

    void update(Mapel updateMapel) throws SQLException;

    void delete(int kode) throws SQLException;

    Mapel findById(int kode) throws SQLException;

    List<Mapel> findAll();

    List<Mapel> findByNameLike(String nama) throws SQLException;
}
