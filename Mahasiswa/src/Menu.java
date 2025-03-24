import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(480, 560);

        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // isi window
        window.setContentPane(window.mainPanel);
        // ubah warna background
        window.getContentPane().setBackground(Color.white);

        // tampilkan window
        window.setVisible(true);

        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    private Database database;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel statusLabel;
    private JRadioButton aktifRadioButton;
    private JRadioButton nonAktifRadioButton;
    private ButtonGroup bgStatus;


    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();

        database = new Database();

        // isi listMahasiswa
        populateList();
        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());
        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));
        // atur isi combo box
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));

        bgStatus = new ButtonGroup();
        bgStatus.add(aktifRadioButton);
        bgStatus.add(nonAktifRadioButton);

        // sembunyikan button delete
        deleteButton.setVisible(false);
        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });
        // saat tombol delete ditekan
        deleteButton.addActionListener(e -> {
            if (selectedIndex != -1) {
                int response = JOptionPane.showConfirmDialog(this,
                        "Apakah Anda yakin ingin menghapus data ini?",
                        "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    deleteData();
                }
            }
        });
        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String status = mahasiswaTable.getValueAt(selectedIndex, 4).toString();

                // ubah isi textfield dan combo box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                if (status.equals("Aktif")) aktifRadioButton.setSelected(true);
                else nonAktifRadioButton.setSelected(true);
                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");
                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Status"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        try {
            ResultSet resultSet = database.selectQuery("Select * from mahasiswa");

            int i = 0;
            while (resultSet.next()) {
                Object[] row = new Object[5];

                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getString("status");

                temp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return temp; // return juga harus diganti
    }

    public void insertData() {
        // ambil value dari textfield dan combobox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenis_kelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String status = aktifRadioButton.isSelected() ? "Aktif" : "Non-Aktif";

        if (nim.isEmpty() || nama.isEmpty() || jenis_kelamin.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cek apakah NIM sudah ada di database
        String checkQuery = "SELECT * FROM mahasiswa WHERE nim = '" + nim + "'";
        ResultSet rs = database.selectQuery(checkQuery);
        try {
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "NIM sudah digunakan oleh mahasiswa lain!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO mahasiswa VALUES (null, '" + nim + "', '" + nama + "', '" + jenis_kelamin + "', '" + status + "');";
        database.insertUpdateDeleteQuery(sql);
        mahasiswaTable.setModel(setTable());
        clearForm();

        // feedback
        System.out.println("Insert Berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenis_kelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String status = aktifRadioButton.isSelected() ? "Aktif" : "Non-Aktif";

        if (nim.isEmpty() || nama.isEmpty() || jenis_kelamin.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // cek apakah NIM sudah digunakan oleh mahasiswa lain
        try {
            ResultSet rs = database.selectQuery("SELECT * FROM mahasiswa WHERE nim = '" + nim + "'");
            if (rs.next() && !rs.getString("nim").equals(mahasiswaTable.getValueAt(selectedIndex, 1))) {
                JOptionPane.showMessageDialog(null, "NIM sudah digunakan oleh mahasiswa lain!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam pengecekan NIM: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // update data mahasiswa
        String sql = "UPDATE mahasiswa SET nim = '" + nim + "', nama = '" + nama + "', jenis_kelamin = '" + jenis_kelamin + "', " +
                "status = '" + status + "' WHERE nim = " + mahasiswaTable.getValueAt(selectedIndex, 1);
        database.insertUpdateDeleteQuery(sql);

        mahasiswaTable.setModel(setTable());
        // bersihkan form
        clearForm();
        // feedback
        System.out.println("Update Berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
    }


    public void deleteData() {
        if (selectedIndex != -1) {
            String nim = mahasiswaTable.getValueAt(selectedIndex, 1).toString();

            int response = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "'";
                database.insertUpdateDeleteQuery(sql);
                mahasiswaTable.setModel(setTable());
                clearForm();
                System.out.println("Delete Berhasil!");
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            }
        }

    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        bgStatus.clearSelection();
        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");
        // sembunyikan button delete
        deleteButton.setVisible(false);
        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }

    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "Non-Aktif"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "Non-Aktif"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "Non-Aktif"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "Aktif"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "Aktif"));
    }
}
