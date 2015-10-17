package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.Nilai;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public interface NilaiDao {

    void insert(Nilai nilai) throws SQLException;

    void update(Nilai updatedNilai) throws SQLException;

    void delete(int id) throws SQLException;

    Nilai findById(int id) throws SQLException;

    List<Nilai> findAll();

}
