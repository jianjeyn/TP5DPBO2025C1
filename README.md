# TP5DPBO2025C1

## Janji
Saya Jihan Aqilah Hartono dengan NIM 2306827 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Design
![tp5 drawio](https://github.com/user-attachments/assets/018213c3-d0d8-441a-a268-2b736324f35a)

## Penjelasan Design Kelas
#### **Kelas `Database`**
Kelas `Database` bertanggung jawab untuk mengelola koneksi dengan database. Kelas ini memiliki atribut `connection` untuk menyimpan koneksi ke database dan `statement` untuk menjalankan perintah SQL.  
Metode yang tersedia:  
- `selectQuery()`: Menjalankan query SELECT dan mengembalikan hasilnya dalam bentuk `ResultSet`.  
- `insertUpdateDelete()`: Menjalankan query INSERT, UPDATE, atau DELETE untuk memanipulasi data di database.  
- `getStatement()`: Mengembalikan objek `Statement` yang dapat digunakan untuk menjalankan query SQL.  

#### **Kelas `Mahasiswa`**
Kelas `Mahasiswa` merupakan model data yang merepresentasikan mahasiswa dalam program.  
Atribut yang ada:  
- `NIM`: Nomor Induk Mahasiswa dalam bentuk `String`.  
- `Nama`: Nama mahasiswa.  
- `JenisKelamin`: Jenis kelamin mahasiswa.  
- `StatusMahasiswa`: Status mahasiswa (aktif/non-aktif).  
Selain itu, kelas ini memiliki metode **getter dan setter** untuk mengakses dan mengubah atributnya.  

#### **Kelas `Menu`**
Kelas `Menu` merupakan antarmuka utama dari program dan berperan sebagai controller. Kelas ini memiliki banyak atribut yang berhubungan dengan elemen GUI seperti **JTextField, JTable, JButton, JComboBox, JLabel**, dan **JRadioButton**.  
Beberapa metode penting dalam kelas ini:  
- `setTable()`: Menampilkan data mahasiswa ke dalam tabel.  
- `insertData()`: Menambahkan data mahasiswa baru ke database.  
- `deleteData()`: Menghapus data mahasiswa berdasarkan NIM yang dipilih.  
- `updateData()`: Memperbarui data mahasiswa yang dipilih.  
- `clearForm()`: Mengosongkan form input setelah proses selesai.  
- `populateList()`: Mengisi daftar mahasiswa dari database ke dalam **ArrayList**.  

#### **Hubungan Antar Kelas**
1. **`Menu` menggunakan `Database`** untuk menjalankan query SQL seperti SELECT, INSERT, UPDATE, dan DELETE.  
2. **`Menu` menggunakan `Mahasiswa`** sebagai model data yang ditampilkan dalam tabel.  
3. **`Menu` mewarisi `JFrame`**, yang berarti kelas ini merupakan tampilan utama dari aplikasi berbasis GUI.  

## Alur Program
1. Saat aplikasi dijalankan, kelas `Menu` akan ditampilkan karena merupakan turunan dari `JFrame`.  
2. `populateList()` akan dipanggil untuk mengambil data mahasiswa dari database dan menyimpannya dalam **ArrayList**.  
3. `setTable()` akan mengisi tabel GUI berdasarkan daftar mahasiswa.  
4. Jika pengguna ingin **menambah mahasiswa**, data dari form diambil dan `insertData()` akan menjalankan query INSERT ke database.  
5. Jika pengguna ingin **mengubah data mahasiswa**, `updateData()` akan mengambil nilai input baru dan menjalankan query UPDATE.  
6. Jika pengguna ingin **menghapus mahasiswa**, `deleteData()` akan mengeksekusi query DELETE berdasarkan NIM yang dipilih.  
7. Setelah setiap operasi, **tabel diperbarui** dan form dikosongkan menggunakan `setTable()` dan `clearForm()`.  

## Dokumentasi
### Tampilkan dialog/prompt error jika masih ada input yang kosong saat insert/update.
![Screenshot 2025-03-25 025144](https://github.com/user-attachments/assets/c36ee9a8-257b-47bf-b153-2e889044af08)
![Screenshot 2025-03-25 025216](https://github.com/user-attachments/assets/58ae0371-2796-4eaa-be77-267ce72055f5)

### Tampilkan dialog/prompt error jika sudah ada NIM yang sama saat insert.
![Screenshot 2025-03-25 025256](https://github.com/user-attachments/assets/249b60c4-4497-4337-b99c-37bcecdb2626)

### Hubungkan semua proses CRUD dengan database.
![Screenshot 2025-03-25 025426](https://github.com/user-attachments/assets/499aaf13-1bde-4320-a3af-d847f42f86dd)
![Screenshot 2025-03-25 025454](https://github.com/user-attachments/assets/6a187ff0-f6b0-4c5c-8cf7-5775c3affa71)
![Screenshot 2025-03-25 025520](https://github.com/user-attachments/assets/a8b05637-b1f8-425b-a60c-58db77365900)
![Screenshot 2025-03-25 025549](https://github.com/user-attachments/assets/b386a50c-2630-44e8-b335-f37c6db27eae)
![Screenshot 2025-03-25 025608](https://github.com/user-attachments/assets/46b01e91-85e4-49b4-8beb-31a5176d93e9)
![Screenshot 2025-03-25 025647](https://github.com/user-attachments/assets/30ca5971-65e9-42b8-93b2-da26f9d46604)


