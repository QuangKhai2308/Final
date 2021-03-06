/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class Doanhthu extends javax.swing.JInternalFrame {

    /**
     * Creates new form Doanhthu
     */
    String user = "sa";
    String pass = "123456";
    Connection conn;
    String url = "jdbc:sqlserver://localhost:1433;databaseName = QLBH";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel model;
    Locale locale = new Locale("en", "EN");
    DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    int index;
    public Doanhthu() {
        initComponents();
        conn = getConnection();
        model = (DefaultTableModel) tblDoanhThu.getModel();
        fetchList();
        
        tblDoanhThu.setComponentPopupMenu(menuXem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuXem = new javax.swing.JPopupMenu();
        Xem = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateNgay = new com.toedter.calendar.JDateChooser();
        btnTK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblDoanhthu = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();

        Xem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Xem.setText("Xem");
        Xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XemActionPerformed(evt);
            }
        });
        menuXem.add(Xem);

        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Doanh Thu Bán Hàng");

        dateNgay.setDateFormatString("yyyy-MM-dd");
        dateNgay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnTK.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTK.setText("Tìm kiếm");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        tblDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_SP", "TENSP", "MAUSAC", "SOLUONG", "THANHTIEN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblDoanhThu);
        if (tblDoanhThu.getColumnModel().getColumnCount() > 0) {
            tblDoanhThu.getColumnModel().getColumn(0).setMinWidth(100);
            tblDoanhThu.getColumnModel().getColumn(0).setMaxWidth(100);
            tblDoanhThu.getColumnModel().getColumn(1).setMinWidth(180);
            tblDoanhThu.getColumnModel().getColumn(1).setMaxWidth(180);
            tblDoanhThu.getColumnModel().getColumn(2).setMinWidth(120);
            tblDoanhThu.getColumnModel().getColumn(2).setMaxWidth(120);
            tblDoanhThu.getColumnModel().getColumn(3).setMinWidth(80);
            tblDoanhThu.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("Doanh thu:");

        lblDoanhthu.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/out.png"))); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblDoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnTK))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTK, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoanhthu))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, lblDoanhthu});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    protected void fetchList() {
        String query = "SELECT ID_SP, TEN_SP, MAUSAC, SUM(SOLUONG), SUM(THANHTIEN) FROM HOADON_CHITIET "
                + "GROUP BY ID_SP, TEN_SP, MAUSAC";

        try {
            model.setRowCount(0);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Vector vector = new Vector();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getLong(4));
                vector.add(rs.getLong(5));
                model.addRow(vector);
            }
            tblDoanhThu.setModel(model);

            long sum = 0;
            dcf.applyPattern("#,###,###,###");
            for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
                sum += Long.valueOf(tblDoanhThu.getValueAt(i, 4).toString());
            }
            lblDoanhthu.setText(dcf.format(sum) + " VNĐ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:

        if (dateNgay.getDate() == null) {
            fetchList();
        } else {
            model.setRowCount(0);
            lblDoanhthu.setText("0 VNĐ");
            String query = "SELECT ID_SP, TEN_SP, MAUSAC, SUM(SOLUONG), SUM(THANHTIEN) FROM HOADON_CHITIET "
                    + "WHERE NGAYMUA = ? GROUP BY ID_SP, TEN_SP, MAUSAC";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, sdf.format(dateNgay.getDate()));

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.add(rs.getString(1));
                    vector.add(rs.getString(2));
                    vector.add(rs.getString(3));
                    vector.add(rs.getLong(4));
                    vector.add(rs.getLong(5));
                    model.addRow(vector);
                }
                tblDoanhThu.setModel(model);

                long sum = 0;
                dcf.applyPattern("#,###,###,###");
                for (int i = 0; i < tblDoanhThu.getRowCount(); i++) {
                    sum += Long.valueOf(tblDoanhThu.getValueAt(i, 4).toString());
                }
                lblDoanhthu.setText(dcf.format(sum) + " VNĐ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnTKActionPerformed

    private void XemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XemActionPerformed
        // TODO add your handling code here:
        index = tblDoanhThu.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu để thực hiện thao tác");
        } else {
            String MaSP = String.valueOf(tblDoanhThu.getValueAt(index, 0));

            QLSP qlsp = new QLSP(MaSP);

            this.getDesktopPane().add(qlsp);
            qlsp.setLocation(this.getDesktopPane().getWidth() / 2 - qlsp.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - qlsp.getHeight() / 2);
            qlsp.setVisible(true);
            System.out.println(MaSP);
            this.dispose();
        }
    }//GEN-LAST:event_XemActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        menu_banhang menu_BH = new menu_banhang();
        this.getDesktopPane().add(menu_BH);
        menu_BH.setVisible(true);
        menu_BH.setLocation(this.getDesktopPane().getWidth() / 2 - menu_BH.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - menu_BH.getHeight() / 2);

        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Xem;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnThoat;
    private com.toedter.calendar.JDateChooser dateNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDoanhthu;
    private javax.swing.JPopupMenu menuXem;
    private javax.swing.JTable tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
