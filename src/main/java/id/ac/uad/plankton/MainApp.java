package id.ac.uad.plankton;

import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.dao.impl.MataKuliahDaoImpl;
import id.ac.uad.plankton.dao.impl.NilaiDaoImpl;
import id.ac.uad.plankton.dao.impl.StudentDaoImpl;
import id.ac.uad.plankton.db.DatabaseConnection;
import id.ac.uad.plankton.model.Nilai;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by an on 07/10/15.
 */

public class MainApp {

    public static void main(String[] args) {


        //Student in = new Student(8, "Dani", "Jakarta");
        //Student up = new Student(2, "Bayu", "Lampung");

        //MataKuliah in = new MataKuliah(6, "B. Inggris", 3);
        //MataKuliah up = new MataKuliah(6, "B. Inggris", 2);


        //Nilai in = new Nilai(3,3,95);
        //Nilai up = new Nilai(2, 2, 95);

        try {
            StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());
            MataKuliahDaoImpl mataKuliahDao = new MataKuliahDaoImpl(DatabaseConnection.getInstance().getConnection());
            NilaiDao nilaiDao = new NilaiDaoImpl(DatabaseConnection.getInstance().getConnection());

            //studentDao.insert(in);
            //studentDao.update(up);
            //studentDao.delete(8);
            //System.out.println("Nama : " + studentDao.findById(1).getName());

            //mataKuliahDao.insert(in);
            //mataKuliahDao.update(up);
            //mataKuliahDao.delete(6);
            //System.out.println("MataKuliah : "+mataKuliahDao.findById(001).getNama());
            //System.out.println("SKS : " + mataKuliahDao.findById(001).getSks());

            //nilaiDao.insert(in);
            //nilaiDao.update(up);
            //nilaiDao.delete(002);
            //System.out.println("Kode MataKuliah : " + nilaiDao.findById(1).getMataKuliah().getKode());
            //System.out.println("Nilai : " + nilaiDao.findById(1).getNilai());


           /*List<Student> studentList = studentDao.findAll();

            for (Student s : studentList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Name    : " + s.getName());
                System.out.println("Address : " + s.getAddress());
                System.out.println("--------------------------");
            }*/


           /*List<MataKuliah> mapelList = mataKuliahDao.findAll();

            for (MataKuliah s : mapelList) {
                System.out.println("Kode MataKuliah      : " + s.getKode());
                System.out.println("Nama MataKuliah    : " + s.getNama());
                System.out.println("SKS : " + s.getSks());
                System.out.println("--------------------------");
            }*/


           List<Nilai> nilaiList = nilaiDao.findAll();

            for (Nilai s : nilaiList) {
                System.out.println("Id                 : " + s.getStudent().getId());
                System.out.println("Nama               : " + s.getStudent().getName());
                System.out.println("Kode MataKuliah    : " + s.getMataKuliah().getKode());
                System.out.println("Nilai              : " + s.getNilai());
                System.out.println("--------------------------");
            }

            /*List<Student> studentList = studentDao.findByNameLike("%waqid%");

            for (Student s : studentList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Name    : " + s.getName());
                System.out.println("Address : " + s.getAddress());
                System.out.println("--------------------------");
            }*/

            /*List<MataKuliah> mataPelajaranList = mataPelajaranDao.findByNameLike("%ddp%");

            for (MataKuliah s : mataPelajaranList) {
                System.out.println("Kode MataKuliah      : " + s.getKode());
                System.out.println("Nama MApel    : " + s.getNama());
                System.out.println("SKS : " + s.getSks());
                System.out.println("--------------------------");
            }*/



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
