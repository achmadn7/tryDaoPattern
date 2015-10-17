package id.ac.uad.plankton;

import id.ac.uad.plankton.dao.MataPelajaranDao;
import id.ac.uad.plankton.dao.NilaiDao;
import id.ac.uad.plankton.dao.StudentDao;
import id.ac.uad.plankton.dao.impl.MataPelajaranDaoImpl;
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

        //MataPelajaran in = new MataPelajaran(004, "DDP", 3);
        //MataPelajaran up = new MataPelajaran(004, "DDP", 2);


        //Nilai in = new Nilai(2, 002, 90);
        //Nilai up = new Nilai(2, 002, 95);

        try {
            StudentDao studentDao = new StudentDaoImpl(DatabaseConnection.getInstance().getConnection());
            MataPelajaranDao mataPelajaranDao = new MataPelajaranDaoImpl(DatabaseConnection.getInstance().getConnection());
            NilaiDao nilaiDao = new NilaiDaoImpl(DatabaseConnection.getInstance().getConnection());

            //studentDao.insert(in);
            //studentDao.update(up);
            //studentDao.delete(6);
            //System.out.println("Nama : " + studentDao.findById(3).getName());

            //mataPelajaranDao.insert(in);
            //mataPelajaranDao.update(up);
            //mataPelajaranDao.delete(002);
            //System.out.println("MataPelajaran : "+mataPelajaranDao.findById(001).getNama());
            //System.out.println("SKS : " + mataPelajaranDao.findById(001).getSks());

            //nilaiDao.insert(in);
            //nilaiDao.update(up);
            //nilaiDao.delete(002);
            //System.out.println("Kode MataPelajaran : " + nilaiDao.findById(001).getKode());
            //System.out.println("Nilai : " + nilaiDao.findById(001).getNilai());


           /*List<Student> studentList = studentDao.findAll();

            for (Student s : studentList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Name    : " + s.getName());
                System.out.println("Address : " + s.getAddress());
                System.out.println("--------------------------");
            }*/


           /*List<MataPelajaran> mapelList = mataPelajaranDao.findAll();

            for (MataPelajaran s : mapelList) {
                System.out.println("Kode MataPelajaran      : " + s.getKodeMapel());
                System.out.println("Nama MataPelajaran    : " + s.getNamaMapel());
                System.out.println("SKS : " + s.getSks());
                System.out.println("--------------------------");
            }*/


           /* List<Nilai> nilaiList = nilaiDao.findAll();

            for (Nilai s : nilaiList) {
                System.out.println("Id      : " + s.getId());
                System.out.println("Kode MataPelajaran    : " + s.getKodeMapel());
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

            /*List<MataPelajaran> mataPelajaranList = mataPelajaranDao.findByNameLike("%ddp%");

            for (MataPelajaran s : mataPelajaranList) {
                System.out.println("Kode MataPelajaran      : " + s.getKode());
                System.out.println("Nama MApel    : " + s.getNama());
                System.out.println("SKS : " + s.getSks());
                System.out.println("--------------------------");
            }*/



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
