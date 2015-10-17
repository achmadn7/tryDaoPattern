package id.ac.uad.plankton.model;

/**
 * Created by an on 13/10/15.
 */
public class Nilai {
    private int id;
    private int kode;
    private int nilai;

    public Nilai() {
    }

    public Nilai(int id, int kode, int nilai) {
        this.id = id;
        this.kode = kode;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
