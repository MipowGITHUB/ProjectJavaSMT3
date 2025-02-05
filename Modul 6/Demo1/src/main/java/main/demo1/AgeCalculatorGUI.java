package main.demo1;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgeCalculatorGUI extends JFrame {
    private JTextField txtName;
    private JTextField txtBirthYear;
    private JLabel lblResult;
    private JLabel lblImage;
    private JButton btnCalculate;

    public AgeCalculatorGUI() {
        // Konfigurasi dasar frame
        setTitle("Kalkulator Umur");
        setSize(new Dimension(1200, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;


        JLabel lblName = new JLabel("Nama:");
        txtName = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblName, gbc);
        gbc.gridx = 1;
        add(txtName, gbc);


        JLabel lblBirthYear = new JLabel("Tahun Lahir:");
        txtBirthYear = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblBirthYear, gbc);
        gbc.gridx = 1;
        add(txtBirthYear, gbc);

        // Tombol Hitung
        btnCalculate = new JButton("Hitung Umur");
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnCalculate, gbc);

        // Label Hasil
        lblResult = new JLabel();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblResult, gbc);

        // Label Gambar
        lblImage = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblImage, gbc);
    }

    private void calculateAge() {
        // Validasi input tidak boleh kosong
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtBirthYear.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tahun lahir tidak boleh kosong!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Parsing input
            String name = txtName.getText();
            int birthYear = Integer.parseInt(txtBirthYear.getText());
            int currentYear = 2024;

            // Menghitung umur
            int age = currentYear - birthYear;

            // Menentukan kategori umur
            String ageCategory = determineAgeCategory(age);

            // Menampilkan hasil
            String resultText = String.format("Nama Anda adalah %s dan umur Anda adalah %d tahun. %s", name, age, ageCategory);
            lblResult.setText(resultText);

            // Tambahkan gambar-gambar tergantung pada hasil umur
            ImageIcon ageIcon;
            if (age < 18) {
                ageIcon = new ImageIcon("D:\\Kuliah\\Formal\\Semester III\\Pemrograman Lanjut\\Modul 6\\Demo1\\src\\main\\java\\main\\demo1\\Image\\baby.png");
                lblImage.setIcon(new ImageIcon(ageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            } else if (age <= 60) {
                ageIcon = new ImageIcon("D:\\Kuliah\\Formal\\Semester III\\Pemrograman Lanjut\\Modul 6\\Demo1\\src\\main\\java\\main\\demo1\\Image\\MetaKnight.png");
                lblImage.setIcon(new ImageIcon(ageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            } else {
                ageIcon = new ImageIcon("D:\\Kuliah\\Formal\\Semester III\\Pemrograman Lanjut\\Modul 6\\Demo1\\src\\main\\java\\main\\demo1\\Image\\old.png");
                lblImage.setIcon(new ImageIcon(ageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Tahun lahir harus angka!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
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
        // Menjalankan GUI di Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgeCalculatorGUI().setVisible(true);
            }
        });
    }
}