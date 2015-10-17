package id.ac.uad.plankton.dao;

import id.ac.uad.plankton.model.MataPelajaran;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public interface MataPelajaranDao {
    void insert(MataPelajaran mataPelajaran) throws SQLException;

    void update(MataPelajaran updateMataPelajaran) throws SQLException;

    void delete(int kode) throws SQLException;

    MataPelajaran findById(int kode) throws SQLException;

    List<MataPelajaran> findAll();

    List<MataPelajaran> findByNameLike(String nama) throws SQLException;
}
