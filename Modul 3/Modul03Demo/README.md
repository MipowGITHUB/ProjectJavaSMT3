# Age Calculator
Proyek **Age Calculator** ini adalah aplikasi sederhana berbasis Java untuk menghitung umur dan menentukan kategori usia berdasarkan tahun kelahiran. Pengguna cukup memasukkan nama dan tahun kelahiran, lalu aplikasi akan menghitung umur dan menampilkan kategori usia berdasarkan tiga kelompok: di bawah umur (< 18 tahun), dewasa (18-60 tahun), atau orang tua (> 60 tahun).

Proyek ini telah di-refactoring menggunakan beberapa teknik refactoring seperti:
- **Extract Method** untuk memisahkan logika input, perhitungan, dan output
- **Rename Method** untuk memperjelas nama metode (seperti `getUserName`, `calculateAge`)
- **Replace Magic Number with Constant** untuk angka-angka dalam penentuan kategori usia
- **Single Responsibility Principle** di mana setiap method memiliki satu tugas spesifik
- **Clean Code Practices** untuk meningkatkan keterbacaan kode

## Fitur Utama
- Input nama pengguna
- Input tahun kelahiran
- Perhitungan umur otomatis
- Penentuan kategori usia dalam tiga kelompok:
  - Di bawah umur (< 18 tahun)
  - Dewasa (18-60 tahun)
  - Orang tua (> 60 tahun)

## Persyaratan
- **Java Development Kit (JDK)** versi 8 atau lebih tinggi harus terinstal di sistem Anda
- Program bisa dijalankan di command line atau IDE Java
