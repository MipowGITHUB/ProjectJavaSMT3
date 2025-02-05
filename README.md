# ProjectJavaSMT3
# Proyek Java & Python

Proyek ini terdiri dari berbagai aplikasi yang dibangun menggunakan Java dan Python. Beberapa fitur utama dari proyek ini mencakup pembuatan API, GUI, dan pengembangan berbagai library serta beberapa aplikasi berbasis Python seperti deteksi usia dan sistem kasir berbasis API.

## Daftar Isi
1. [Proyek Java](#proyek-java)
    - [API](#api)
    - [GUI](#gui)
    - [Library](#library)
2. [Proyek Python](#proyek-python)
    - [Deteksi Usia](#deteksi-usia)
    - [Sistem Kasir](#sistem-kasir)
3. [Instalasi](#instalasi)
4. [Lisensi](#lisensi)

---

## Proyek Java

### API

Aplikasi ini menyediakan API yang memungkinkan pengguna untuk mengakses berbagai layanan menggunakan HTTP. API ini dibangun dengan menggunakan framework Spring Boot untuk memudahkan pengembangan dan pengelolaan endpoint-endpoint RESTful.

### GUI

Proyek ini juga melibatkan pembuatan antarmuka pengguna grafis (GUI) menggunakan JavaFX. GUI ini memberikan pengalaman pengguna yang interaktif untuk aplikasi yang membutuhkan interaksi lebih dari sekadar command-line.

**Fitur:**
- Formulir input data
- Tampilan tabel dinamis untuk menampilkan informasi
- Penggunaan event handling untuk tombol dan kontrol lainnya

### Library

Sebuah library Java dibuat untuk mempermudah pengolahan data dalam proyek-proyek lain. Library ini menyediakan berbagai utilitas umum yang sering digunakan dalam pemrograman Java, seperti konversi format data, enkripsi, dan pengelolaan file.

---

## Proyek Python

### Deteksi Usia

Aplikasi deteksi usia ini memungkinkan pengguna untuk memasukkan tahun saat ini dan tahun kelahiran untuk menghitung umur dan mengkategorikan usia berdasarkan rentang tertentu.

**Fitur:**
- Input tahun kelahiran dan tahun saat ini
- Menampilkan umur yang dihitung berdasarkan input
- Menyediakan kategori usia (misalnya: Anak-anak, Remaja, Dewasa, Lansia) berdasarkan umur

**Contoh Penggunaan:**
1. Pengguna memasukkan tahun kelahiran, misalnya 1990.
2. Pengguna memasukkan tahun saat ini, misalnya 2025.
3. Program akan menghitung umur (35 tahun) dan menentukan kategori usia, misalnya "Dewasa".

### Sistem Kasir (API berbasis Word)

Sistem kasir berbasis API ini dikembangkan untuk mempermudah transaksi jual beli dengan menggunakan API untuk menerima data produk dan menghitung total harga pembelian. Sistem ini mengembalikan output dalam format Word (docx) yang dapat diunduh sebagai struk transaksi.

**Fitur:**
- Input data produk dan harga melalui endpoint API
- Menghitung total harga berdasarkan produk yang dibeli
- Menghasilkan struk transaksi dalam format file Word (docx) yang berisi rincian pembelian dan total harga

**Contoh Penggunaan:**
1. Pengguna mengirimkan data produk melalui API.
2. Sistem menghitung total harga pembelian.
3. Sistem menghasilkan dan mengembalikan file Word (struk transaksi) yang berisi detail pembelian dan total harga.

---

## Instalasi

### Java

Untuk menjalankan proyek Java ini, pastikan bahwa kamu telah menginstal **Java JDK 11** atau versi yang lebih baru. Selain itu, kamu juga perlu menginstal **Maven** atau **Gradle** untuk manajemen dependensi.
