package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.MataKuliah;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public interface MataKuliahDao {
    void insert(MataKuliah mataKuliah) throws SQLException;

    void update(MataKuliah updateMataKuliah) throws SQLException;

    void delete(int kode) throws SQLException;

    MataKuliah findById(int kode) throws SQLException;

    List<MataKuliah> findAll();

    List<MataKuliah> findByNameLike(String nama) throws SQLException;
}
