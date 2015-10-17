package id.ac.uad.plankton.model;

/**
 * Created by an on 13/10/15.
 */
public class MataPelajaran {
    private int kode;
    private String nama;
    private int sks;

    public MataPelajaran() {
    }

    public MataPelajaran(int kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
