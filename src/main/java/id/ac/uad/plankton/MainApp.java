package id.ac.uad.plankton;

import id.ac.uad.plankton.dao.MapelDao;
import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.dao.impl.MapelDaoImpl;
import id.ac.uad.plankton.dao.impl.NilaiDaoImpl;
import id.ac.uad.plankton.dao.impl.StudentDaoImpl;
import id.ac.uad.plankton.db.DatabaseConnection;

import java.sql.SQLException;

/**
 * Created by an on 07/10/15.
 */

public class MainApp {

    public static void main(String[] args) {


        //Student in = new Student(7, "Bowo", "Palm");
        //Student up = new Student(6, "Gladis", "Malang");

        //Mapel in = new Mapel(004, "DDP", 3);
        //Mapel up = new Mapel(004, "DDP", 2);


        //Nilai in = new Nilai(2, 002, 90);
        //Nilai up = new Nilai(2, 002, 95);

        try {
            StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());
            MapelDao mapelDao = new MapelDaoImpl(DatabaseConnection.getInstance().getConnection());
            NilaiDao nilaiDao = new NilaiDaoImpl(DatabaseConnection.getInstance().getConnection());

            //studentDao.insert(in);
            //studentDao.update(up);
            //studentDao.delete(6);
            //System.out.println("Nama : " + studentDao.findById(3).getName());

            //mapelDao.insert(in);
            //mapelDao.update(up);
            //mapelDao.delete(002);
            //System.out.println("Mapel : "+mapelDao.findById(001).getNama());
            //System.out.println("SKS : " + mapelDao.findById(001).getSks());

            //nilaiDao.insert(in);
            //nilaiDao.update(up);
            //nilaiDao.delete(002);
            //System.out.println("Kode Mapel : " + nilaiDao.findById(001).getKode());
            //System.out.println("Nilai : " + nilaiDao.findById(001).getNilai());


           /*List<Student> studentList = studentDao.findAll();

            for (Student s : studentList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Name    : " + s.getName());
                System.out.println("Address : " + s.getAddress());
                System.out.println("--------------------------");
            }*/


           /*List<Mapel> mapelList = mapelDao.findAll();

            for (Mapel s : mapelList) {
                System.out.println("Kode Mapel      : " + s.getKodeMapel());
                System.out.println("Nama Mapel    : " + s.getNamaMapel());
                System.out.println("SKS : " + s.getSks());
                System.out.println("--------------------------");
            }*/


           /* List<Nilai> nilaiList = nilaiDao.findAll();

            for (Nilai s : nilaiList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Kode Mapel    : " + s.getKodeMapel());
                System.out.println("Nilai : " + s.getNilai());
                System.out.println("--------------------------");
            }*/

            /*List<Student> studentList = studentDao.findByNameLike("%waqid%");

            for (Student s : studentList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Name    : " + s.getName());
                System.out.println("Address : " + s.getAddress());
                System.out.println("--------------------------");
            }*/

            /*List<Mapel> mapelList = mapelDao.findByNameLike("%ddp%");

            for (Mapel s : mapelList) {
                System.out.println("Kode Mapel      : " + s.getKode());
                System.out.println("Nama MApel    : " + s.getNama());
                System.out.println("SKS : " + s.getSks());
                System.out.println("--------------------------");
            }*/



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
