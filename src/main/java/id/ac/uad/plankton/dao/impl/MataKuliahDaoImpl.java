package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.MataKuliahDao;
import id.ac.uad.plankton.model.MataKuliah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public class MataKuliahDaoImpl implements MataKuliahDao {
    private Connection connection;

    public MataKuliahDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(MataKuliah mataKuliah) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO matakuliah (mata_kuliah_kode, namaKuliah,sks) VALUES (?,?,?)");
        preparedStatement.setInt(1, mataKuliah.getKode());
        preparedStatement.setString(2, mataKuliah.getNama());
        preparedStatement.setInt(3, mataKuliah.getSks());

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(MataKuliah updatedMataKuliah) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE matakuliah SET namaKuliah=?,sks=? WHERE mata_kuliah_kode=?");
        preparedStatement.setString(1, updatedMataKuliah.getNama());
        preparedStatement.setInt(2, updatedMataKuliah.getSks());
        preparedStatement.setInt(3, updatedMataKuliah.getKode());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int kode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM matakuliah WHERE mata_kuliah_kode=?");
        preparedStatement.setInt(1, kode);
        preparedStatement.executeUpdate();

    }

    @Override
    public MataKuliah findById(int kode) throws SQLException {

        MataKuliah mataKuliah = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT namaKuliah, sks FROM matakuliah WHERE mata_kuliah_kode=?");
            preparedStatement.setInt(1, kode);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                mataKuliah = new MataKuliah();

                mataKuliah.setNama(resultSet.getString("namakuliah"));
                mataKuliah.setSks(resultSet.getInt("sks"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mataKuliah;
    }

    @Override
    public List<MataKuliah> findAll() {


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT mata_kuliah_kode,namaKuliah,sks FROM matakuliah");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (resultSet.next()) {
                MataKuliah mataKuliah = new MataKuliah();

                mataKuliah.setKode(resultSet.getInt("mata_kuliah_kode"));
                mataKuliah.setNama(resultSet.getString("namaKuliah"));
                mataKuliah.setSks(resultSet.getInt("sks"));

                mataKuliahList.add(mataKuliah);
            }

            return mataKuliahList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<MataKuliah> findByNameLike(String nama) throws SQLException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kodeMapel,namaMapel,sks FROM mapel WHERE namaMapel=?");
            preparedStatement.setString(1, nama);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<MataKuliah> mataKuliahList = new ArrayList<>();
            while (resultSet.next()) {
                MataKuliah mataKuliah = new MataKuliah();

                mataKuliah.setKode(resultSet.getInt("kodeMapel"));
                mataKuliah.setNama(resultSet.getString("namaMapel"));
                mataKuliah.setSks(resultSet.getInt("sks"));

                mataKuliahList.add(mataKuliah);
            }

            return mataKuliahList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
