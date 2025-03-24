public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenis_kelamin;
    private String statusMahasiswa;

    public Mahasiswa(String nim, String nama, String jenis_kelamin, String statusMahasiswa) {
        this.nim = nim;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.statusMahasiswa = statusMahasiswa;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setStatusMahasiswa(String statusMahasiswa) { this.statusMahasiswa = statusMahasiswa; }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public String getJenisKelamin() {
        return this.jenis_kelamin;
    }

    public String getStatusMahasiswa() { return statusMahasiswa; }
}
