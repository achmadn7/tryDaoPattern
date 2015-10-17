package id.ac.uad.plankton.dao.impl;

import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by an on 07/10/15.
 */

public class StudentDaoImpl implements StudentDao {

    private final Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Student student) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, name,address) VALUES (?,?,?)");
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getAddress());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Student updatedStudent) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name=?,address=? WHERE id=?");
        preparedStatement.setString(1, updatedStudent.getName());
        preparedStatement.setString(2, updatedStudent.getAddress());
        preparedStatement.setInt(3, updatedStudent.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }

    @Override
    public Student findById(int id) throws SQLException {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, address FROM student WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setName(resultSet.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,address AS alamat FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("alamat"));

                studentList.add(student);
            }

            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Student> findByNameLike(String name) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,name,address FROM student WHERE name=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));

                studentList.add(student);
            }

            return studentList;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}