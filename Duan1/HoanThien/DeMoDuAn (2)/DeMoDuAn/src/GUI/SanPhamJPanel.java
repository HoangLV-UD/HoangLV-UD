/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DanhMucDao;
import DAO.DonViDao;
import DAO.LoaiHangDao;
import DAO.MauSacDao;
import DAO.SanPhamDao;
import DAO.SizeDao;
import Entity.DanhMuc;
import Entity.DonVi;
import Entity.LoaiHang;
import Entity.MauSac;
import Entity.SanPham;
import Entity.Size;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class SanPhamJPanel extends javax.swing.JPanel {

    DanhMucDao dmDao = new DanhMucDao();
    MauSacDao msDao = new MauSacDao();
    SizeDao sDao = new SizeDao();
    LoaiHangDao lhDao = new LoaiHangDao();
    DonViDao dvDao = new DonViDao();
    SanPhamDao spDao = new SanPhamDao();

    public SanPhamJPanel() {
        initComponents();
        innit();
    }

    public void innit() {
        fillCbbTenSp();
        fillCbbLoaiSp();
        fillCbbMauSp();
        fillCbbSizeSp();
        fillCbbDonViSp();
        fillTableSanPham();
        maTuTang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pnlCapNhat = new javax.swing.JPanel();
        txtMaSp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rbBHD = new javax.swing.JRadioButton();
        rdbTN = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        btnThemSize = new javax.swing.JButton();
        btnThemDonVi = new javax.swing.JButton();
        btnThemmMS = new javax.swing.JButton();
        btnThemLoai = new javax.swing.JButton();
        btnThemDanhMuc = new javax.swing.JButton();
        cbbDonVi = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaGhichu = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        txtTenSP = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1200, 890));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Mã sản phẩm:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Màu sắc:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Loại sản phẩm:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Size:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Đơn giá:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Số lượng:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Trạng thái:");

        buttonGroup1.add(rbBHD);
        rbBHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rbBHD.setText("Hoạt động");

        buttonGroup1.add(rdbTN);
        rdbTN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdbTN.setText("Tạm ngưng");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Ghi chú:");

        btnThemSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add1x.png"))); // NOI18N
        btnThemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSizeActionPerformed(evt);
            }
        });

        btnThemDonVi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add1x.png"))); // NOI18N
        btnThemDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDonViActionPerformed(evt);
            }
        });

        btnThemmMS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add1x.png"))); // NOI18N
        btnThemmMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemmMSActionPerformed(evt);
            }
        });

        btnThemLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add1x.png"))); // NOI18N
        btnThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiActionPerformed(evt);
            }
        });

        btnThemDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add1x.png"))); // NOI18N
        btnThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDanhMucActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnLamMoi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Đơn vị:");

        jtaGhichu.setColumns(20);
        jtaGhichu.setRows(5);
        jScrollPane1.setViewportView(jtaGhichu);

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(txtMaSp))
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlCapNhatLayout.createSequentialGroup()
                            .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))))
                            .addGap(41, 41, 41)
                            .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbbMauSac, javax.swing.GroupLayout.Alignment.LEADING, 0, 313, Short.MAX_VALUE)
                                .addComponent(cbbLoaiSP, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbDonVi, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(42, 42, 42)
                            .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(btnThemmMS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(btnThemSize)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(rbBHD)
                        .addGap(18, 18, 18)
                        .addComponent(rdbTN)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnThemDonVi)
                                    .addComponent(btnThemDanhMuc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(btnThemLoai)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel9)
                                .addGap(28, 28, 28)))
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnThemDanhMuc)
                                    .addComponent(jLabel2)))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(btnThemLoai)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(cbbMauSac)
                            .addComponent(btnThemmMS, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5)
                        .addComponent(cbbSize)
                        .addComponent(btnThemSize, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(rbBHD)
                        .addComponent(rdbTN)))
                .addGap(20, 20, 20)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cbbDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThemDonVi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton4.setText("Tìm kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Màu sắc", "Size", "Đơn vị", "Đơn giá", "Số lượng", "Trạng thái", "Ghi chú"
            }
        ));
        jScrollPane2.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        fillTableTimKiem();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clerarForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDanhMucActionPerformed
        DanhmucJDialog jdl = new DanhmucJDialog(null, true);
        jdl.setVisible(true);
        fillCbbTenSp();
    }//GEN-LAST:event_btnThemDanhMucActionPerformed

    private void btnThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiActionPerformed
       LoaiSPJDialog jdl = new LoaiSPJDialog(null, true);
       jdl.setVisible(true);
       fillCbbLoaiSp();
    }//GEN-LAST:event_btnThemLoaiActionPerformed

    private void btnThemmMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemmMSActionPerformed
        MauSacJDialog jdl = new MauSacJDialog(null, true);
        jdl.setVisible(true);
        fillCbbMauSp();
    }//GEN-LAST:event_btnThemmMSActionPerformed

    private void btnThemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSizeActionPerformed
        SizeJDialog jdl = new SizeJDialog(null, true);
        jdl.setVisible(true);
        fillCbbSizeSp();
    }//GEN-LAST:event_btnThemSizeActionPerformed

    private void btnThemDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDonViActionPerformed
       DonViJDialog JDL = new DonViJDialog(null, true);
       JDL.setVisible(true);
       fillCbbDonViSp();
    }//GEN-LAST:event_btnThemDonViActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnThemDonVi;
    private javax.swing.JButton btnThemLoai;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnThemmMS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JComboBox<String> cbbDonVi;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jtaGhichu;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JRadioButton rbBHD;
    private javax.swing.JRadioButton rdbTN;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables

    public void fillCbbTenSp() {
        DefaultComboBoxModel modelCb = (DefaultComboBoxModel) cbbDanhMuc.getModel();
        modelCb.removeAllElements();
        List<DanhMuc> list = dmDao.selectAll();
        for (DanhMuc danhMuc : list) {
            modelCb.addElement(danhMuc.getTenDm());
        }

    }

    public void fillCbbLoaiSp() {
        DefaultComboBoxModel modelCb = (DefaultComboBoxModel) cbbLoaiSP.getModel();
        modelCb.removeAllElements();
        List<LoaiHang> list = lhDao.selectAll();
        for (LoaiHang lh : list) {
            modelCb.addElement(lh.getTenLoai());
        }

    }

    public void fillCbbMauSp() {
        DefaultComboBoxModel modelCb = (DefaultComboBoxModel) cbbMauSac.getModel();
        modelCb.removeAllElements();
        List<MauSac> list = msDao.selectAll();
        for (MauSac ms : list) {
            modelCb.addElement(ms.getTenMau());
        }

    }

    public void fillCbbSizeSp() {
        DefaultComboBoxModel modelCb = (DefaultComboBoxModel) cbbSize.getModel();
        modelCb.removeAllElements();
        List<Size> list = sDao.selectAll();
        for (Size size : list) {
            modelCb.addElement(size.getTenSize());
        }

    }
    public void fillCbbDonViSp() {
        DefaultComboBoxModel modelCb = (DefaultComboBoxModel) cbbDonVi.getModel();
        modelCb.removeAllElements();
        List<DonVi> list = dvDao.selectAll();
        for (DonVi dv : list) {
            modelCb.addElement(dv.getTenDon_vi());
        }

    }

    public void fillTableSanPham() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        
        try {
            List<SanPham> list = spDao.selectAll();
//            List<SanPham> list = spDao.selectByKeyword(dmDao.selectTenDM(txtTenSP.getText()).getMaDm()); 

            for(SanPham sp : list){
                model.addRow(new Object[]{
                    sp.getMaSp(),
                    dmDao.selectID(sp.getMaDm()).getTenDm(),
                    lhDao.selectID(sp.getMaLH()).getTenLoai(),
                    msDao.selectID(sp.getMaMau()).getTenMau(),
                    sDao.selectID(sp.getMaSize()).getTenSize(),
                    dvDao.selectID(sp.getMaDv()).getTenDon_vi(),
                    sp.getDonGia(),
                    sp.getSoLuong(),
                    sp.isTrangThai() ? "Hoạt động" : "Hết hàng",
                    sp.getGhiChu()
                });
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi fill Sanpham");
        }

    }
    private SanPham getForm(){
        SanPham sp = new SanPham();
        sp.setMaSp(txtMaSp.getText());
        sp.setMaDm(dmDao.selectTenDM(cbbDanhMuc.getSelectedItem().toString()).getMaDm());
        sp.setMaLH(lhDao.selectTenLH(cbbLoaiSP.getSelectedItem().toString()).getMaLoai());
        sp.setMaMau(msDao.selectTenMau(cbbMauSac.getSelectedItem().toString()).getMaMau());
        sp.setMaSize(sDao.selectTenSize(cbbSize.getSelectedItem().toString()).getMaSize());
        sp.setMaDv(dvDao.selectTenDV(cbbDonVi.getSelectedItem().toString()).getMaDon_vi());
        sp.setDonGia(Float.parseFloat(txtDonGia.getText()));
        sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        sp.setTrangThai(rdbTN.isSelected());
       sp.setGhiChu(jtaGhichu.getText());
        return sp;
    }
    private void setForm(SanPham sp){
        txtMaSp.setText(sp.getMaSp());
        cbbDanhMuc.setSelectedItem(dmDao.selectID(sp.getMaDm()).getTenDm());
        cbbLoaiSP.setSelectedItem(lhDao.selectID(sp.getMaLH()).getTenLoai());
        cbbMauSac.setSelectedItem(msDao.selectID(sp.getMaMau()).getTenMau());
        cbbSize.setSelectedItem(sDao.selectID(sp.getMaSize()).getTenSize());
        cbbDonVi.setSelectedItem(dvDao.selectID(sp.getMaDv()).getTenDon_vi());
        txtDonGia.setText(String.valueOf(sp.getDonGia()));
        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        rdbTN.setSelected(!sp.isTrangThai());
        rbBHD.setSelected(sp.isTrangThai());
        jtaGhichu.setText(sp.getGhiChu());
    }
    public void maTuTang() {
        if (spDao.selectAll().isEmpty()) {
            txtMaSp.setText("SP1");
        } else {
            txtMaSp.setText("SP" + (spDao.select_Max_id_java() + 1));
        }
    }
    public void clerarForm(){
        txtMaSp.setText("");
        cbbDanhMuc.setSelectedIndex(0);
        cbbLoaiSP.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        cbbDonVi.setSelectedIndex(0);
        txtDonGia.setText("");
        txtSoLuong.setText("");
        rbBHD.setSelected(true);
        jtaGhichu.setText("");
        maTuTang();
    }
    public void insert(){
        try {
            SanPham sp = getForm();
            spDao.insert(sp);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công");    
            clerarForm();
            fillTableSanPham();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi insert");
        }
    }
    public void update(){
        try {
            SanPham sp = getForm();
            spDao.update(sp);
            JOptionPane.showMessageDialog(this, "Cập nhật mới thành công");    
            clerarForm();
            fillTableSanPham();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi update");
        }
    }
    public void fillTableTimKiem() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        
        try {
//            List<SanPham> list = spDao.selectAll();
            List<SanPham> list = spDao.selectByTenDanhMuc(txtTenSP.getText());
            for(SanPham sp : list){
                model.addRow(new Object[]{
                    sp.getMaSp(),
                    dmDao.selectID(sp.getMaDm()).getTenDm(),
                    lhDao.selectID(sp.getMaLH()).getTenLoai(),
                    msDao.selectID(sp.getMaMau()).getTenMau(),
                    sDao.selectID(sp.getMaSize()).getTenSize(),
                    dvDao.selectID(sp.getMaDv()).getTenDon_vi(),
                    sp.getDonGia(),
                    sp.getSoLuong(),
                    sp.isTrangThai() ? "Hoạt động" : "Hết hàng",
                    sp.getGhiChu()
                });
                
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi fill Sanpham");
        }

    }
}
