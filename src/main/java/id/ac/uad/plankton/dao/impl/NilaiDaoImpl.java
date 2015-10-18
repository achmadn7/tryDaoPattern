package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.model.MataKuliah;
import id.ac.uad.plankton.model.Nilai;
import id.ac.uad.plankton.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 14/10/15.
 */
public class NilaiDaoImpl implements NilaiDao {

    private final Connection connection;

    public NilaiDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Nilai nilai) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO nilai (student_id, mata_kuliah_kode, nilai) VALUES (?,?,?)");
        preparedStatement.setInt(1,nilai.getStudent().getId());
        preparedStatement.setInt(2,nilai.getMataKuliah().getKode());
        preparedStatement.setInt(3, nilai.getNilai());

        preparedStatement.addBatch();

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Nilai updatedNilai) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE nilai SET mata_kuliah_kode=?,nilai=? WHERE student_id=?");
        preparedStatement.setInt(1, updatedNilai.getMataKuliah().getKode());
        preparedStatement.setInt(2, updatedNilai.getNilai());
        preparedStatement.setInt(3, updatedNilai.getId());

        preparedStatement.executeUpdate();

    }

    @Override
    public void delete(int id) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM nilai WHERE student_id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Nilai findById(int id) throws SQLException {
        Nilai nilai = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT mata_kuliah_kode, nilai FROM nilai WHERE student_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nilai = new Nilai();
                MataKuliah mataKuliah = new MataKuliah();
                mataKuliah.setKode(resultSet.getInt("mata_kuliah_kode"));
                nilai.setNilai(resultSet.getInt("nilai"));

                nilai.setMataKuliah(mataKuliah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilai;
    }

    @Override
    public List<Nilai> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT n.id,n.nilai,s.student_id as student_id, s.name as student_name, mk.namaKuliah as matakuliah_name, mk.mata_kuliah_kode, mk.Sks FROM nilai n\n" +
                    "  INNER JOIN matakuliah mk ON mk.mata_kuliah_kode = n.mata_kuliah_kode\n" +
                    "  INNER JOIN student s ON s.student_id = n.student_id");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Nilai>nilaiList = new ArrayList<>();
            while (resultSet.next()){
                Student s = new Student();
                MataKuliah mk = new MataKuliah();
                Nilai n = new Nilai();

                s.setId(resultSet.getInt("student_id"));
                s.setName(resultSet.getString("student_name"));
                mk.setNama(resultSet.getString("matakuliah_name"));
                mk.setKode(resultSet.getInt("mata_kuliah_kode"));
                mk.setSks(resultSet.getInt("Sks"));
                n.setId(resultSet.getInt("id"));
                n.setNilai(resultSet.getInt("nilai"));

                n.setStudent(s);
                n.setMataKuliah(mk);
                nilaiList.add(n);
            }

            return nilaiList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
