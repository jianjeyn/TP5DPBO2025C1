# TP5DPBO2025C1

## Janji
Saya Jihan Aqilah Hartono dengan NIM 2306827 mengerjakan Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Design
![tp5 drawio](https://github.com/user-attachments/assets/a512b9be-d067-48e5-8c6c-aa54e2b8baea)

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
![image](https://github.com/user-attachments/assets/2b78cfb2-d71f-415a-ba46-dbb4eaf1b978)
![image](https://github.com/user-attachments/assets/1ce4c4c9-174a-4fe6-8156-6408aba68a1d)

### Tampilkan dialog/prompt error jika sudah ada NIM yang sama saat insert.
![image](https://github.com/user-attachments/assets/9ff50509-df15-416a-9a0e-a6af69d2e679)

### Hubungkan semua proses CRUD dengan database.
![image](https://github.com/user-attachments/assets/07859658-ffa1-42aa-a708-a8bb3d3780f0)
![image](https://github.com/user-attachments/assets/7e1da232-14e3-4b69-9018-8f0fcc65050b)
![image](https://github.com/user-attachments/assets/c07a0321-a092-4501-84ed-ba2ee227bf50)
![image](https://github.com/user-attachments/assets/703e6680-67f6-4129-ba98-30097ced4250)
![image](https://github.com/user-attachments/assets/6b92852e-081f-4c0a-9d14-9122e9f6947f)
![image](https://github.com/user-attachments/assets/a76031f2-d038-4937-a950-6fd039be55d3)

