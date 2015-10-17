package id.ac.uad.plankton.model;

/**
 * Created by an on 13/10/15.
 */
public class Nilai {
    private int id;
    private MataPelajaran mataPelajaran;
    private Student student;
    private int nilai;

    public Nilai() {
    }

    public Nilai(int id, MataPelajaran mataPelajaran, Student student, int nilai) {
        this.id = id;
        this.mataPelajaran = mataPelajaran;
        this.student = student;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MataPelajaran getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(MataPelajaran mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
