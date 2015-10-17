package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.MapelDao;
import id.ac.uad.plankton.model.Mapel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 13/10/15.
 */
public class MapelDaoImpl implements MapelDao {
    private Connection connection;

    public MapelDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Mapel mapel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mapel (kodeMapel, namaMapel,sks) VALUES (?,?,?)");
        preparedStatement.setInt(1, mapel.getKode());
        preparedStatement.setString(2, mapel.getNama());
        preparedStatement.setInt(3, mapel.getSks());

        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Mapel updatedMapel) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE mapel SET namaMapel=?,sks=? WHERE kodeMapel=?");
        preparedStatement.setString(1, updatedMapel.getNama());
        preparedStatement.setInt(2, updatedMapel.getSks());
        preparedStatement.setInt(3, updatedMapel.getKode());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int kode) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mapel WHERE kodeMapel=?");
        preparedStatement.setInt(1, kode);
        preparedStatement.executeUpdate();

    }

    @Override
    public Mapel findById(int kode) throws SQLException {
        Mapel mapel = new Mapel();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT namaMapel, sks FROM mapel WHERE kodeMapel=?");
            preparedStatement.setInt(1, kode);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                mapel.setNama(resultSet.getString("namaMapel"));
                mapel.setSks(resultSet.getInt("sks"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapel;
    }

    @Override
    public List<Mapel> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kodeMapel,namaMapel,sks FROM mapel");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Mapel> mapelList = new ArrayList<>();
            while (resultSet.next()) {
                Mapel mapel = new Mapel();

                mapel.setKode(resultSet.getInt("kodeMapel"));
                mapel.setNama(resultSet.getString("namaMapel"));
                mapel.setSks(resultSet.getInt("sks"));

                mapelList.add(mapel);
            }

            return mapelList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Mapel> findByNameLike(String nama) throws SQLException {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT kodeMapel,namaMapel,sks FROM mapel WHERE namaMapel=?");
            preparedStatement.setString(1, nama);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Mapel> mapelList = new ArrayList<>();
            while (resultSet.next()) {
                Mapel mapel = new Mapel();

                mapel.setKode(resultSet.getInt("kodeMapel"));
                mapel.setNama(resultSet.getString("namaMapel"));
                mapel.setSks(resultSet.getInt("sks"));

                mapelList.add(mapel);
            }

            return mapelList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
