package main.latihan2;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaTable {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Tabel dengan Input Pengguna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        String[][] data = {
                {"1", "Budi", "Santoso", "25"},
                {"2", "Siti", "Nurhaliza", "30"},
                {"3", "Ahmad", "Subendra", "40"},
                {"4", "Dewi", "Putri", "35"}
        };
        String[] columns = {"ID", "Nama Depan", "Nama Belakang", "Usia"};

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JTextField idField = new JTextField(20);
        JTextField namaDepanField = new JTextField(20);
        JTextField namaBelakangField = new JTextField(20);
        JTextField usiaField = new JTextField(20);

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nama Depan:"));
        inputPanel.add(namaDepanField);
        inputPanel.add(new JLabel("Nama Belakang:"));
        inputPanel.add(namaBelakangField);
        inputPanel.add(new JLabel("Usia:"));
        inputPanel.add(usiaField);

        JButton addButton = new JButton("Tambah Data");
        inputPanel.add(addButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String namaDepan = namaDepanField.getText();
                String namaBelakang = namaBelakangField.getText();
                String usia = usiaField.getText();

                model.addRow(new Object[]{id, namaDepan, namaBelakang, usia});

                idField.setText("");
                namaDepanField.setText("");
                namaBelakangField.setText("");
                usiaField.setText("");
            }
        });

        frame.setVisible(true);
    }
}


