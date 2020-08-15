/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khai2
 */
public class thongtin_hoadon extends javax.swing.JInternalFrame {

    /**
     * Creates new form thongtin_hoadon
     */
    String user = "sa";
    String pass = "123456";
    Connection conn;
    String url = "jdbc:sqlserver://localhost:1433;databaseName = QLBH";
    DefaultTableModel model;
    List<HoaDon> ListDH = new ArrayList<>();
    Locale locale = new Locale("en", "EN");
    DecimalFormat dcf = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    int index = 0;
    public thongtin_hoadon() {
        initComponents();
        conn = getConnection();
        ListDH = fetchList();
        RenderList(ListDH);
        
        tblListHD.setComponentPopupMenu(SelectTable);
    }

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectTable = new javax.swing.JPopupMenu();
        Update = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListHD = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        btnSerach = new javax.swing.JButton();
        btnAZ = new javax.swing.JButton();
        btnZA = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        Update.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Update.setText("Sửa");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        SelectTable.add(Update);

        Delete.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Delete.setText("Xóa");
        SelectTable.add(Delete);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(234, 153, 153));

        tblListHD.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tblListHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_HDCT", "ID_HD", "ID_SP", "TENSP", "MAUSAC", "SIZE", "SOLUONG", "NGAYMUA", "GIA", "DISCOUNT", "THANHTIEN", "MAKH", "TENKH", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListHD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblListHD);
        if (tblListHD.getColumnModel().getColumnCount() > 0) {
            tblListHD.getColumnModel().getColumn(0).setMinWidth(70);
            tblListHD.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblListHD.getColumnModel().getColumn(0).setMaxWidth(70);
            tblListHD.getColumnModel().getColumn(1).setMinWidth(90);
            tblListHD.getColumnModel().getColumn(1).setMaxWidth(90);
            tblListHD.getColumnModel().getColumn(2).setMinWidth(80);
            tblListHD.getColumnModel().getColumn(2).setMaxWidth(80);
            tblListHD.getColumnModel().getColumn(3).setMinWidth(130);
            tblListHD.getColumnModel().getColumn(3).setMaxWidth(130);
            tblListHD.getColumnModel().getColumn(4).setMinWidth(70);
            tblListHD.getColumnModel().getColumn(4).setMaxWidth(70);
            tblListHD.getColumnModel().getColumn(5).setMinWidth(50);
            tblListHD.getColumnModel().getColumn(5).setMaxWidth(50);
            tblListHD.getColumnModel().getColumn(6).setMinWidth(70);
            tblListHD.getColumnModel().getColumn(6).setMaxWidth(70);
            tblListHD.getColumnModel().getColumn(7).setMinWidth(90);
            tblListHD.getColumnModel().getColumn(7).setMaxWidth(90);
            tblListHD.getColumnModel().getColumn(8).setMinWidth(75);
            tblListHD.getColumnModel().getColumn(8).setMaxWidth(75);
            tblListHD.getColumnModel().getColumn(9).setMinWidth(75);
            tblListHD.getColumnModel().getColumn(9).setMaxWidth(75);
            tblListHD.getColumnModel().getColumn(10).setMinWidth(80);
            tblListHD.getColumnModel().getColumn(10).setMaxWidth(80);
            tblListHD.getColumnModel().getColumn(11).setMinWidth(70);
            tblListHD.getColumnModel().getColumn(11).setMaxWidth(70);
            tblListHD.getColumnModel().getColumn(13).setMinWidth(90);
            tblListHD.getColumnModel().getColumn(13).setMaxWidth(90);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin hóa đơn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSerach.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSerach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        btnSerach.setText("Tìm kiếm");
        btnSerach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerachActionPerformed(evt);
            }
        });

        btnAZ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sortaz.png"))); // NOI18N
        btnAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAZActionPerformed(evt);
            }
        });

        btnZA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/sortza.png"))); // NOI18N
        btnZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZAActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSerach, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAZ, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnZA, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 276, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaHD)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSerach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnZA, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    protected void RenderList(List<HoaDon> hd) {
        model = (DefaultTableModel) tblListHD.getModel();
        model.setRowCount(0);
        String patter = "#,###,###";
        dcf.applyPattern(patter);
        for (int i = 0; i < hd.size(); i++) {
            HoaDon x = hd.get(i);
            model.addRow(new Object[]{x.getID_HDCT(), x.getID_HD(), x.getID_SP(),
                x.getTen_SP(), x.getMauSac(), x.getSize(), x.getSoLuong(), x.getNgayMua(),
                dcf.format(x.getGia()), dcf.format(x.getDiscount()), dcf.format(x.getThanhTien()),x.getMaKH(), x.getTenKH(), x.getSDT()});

        }
    }

    protected void Find() {
        String query = "EXEC find_id_hd ?";
//        List<HoaDon> listHD = new ArrayList<HoaDon>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, txtMaHD.getText());

//            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID_HDCT = rs.getInt(1);
                String MaHD = rs.getString(2);
                String MaSP = rs.getString(3);
                String TenSP = rs.getNString(4);
                String MAUSAC = rs.getNString(5);
                int Size = rs.getInt(6);
                int SoLuong = rs.getInt(7);
                Date NgayMua = rs.getDate(8);
                double Gia = rs.getDouble(9);
                double Discount = rs.getDouble(10);
                double ThanhTien = rs.getDouble(11);
                String MaKH = rs.getString(12);
                String TenKH = rs.getNString(13);
                String SDT = rs.getString(14);
                ListDH.add(new HoaDon(ID_HDCT, MaHD, TenSP, TenSP, MAUSAC, Size, SoLuong, NgayMua, Gia, Discount, ThanhTien, MaKH, TenKH, SDT));
            }
            RenderList(ListDH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnSerachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerachActionPerformed
        // TODO add your handling code here:
        if (txtMaHD.getText().isEmpty()) {
            ListDH.clear();
            ListDH = fetchList();
            RenderList(ListDH);
        } else if (!txtMaHD.getText().isEmpty()) {
            ListDH.clear();
            Find();
        }
    }//GEN-LAST:event_btnSerachActionPerformed

    private void btnAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAZActionPerformed
        // TODO add your handling code here:
        ListDH.sort((HoaDon x, HoaDon y) -> (int) (x.getThanhTien() - y.getThanhTien()));
        RenderList(ListDH);
    }//GEN-LAST:event_btnAZActionPerformed

    private void btnZAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZAActionPerformed
        // TODO add your handling code here:
        ListDH.sort((HoaDon x, HoaDon y) -> (int) (y.getThanhTien() - x.getThanhTien()));
        RenderList(ListDH);
    }//GEN-LAST:event_btnZAActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        menu_banhang menu_BH = new menu_banhang();
        this.getDesktopPane().add(menu_BH);
        menu_BH.setVisible(true);
        menu_BH.setLocation(this.getDesktopPane().getWidth() / 2 - menu_BH.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - menu_BH.getHeight() / 2);

        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        index = tblListHD.getSelectedRow();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu để thực hiện thao tác");
        } else {
            int MaHDCT = Integer.valueOf(String.valueOf(tblListHD.getValueAt(index, 0)));
            
            UpdateHD update = new UpdateHD(MaHDCT);
            
            this.getDesktopPane().add(update);
            update.setLocation(this.getDesktopPane().getWidth() / 2 - update.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - update.getHeight() / 2);
            update.setVisible(true);
            System.out.println(MaHDCT);
            this.dispose();
        }
    }//GEN-LAST:event_UpdateActionPerformed

    protected List<HoaDon> fetchList() {
        List<HoaDon> list = new ArrayList<>();

        String query = "SELECT HDCT.*, KH.ID_KH, KH.TEN_KH, KH.PHONE FROM HOADON_CHITIET AS"
                + " HDCT INNER JOIN HOADON AS HD ON HD.ID_HD = HDCT.ID_HD\n"
                + "INNER JOIN KHACHHANG AS KH ON KH.ID_KH = HD.ID_KH";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
//            ID_HDCT, HOADON_CHITIET.ID_HD, HOADON_CHITIET.ID_SP,"
//                + "HOADON_CHITIET.TEN_SP, MAUSAC, HOADON_CHITIET.SIZE,"
//                + "HOADON_CHITIET.SOLUONG, HOADON_CHITIET.NGAYMUA, HOADON_CHITIET.GIA,"
//                + "HOADON_CHITIET.DISCOUNT, HOADON.TONGTIEN
            while (rs.next()) {
                int ID_HDCT = rs.getInt(1);
                String MaHD = rs.getString(2);
                String MaSP = rs.getString(3);
                String TenSP = rs.getNString(4);
                String MAUSAC = rs.getNString(5);
                int Size = rs.getInt(6);
                int SoLuong = rs.getInt(7);
                Date NgayMua = rs.getDate(8);
                double Gia = rs.getDouble(9);
                double Discount = rs.getDouble(10);
                double ThanhTien = rs.getDouble(11);
                String MaKH = rs.getString(12);
                String TenKH = rs.getNString(13);
                String SDT = rs.getString(14);
                list.add(new HoaDon(ID_HDCT, MaHD, MaSP, TenSP, MAUSAC, Size, SoLuong, NgayMua, Gia, Discount, ThanhTien, MaKH, TenKH, SDT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Delete;
    private javax.swing.JPopupMenu SelectTable;
    private javax.swing.JMenuItem Update;
    private javax.swing.JButton btnAZ;
    private javax.swing.JButton btnSerach;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnZA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListHD;
    private javax.swing.JTextField txtMaHD;
    // End of variables declaration//GEN-END:variables
}
