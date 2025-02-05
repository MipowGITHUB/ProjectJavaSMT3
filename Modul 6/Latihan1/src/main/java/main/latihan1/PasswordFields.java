package main.latihan1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordFields {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh Password Field");
        frame.setSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Masukkan Kata Sandi:");
        frame.add(label);

        JPasswordField passwordField = new JPasswordField(20);
        frame.add(passwordField);

        JButton button = new JButton("Validasi Password");
        frame.add(button);

        JLabel resultLabel = new JLabel("Password akan divalidasi di sini.");
        frame.add(resultLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                String passwordText = new String(password);

                if (passwordText.length() < 7) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Minimal 7 karakter.");
                } else if (!passwordText.matches(".*[A-Z].*")) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Harus mengandung huruf besar.");
                } else if (!passwordText.matches(".*[a-z].*")) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Harus mengandung huruf kecil.");
                } else if (!passwordText.matches(".*[0-9].*")) {
                    JOptionPane.showMessageDialog(frame, "Password tidak valid. Harus mengandung angka.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Password Valid");
                }
            }
        });

        frame.setVisible(true);
    }
}




