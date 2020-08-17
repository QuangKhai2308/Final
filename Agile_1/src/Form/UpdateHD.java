/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.QLDH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UpdateHD extends javax.swing.JInternalFrame {

    /**
     * Creates new form UpdateHD
     */
    String user = "sa";
    String pass = "123456";
    Connection conn;
    String url = "jdbc:sqlserver://localhost:1433;databaseName = QLBH";
    int Ma_HDCT;
    int soluong;
    String MaSP;
    int lblsl;

    public UpdateHD(int MaHDCT) {
        initComponents();
        conn = getConnection();

        unEnditable();
        fetechMaNV();
        fetchMaSP();

        String query = "SELECT HDCT.*, KH.*, NV.ID_NV, NV.TEN_NV FROM HOADON_CHITIET AS HDCT\n"
                + "	INNER JOIN HOADON AS HD ON HD.ID_HD = HDCT.ID_HD\n"
                + "	INNER JOIN KHACHHANG AS KH ON KH.ID_KH = HD.ID_KH\n"
                + "	INNER JOIN NHANVIEN AS NV ON NV.ID_NV = HD.ID_NV WHERE ID_HDCT = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, MaHDCT);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                txtMaHD.setText(rs.getString(2));
                DateBan.setDate(rs.getDate(8));
                cboMaNV.setSelectedItem(rs.getString(15));
//                txtTenNV.setText(rs.getString(13));
                txtMaKH.setText(rs.getString(12));
                txtTenKH.setText(rs.getString(13));
                txtSDT.setText(rs.getString(14));
                cboMaSP.setSelectedItem(rs.getString(3));
                txtSoLuong.setText(rs.getInt(7) + "");
                txtGiamGia.setText(rs.getLong(10) + "");
                txtThanhTien.setText(rs.getLong(11) + "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Ma_HDCT = MaHDCT;
        soluong = Integer.valueOf(txtSoLuong.getText());
        MaSP = cboMaSP.getSelectedItem().toString();
        lblsl = Integer.valueOf(lblSL.getText().substring(5));

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

    protected void fetechMaNV() {
        String query = "SELECT ID_NV FROM NHANVIEN";

        try {

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            cboMaNV.removeAllItems();
            while (rs.next()) {
                cboMaNV.addItem(rs.getString("ID_NV"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void fetchMaSP() {
        String query = "SELECT * FROM SANPHAM";
        List<Object> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            cboMaSP.removeAllItems();
            while (rs.next()) {
                cboMaSP.addItem(rs.getString("ID_SP"));
            }
//            Set<Object> listout = new HashSet<Object>(list);
//            List<Object> listadd = new ArrayList<>(listout);
//            for (int i = 0; i < listadd.size(); i++) {
//                cboMaSP.addItem(listadd.get(i).toString());
//                
//            }
//            System.out.println(listadd.size());
//            cboMaSP.setSelectedIndex(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void unEnditable() {
        txtMaHD.setEditable(false);
        DateBan.setEnabled(true);
        cboMaNV.setEnabled(true);
        txtMaKH.setEditable(false);
        txtTenKH.setEditable(true);
        txtSDT.setEnabled(true);
        cboMaSP.setEnabled(true);
        cboTenSP.setEnabled(true);
        txtGiaSP.setEditable(true);
        cboMauSac.setEnabled(true);
        cboSize.setEnabled(true);
        txtGiamGia.setEditable(true);
//        txtThanhTien.setEditable(true);
        txtTenNV.setEditable(true);
        txtSDT.setEditable(true);
        txtSoLuong.setEditable(true);
    }

    protected void Reset() {
        cboMaSP.setSelectedIndex(-1);
        cboTenSP.setSelectedIndex(-1);
        cboMauSac.setSelectedIndex(-1);
        cboSize.setSelectedIndex(-1);
        txtSoLuong.setText("");
        txtGiaSP.setText("");
        txtGiamGia.setText("");
        txtThanhTien.setText("");
    }

    private boolean checkSoDT() {
        String parrent = "0\\d{9}";
        String sdt = txtSDT.getText();
        try {
            Long checkSDT = Long.parseLong(sdt);
            if (!txtSDT.getText().matches(parrent)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 chữ số là bắt đầu bằng chữ số 0");
                txtSDT.requestFocus();
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải các chữ số");
            txtSDT.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkSo() {
        String GiaSP = txtGiaSP.getText();
        try {
            double CheckGia = Double.parseDouble(GiaSP);
            if (CheckGia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá sản phẩm không được âm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtGiaSP.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm phải là số", "Type error", JOptionPane.ERROR_MESSAGE);
            txtGiaSP.requestFocus();
            return false;
        }

        String SoLuong = txtSoLuong.getText();
        try {
            double CheckSL = Double.parseDouble(SoLuong);
            if (CheckSL <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không được âm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtSoLuong.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải là số", "Type error", JOptionPane.ERROR_MESSAGE);
            txtSoLuong.requestFocus();
            return false;
        }

        String GiamGia = txtGiamGia.getText();
        try {
            double checkGiamGia = Double.parseDouble(GiamGia);
            if (checkGiamGia < 0) {
                JOptionPane.showMessageDialog(this, "Giảm giá sản phẩm không được âm", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtGiamGia.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giảm giá sản phẩm phải là số", "Type error", JOptionPane.ERROR_MESSAGE);
            txtGiamGia.requestFocus();
            return false;
        }
//        String ThanhTien = txtThanhTien.getText();
//        try {
//            double checkTT = Double.parseDouble(ThanhTien);
//            if (checkTT < 0) {
//                JOptionPane.showMessageDialog(this, "Thành tiền không được âm", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                txtThanhTien.requestFocus();
//                return false;
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Thành tiền phải là số", "Type error", JOptionPane.ERROR_MESSAGE);
//            txtThanhTien.requestFocus();
//            return false;
//        }
        return true;
    }

    private boolean checkNull() {
        if (txtMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtMaHD.requestFocus();
            return false;
        } else if (DateBan.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "Ngày bán chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            DateBan.requestFocus();
            return false;
        } else if (cboMaNV.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên chưa được chọn", "Text Empty", JOptionPane.ERROR_MESSAGE);
            cboMaNV.requestFocus();
            return false;
        } else if (txtTenNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtTenNV.requestFocus();
            return false;
        } else if (txtMaKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtMaKH.requestFocus();
            return false;
        } else if (txtTenKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtTenKH.requestFocus();
            return false;
        } else if (txtSDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        } else if (cboMaSP.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm chưa được chọn", "Text Empty", JOptionPane.ERROR_MESSAGE);
            cboMaSP.requestFocus();
            return false;
        } else if (cboTenSP.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm chưa được chọn", "Text Empty", JOptionPane.ERROR_MESSAGE);
            cboTenSP.requestFocus();
            return false;
        } else if (txtGiaSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm chưa được chọn", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtGiaSP.requestFocus();
            return false;
        } else if (txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtSoLuong.requestFocus();
            return false;
        } else if (cboMauSac.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Màu sắc sản phẩm chưa được chọn", "Text Empty", JOptionPane.ERROR_MESSAGE);
            cboMauSac.requestFocus();
            return false;
        } else if (txtGiamGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giảm giá sản phẩm chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtGiamGia.requestFocus();
            return false;
        } else if (cboSize.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Size sản phẩm chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            cboSize.requestFocus();
            return false;
        } else if (txtThanhTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thành tiền sản phẩm chưa được nhập", "Text Empty", JOptionPane.ERROR_MESSAGE);
            txtThanhTien.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        DateBan = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cboMaNV = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboMaSP = new javax.swing.JComboBox<>();
        cboTenSP = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtGiaSP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        lblSL = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(1225, 500));

        jPanel1.setBackground(new java.awt.Color(234, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1225, 500));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblTitle.setText("Quản Lí Bán Hàng");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(234, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ngày bán");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tên nhân viên");

        txtTenNV.setEditable(false);
        txtTenNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        DateBan.setDateFormatString("yyyy-MM-dd");
        DateBan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        cboMaNV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMaNV.setEnabled(false);
        cboMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(49, 49, 49)
                            .addComponent(DateBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(DateBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboMaNV, jLabel3});

        jPanel3.setBackground(new java.awt.Color(234, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Mã khách hàng");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Tên khách hàng");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Số điện thoại");

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtTenKH.setEditable(false);
        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtMaKH.setEditable(false);
        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(txtTenKH)
                    .addComponent(txtSDT))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(234, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Mã sản phẩm");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Số lượng");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Tên sản phẩm");

        cboMaSP.setBackground(new java.awt.Color(234, 153, 153));
        cboMaSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMaSP.setEnabled(false);
        cboMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaSPActionPerformed(evt);
            }
        });

        cboTenSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboTenSP.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Màu sắc");

        cboMauSac.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMauSac.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Size");

        cboSize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboSize.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Giá sản phẩm");

        txtGiaSP.setEditable(false);
        txtGiaSP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Giảm giá");

        txtGiamGia.setEditable(false);
        txtGiamGia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtGiamGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiamGiaFocusLost(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Thành tiền");

        txtThanhTien.setEditable(false);
        txtThanhTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtThanhTien.setEnabled(false);

        txtSoLuong.setEditable(false);
        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblSL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiaSP))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(67, 67, 67)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiamGia)
                            .addComponent(txtThanhTien))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtGiaSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSoLuong)
                            .addComponent(lblSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboMaSP, jLabel23});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTenSP, jLabel10});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboMauSac, jLabel11});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboSize, jLabel12});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel13, txtGiaSP});

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/save.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/out.png"))); // NOI18N
        btnThoat.setText("Hủy");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave)
                            .addComponent(btnThoat)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSave, btnThoat});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSave, btnThoat});

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void cboMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaSPActionPerformed
        // TODO add your handling code here:
        String query = "SELECT * FROM SANPHAM WHERE ID_SP = ?";

        try {
            cboTenSP.removeAllItems();
            cboMauSac.removeAllItems();
            cboSize.removeAllItems();
            lblSL.setText("");
            if (cboMaSP.getSelectedIndex() == -1) {
                return;
            } else {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, cboMaSP.getSelectedItem().toString());

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    long Gia = rs.getLong("GIABAN");
                    cboTenSP.addItem(rs.getNString("TEN_SP"));
                    cboMauSac.addItem(rs.getNString("MAUSAC"));
                    cboSize.addItem(rs.getInt("SIZE") + "");
                    txtGiaSP.setText(Gia + "");
                    lblSL.setText("Còn: " + rs.getInt("SOLUONG"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboMaSPActionPerformed

    private void txtGiamGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiamGiaFocusLost
        // TODO add your handling code here:
        if (!txtSoLuong.getText().isEmpty() && !txtGiamGia.getText().isEmpty() && checkSo()) {
            int GiaSP = Integer.parseInt(txtGiaSP.getText());
            int Discount = Integer.parseInt(txtGiamGia.getText());
            int SoLuong = Integer.parseInt(txtSoLuong.getText());
            long TT = 0;
            TT = (GiaSP * SoLuong) - Discount;

            txtThanhTien.setText(TT + "");
        }
    }//GEN-LAST:event_txtGiamGiaFocusLost
    protected void updateKH() {
        String update = "UPDATE KHACHHANG SET TEN_KH = ? , PHONE = ? WHERE ID_KH = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(update);

            ps.setNString(1, txtTenKH.getText());
            ps.setString(2, txtSDT.getText());
            ps.setString(3, txtSDT.getText());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update khách hàng lỗi");
            return;
        }
    }

    protected void updateHD() {
        String update = "UPDATE HOADON SET ID_NV = ? WHERE ID_HD = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(update);

            ps.setInt(1, cboMaNV.getSelectedIndex());
            ps.setString(2, txtMaHD.getText());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi update Hóa đơn");
            return;
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (checkNull() && checkSoDT() && checkSo()) {
            if (lblSL.getText().equalsIgnoreCase("0")) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã hết hàng");
                return;
            } else if (checkSL()) {
                try {
                    updateKH();
                    updateHD();
                    String query_HDCT = "UPDATE HOADON_CHITIET \n"
                            + "SET ID_HD = ?, ID_SP = ?, TEN_SP = ?, MAUSAC = ?, SIZE = ?, SOLUONG = ?, NGAYMUA = ?, \n"
                            + "GIA = ?, DISCOUNT = ?, THANHTIEN = ? \n"
                            + "WHERE ID_HDCT = ?";
//                    txtMaHD.setEditable(false);
                    String query_UD = "UPDATE SANPHAM SET SOLUONG = ? WHERE ID_SP = ?";
                    ResultSet rs;
                    int load = 0;
                    PreparedStatement ps = conn.prepareStatement(query_HDCT);
                    ps.setString(1, txtMaHD.getText());
                    ps.setString(2, cboMaSP.getSelectedItem().toString());
                    ps.setNString(3, cboTenSP.getSelectedItem().toString());
                    ps.setNString(4, cboMauSac.getSelectedItem().toString());
                    ps.setInt(5, Integer.valueOf(cboSize.getSelectedItem().toString()));
                    ps.setInt(6, Integer.valueOf(txtSoLuong.getText()));
                    ps.setString(7, sdf.format(DateBan.getDate()));
                    ps.setLong(8, Long.valueOf(txtGiaSP.getText()));
                    ps.setLong(9, Long.valueOf(txtGiamGia.getText()));
                    ps.setLong(10, Long.valueOf(txtThanhTien.getText()));
                    ps.setInt(11, Ma_HDCT);

                    ps.execute();
                    try {
                        String new_masp = cboMaSP.getSelectedItem().toString();
                        int sl;
                        ps = conn.prepareStatement(query_UD);
                        if (new_masp.equalsIgnoreCase(MaSP)) {
                            sl = (Integer.valueOf(lblSL.getText().substring(5)) + soluong)
                                    - Integer.valueOf(txtSoLuong.getText());
                            ps.setInt(1, sl);
                            ps.setString(2, cboMaSP.getSelectedItem().toString());

                            ps.execute();
                        } else {
                            sl = Integer.valueOf(lblSL.getText().substring(5)) - Integer.valueOf(txtSoLuong.getText());
                            ps.setInt(1, sl);
                            ps.setString(2, cboMaSP.getSelectedItem().toString());

                            ps.execute();

                            ps.clearParameters();

                            sl = lblsl + soluong;
                            ps.setInt(1, sl);
                            ps.setString(2, MaSP);
                            ps.execute();

                            ps.clearParameters();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Lỗi update mã sản phẩm");
                        return;
                    }

                    String sql_TT = "SELECT SUM(THANHTIEN) FROM HOADON_CHITIET WHERE ID_HD = ?\n"
                            + "GROUP BY ID_HD";
                    String sql_HD_TT = "UPDATE HOADON SET TONGTIEN = ? WHERE ID_HD = ?";
                    try {
                        ps = conn.prepareStatement(sql_TT);
                        ps.setString(1, txtMaHD.getText());

                        rs = ps.executeQuery();
                        long sum = 0;
                        while (rs.next()) {
                            sum = rs.getLong(1);
                        }

                        ps = conn.prepareStatement(sql_HD_TT);
                        ps.setLong(1, sum);
                        ps.setString(2, txtMaHD.getText());

                        ps.execute();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Lỗi update thành tiền");
                        return;
                    }

                    JOptionPane.showMessageDialog(this, "Update thành công");

                    thongtin_hoadon tt_hd = new thongtin_hoadon();

                    this.getDesktopPane().add(tt_hd);
                    tt_hd.setLocation(this.getDesktopPane().getWidth() / 2 - tt_hd.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - tt_hd.getHeight() / 2);
                    tt_hd.setVisible(true);

                    this.dispose();

                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    protected boolean checkSL() {
        int sln = Integer.parseInt(txtSoLuong.getText());
        int slt = Integer.parseInt(lblSL.getText().substring(5));
        System.out.println(slt);
        if (sln > slt) {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ");
            txtSoLuong.requestFocus();
            return false;
        }
        return true;
    }

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        thongtin_hoadon tt_hd = new thongtin_hoadon();

        this.getDesktopPane().add(tt_hd);
        tt_hd.setLocation(this.getDesktopPane().getWidth() / 2 - tt_hd.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - tt_hd.getHeight() / 2);
        tt_hd.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void cboMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaNVActionPerformed
        // TODO add your handling code here:
        fill();
    }//GEN-LAST:event_cboMaNVActionPerformed

    private void fill() {
        String query = "SELECT * FROM NHANVIEN WHERE ID_NV = ?";

        try {
            if (cboMaNV.getSelectedIndex() == -1) {
                return;
            } else {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, cboMaNV.getSelectedItem().toString());

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    txtTenNV.setText(rs.getString("TEN_NV"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateBan;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboMaNV;
    private javax.swing.JComboBox<String> cboMaSP;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtGiaSP;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
