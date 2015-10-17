package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.MataPelajaranDao;
import id.ac.uad.plankton.model.MataPelajaran;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public class MataPelajaranDaoImpl implements MataPelajaranDao {
    private Connection connection;

    public MataPelajaranDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(MataPelajaran mataPelajaran) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mapel (kodeMapel, namaMapel,sks) VALUES (?,?,?)");
        preparedStatement.setInt(1, mataPelajaran.getKode());
        preparedStatement.setString(2, mataPelajaran.getNama());
        preparedStatement.setInt(3, mataPelajaran.getSks());

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(MataPelajaran updatedMataPelajaran) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mapel SET namaMapel=?,sks=? WHERE kodeMapel=?");
        preparedStatement.setString(1, updatedMataPelajaran.getNama());
        preparedStatement.setInt(2, updatedMataPelajaran.getSks());
        preparedStatement.setInt(3, updatedMataPelajaran.getKode());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int kode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mapel WHERE kodeMapel=?");
        preparedStatement.setInt(1, kode);
        preparedStatement.executeUpdate();

    }

    @Override
    public MataPelajaran findById(int kode) throws SQLException {
        MataPelajaran mataPelajaran = new MataPelajaran();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT namaMapel, sks FROM mapel WHERE kodeMapel=?");
            preparedStatement.setInt(1, kode);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                mataPelajaran.setNama(resultSet.getString("namaMapel"));
                mataPelajaran.setSks(resultSet.getInt("sks"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mataPelajaran;
    }

    @Override
    public List<MataPelajaran> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kodeMapel,namaMapel,sks FROM mapel");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<MataPelajaran> mataPelajaranList = new ArrayList<>();
            while (resultSet.next()) {
                MataPelajaran mataPelajaran = new MataPelajaran();

                mataPelajaran.setKode(resultSet.getInt("kodeMapel"));
                mataPelajaran.setNama(resultSet.getString("namaMapel"));
                mataPelajaran.setSks(resultSet.getInt("sks"));

                mataPelajaranList.add(mataPelajaran);
            }

            return mataPelajaranList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<MataPelajaran> findByNameLike(String nama) throws SQLException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kodeMapel,namaMapel,sks FROM mapel WHERE namaMapel=?");
            preparedStatement.setString(1, nama);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<MataPelajaran> mataPelajaranList = new ArrayList<>();
            while (resultSet.next()) {
                MataPelajaran mataPelajaran = new MataPelajaran();

                mataPelajaran.setKode(resultSet.getInt("kodeMapel"));
                mataPelajaran.setNama(resultSet.getString("namaMapel"));
                mataPelajaran.setSks(resultSet.getInt("sks"));

                mataPelajaranList.add(mataPelajaran);
            }

            return mataPelajaranList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
