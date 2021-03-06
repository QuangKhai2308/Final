/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.TTNhanVien;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ADMIN
 */
public class Signup extends javax.swing.JInternalFrame {

    /**
     * Creates new form Signup
     */
    String patch = "";
    String name = "Tải lên";
    String user = "sa";
    String password = "123456";
    String url = "jdbc:sqlserver://localhost:1433;databaseName = QLBH";

    Connection conn;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    List<TTNhanVien> ListNV = new ArrayList<>();

    public Signup() {
        initComponents();
        conn = getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTailen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboGT = new javax.swing.JComboBox<>();
        cboCV = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnSignup = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();
        txtIcon = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        txtPass = new javax.swing.JPasswordField();
        txtComfirm = new javax.swing.JPasswordField();
        showPass = new javax.swing.JLabel();
        showCòmirm = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 610));

        jPanel1.setBackground(new java.awt.Color(234, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel1.setText("ĐĂNG KÍ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ảnh");

        txtTailen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTailen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTailen.setText("Tải lên");
        txtTailen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTailenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTailenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTailenMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tên");

        txtTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Ngày sinh");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Giới tính");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Chức vụ");

        cboGT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboGT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cboGT.setSelectedIndex(-1);

        cboCV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Admin" }));
        cboCV.setSelectedIndex(-1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("User");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Pass");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Comfirm Pass");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Email");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Số điện thoại");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSignup.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSignup.setText("Sign up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnHuy.setText("Cannel");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtIcon.setBackground(new java.awt.Color(255, 255, 255));
        txtIcon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/circle1.png"))); // NOI18N

        NgaySinh.setDateFormatString("yyyy-MM-dd");
        NgaySinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtComfirm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/show.png"))); // NOI18N
        showPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showPassMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showPassMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showPassMousePressed(evt);
            }
        });

        showCòmirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/show.png"))); // NOI18N
        showCòmirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showCòmirmMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showCòmirmMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showCòmirmMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 209, Short.MAX_VALUE)
                        .addComponent(btnSignup)
                        .addGap(76, 76, 76)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(cboGT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen)
                            .addComponent(cboCV, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtComfirm)
                            .addComponent(txtEmail)
                            .addComponent(txtSDT)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showCòmirm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTailen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnSignup});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTailen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showCòmirm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {NgaySinh, jLabel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, txtPass});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, txtComfirm});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    private void txtTailenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTailenMouseClicked
        // TODO add your handling code here:
        JFileChooser jfc = null;

        try {
            jfc = new JFileChooser();
            jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
            FileNameExtensionFilter exten = new FileNameExtensionFilter("*Images", "jpg", "png", "jpeg");
            jfc.addChoosableFileFilter(exten);

            int select = jfc.showOpenDialog(this);
            if (select == JFileChooser.APPROVE_OPTION) {
                patch = jfc.getSelectedFile().getAbsolutePath();

                ImageIcon icon = new ImageIcon(patch);
                Image img = icon.getImage();
                Image new_img = img.getScaledInstance(txtIcon.getWidth(), txtIcon.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon h = new ImageIcon(new_img);

                txtIcon.setIcon(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtTailenMouseClicked

    private void txtTailenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTailenMouseEntered
        // TODO add your handling code here:
        txtTailen.setForeground(Color.BLUE.darker());
        txtTailen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtTailen.setText("<html><a style = 'text-decoration: underline;' href = ''>" + name + "</html>");
    }//GEN-LAST:event_txtTailenMouseEntered

    private void txtTailenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTailenMouseExited
        txtTailen.setText(name);
    }//GEN-LAST:event_txtTailenMouseExited
    protected boolean checkNull() {
        if (txtTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên chưa được nhập");
            txtTen.requestFocus();
            return false;
        } else if (NgaySinh.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "Ngày sinh chưa được nhập");
            NgaySinh.requestFocus();
            return false;
        } else if (txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ chưa được nhập");
            txtDiaChi.requestFocus();
            return false;
        } else if (cboGT.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Giới tính chưa được chọn");
            cboGT.requestFocus();
            return false;
        } else if (cboGT.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Giới tính chưa được chọn");
            cboGT.requestFocus();
            return false;
        } else if (cboCV.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Chức vụ chưa được chọn");
            cboCV.requestFocus();
            return false;
        } else if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User chưa được nhập");
            txtUser.requestFocus();
            return false;
        } else if (txtUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User chưa được nhập");
            txtUser.requestFocus();
            return false;
        } else if (txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password chưa được nhập");
            txtPass.requestFocus();
            return false;
        } else if (txtComfirm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Comfirm password chưa được nhập");
            txtComfirm.requestFocus();
            return false;
        } else if (txtComfirm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Comfirm password chưa được nhập");
            txtComfirm.requestFocus();
            return false;
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email chưa được nhập");
            txtEmail.requestFocus();
            return false;
        } else if (txtSDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại chưa được nhập");
            txtSDT.requestFocus();
            return false;
        }
        return true;
    }

    protected boolean checkEmail() {
        if (!txtEmail.getText().contains("@")) {
            JOptionPane.showMessageDialog(this, "Email phải chứa @");
            txtEmail.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    protected boolean checkSDT() {
        String txt = "0\\d{9}";
        String sdt = this.txtSDT.getText();

        try {
            Long checkSDT = Long.parseLong(sdt);
            if (!txtSDT.getText().matches(txt)) {
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

    protected boolean checkUser() {
        String query = "SELECT * FROM NHANVIEN WHERE USERS = ? AND CHUCVU = ?";
        boolean check = false;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, txtUser.getText());
            ps.setString(2, cboCV.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Người dùng đã tồn tại");
                check = false;
            } else {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    protected boolean checkPass() {
        if (String.valueOf(txtPass.getPassword()).equals(String.valueOf(txtComfirm.getPassword()))) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Password không khớp");
            return false;
        }
    }
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        String query = "INSERT INTO NHANVIEN VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        if (checkNull() && checkEmail() && checkSDT() && checkPass() && checkUser()) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setNString(1, txtTen.getText());
                ps.setString(2, sdf.format(NgaySinh.getDate()));
                ps.setNString(3, txtDiaChi.getText());
                ps.setNString(4, cboGT.getSelectedItem().toString());
                ps.setNString(5, txtUser.getText());
                ps.setNString(6, String.valueOf(txtPass.getPassword()));
                ps.setString(7, txtEmail.getText());
                ps.setString(8, txtSDT.getText());
                ps.setNString(9, cboCV.getSelectedItem().toString());
                ps.setString(10, patch);

                ps.execute();
                JOptionPane.showMessageDialog(this, "Đăng kí thành công");
                Clear();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
//        Login lg = new Login();
//        this.getDesktopPane().add(lg);
//        lg.setVisible(true);
//        lg.setLocation(this.getDesktopPane().getWidth() / 2 - lg.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - lg.getHeight() / 2);
//        this.dispose();
        Clear();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void showPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMouseClicked
        // TODO add your handling code here:
        txtPass.setEchoChar('*');
    }//GEN-LAST:event_showPassMouseClicked

    private void showPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMouseExited
        // TODO add your handling code here:
        txtPass.setEchoChar('*');
    }//GEN-LAST:event_showPassMouseExited

    private void showPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMousePressed
        // TODO add your handling code here:
        txtPass.setEchoChar((char) 0);
    }//GEN-LAST:event_showPassMousePressed

    private void showCòmirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showCòmirmMouseClicked
        // TODO add your handling code here:
        txtComfirm.setEchoChar('*');
    }//GEN-LAST:event_showCòmirmMouseClicked

    private void showCòmirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showCòmirmMouseExited
        // TODO add your handling code here:
        txtComfirm.setEchoChar('*');
    }//GEN-LAST:event_showCòmirmMouseExited

    private void showCòmirmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showCòmirmMousePressed
        // TODO add your handling code here:
        txtComfirm.setEchoChar((char) 0);
    }//GEN-LAST:event_showCòmirmMousePressed
    protected void Clear() {
        Path path = Paths.get("Agile/src/Icons/circle1.png");  
        patch = "../Agile/src/Icons/circle1.png";
        ImageIcon icon = new ImageIcon(patch);
        System.out.println(patch);
        txtIcon.setIcon(icon);
        txtTen.setText("");
        NgaySinh.setDate(null);
        txtDiaChi.setText("");
        cboGT.setSelectedIndex(-1);
        cboCV.setSelectedIndex(-1);
        txtUser.setText("");
        txtPass.setText("");
        txtComfirm.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSignup;
    private javax.swing.JComboBox<String> cboCV;
    private javax.swing.JComboBox<String> cboGT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel showCòmirm;
    private javax.swing.JLabel showPass;
    private javax.swing.JPasswordField txtComfirm;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtIcon;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JLabel txtTailen;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
