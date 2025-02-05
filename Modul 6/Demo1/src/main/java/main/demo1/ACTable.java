package main.demo1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ACTable extends JFrame {
    private JTextField txtID, txtNamaDepan, txtNamaBelakang, txtUsia;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JLabel lblResult;

    public ACTable() {
        setTitle("Kalkulator Umur");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel untuk input form
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // ID
        JLabel lblID = new JLabel("ID:");
        txtID = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblID, gbc);
        gbc.gridx = 1;
        formPanel.add(txtID, gbc);

        // Nama Depan
        JLabel lblNamaDepan = new JLabel("Nama Depan:");
        txtNamaDepan = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblNamaDepan, gbc);
        gbc.gridx = 1;
        formPanel.add(txtNamaDepan, gbc);

        // Nama Belakang
        JLabel lblNamaBelakang = new JLabel("Nama Belakang:");
        txtNamaBelakang = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lblNamaBelakang, gbc);
        gbc.gridx = 1;
        formPanel.add(txtNamaBelakang, gbc);

        // Usia
        JLabel lblUsia = new JLabel("Tahun Lahir:");
        txtUsia = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(lblUsia, gbc);
        gbc.gridx = 1;
        formPanel.add(txtUsia, gbc);

        // Tombol Tambah Data
        JButton btnTambahData = new JButton("Tambah Data");
        btnTambahData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addDataToTable();
                } catch (NumberFormatException ex) {
                    // Tampilkan pesan error jika input tahun lahir tidak valid
                    JOptionPane.showMessageDialog(ACTable.this, "Tahun lahir harus berupa angka!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    // Tampilkan pesan error jika ada field yang kosong
                    JOptionPane.showMessageDialog(ACTable.this, "Semua field harus diisi!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(btnTambahData, gbc);

        // Panel untuk JTable
        JPanel tablePanel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Nama Depan", "Nama Belakang", "Usia"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableData = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableData);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Panel untuk hasil perhitungan
        JPanel resultPanel = new JPanel();
        lblResult = new JLabel();
        resultPanel.add(lblResult);

        add(formPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
    }

    private void addDataToTable() {
        String id = txtID.getText();
        String namaDepan = txtNamaDepan.getText();
        String namaBelakang = txtNamaBelakang.getText();
        String usia = txtUsia.getText();

        // Validasi input tidak boleh kosong
        if (id.trim().isEmpty() || namaDepan.trim().isEmpty() || namaBelakang.trim().isEmpty() || usia.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        Vector<String> rowData = new Vector<>();
        rowData.add(id);
        rowData.add(namaDepan);
        rowData.add(namaBelakang);
        rowData.add(usia);

        tableModel.addRow(rowData);

        // Perhitungan umur
        int currentYear = 2024;
        int birthYear = Integer.parseInt(usia);
        int age = currentYear - birthYear;
        String ageCategory = determineAgeCategory(age);

        // Menampilkan hasil
        String resultText1 = "Nama Anda adalah " + namaDepan + " " + namaBelakang;
        String resultText2 = " dan umur Anda adalah " + age + " tahun. " + ageCategory;
        lblResult.setText(resultText1 + "\n" + resultText2);

        txtID.setText("");
        txtNamaDepan.setText("");
        txtNamaBelakang.setText("");
        txtUsia.setText("");
    }

    private static String determineAgeCategory(int age) {
        if (age < 18) {
            return "Anda masih di bawah umur.";
        } else if (age <= 60) {
            return "Anda adalah orang dewasa.";
        } else {
            return "Anda adalah orang tua.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ACTable().setVisible(true);
            }
        });
    }
}