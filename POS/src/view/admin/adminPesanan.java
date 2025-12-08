package view.admin;

import controller.TransaksiController; // Import Controller
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class adminPesanan extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private TransaksiController transController;

    public adminPesanan() {
        initComponents();

        judul.setText("RIWAYAT TRANSAKSI");
        transController = new TransaksiController();

        setupTable();
        loadDataTransaksi();
    }

    private void setupTable() {
        String[] kolom = {"ID Transaksi", "Kasir / User", "Total Belanja", "Waktu Transaksi"};
        tableModel = new DefaultTableModel(null, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(tableModel);
    }

    private void loadDataTransaksi() {
        tableModel.setRowCount(0);
        List<String[]> dataList = transController.getSemuaRiwayatTransaksi();
        for (String[] row : dataList) {
            tableModel.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        judulPanel = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        judulPanel.setPreferredSize(new java.awt.Dimension(980, 100));
        judulPanel.setLayout(new java.awt.BorderLayout());

        judul.setFont(new java.awt.Font("Segoe UI", 0, 36));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("PESANAN");
        judulPanel.add(judul, java.awt.BorderLayout.CENTER);

        add(judulPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"Title 1", "Title 2", "Title 3", "Title 4"}
        ));
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>

    // Variables declaration
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel judul;
    private javax.swing.JPanel judulPanel;
}