/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DanhMucDao;
import DAO.DonViDao;
import DAO.CTHoaDonDao;
import DAO.HoaDonDao;
import DAO.KhachHangDao;
import DAO.LoaiHangDao;
import DAO.MauSacDao;
import DAO.SanPhamDao;
import DAO.SizeDao;
import Entity.CTHoaDon;
import Entity.DanhMuc;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.SanPham;
import JDBC.Auth;
import JDBC.ClockThread;
import JDBC.JdbcHelper;
import JDBC.MsgBox;
import JDBC.XDate;
import JDBC.Xmoney;
import java.awt.Label;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class BanHangJPanel extends javax.swing.JPanel {

    SanPhamDao daoSP = new SanPhamDao();
    DanhMucDao daoDM = new DanhMucDao();
    MauSacDao daoMS = new MauSacDao();
    SizeDao daoSize = new SizeDao();
    DonViDao daoDv = new DonViDao();
    KhachHangDao daoKH = new KhachHangDao();
    LoaiHangDao daoLH = new LoaiHangDao();
    HoaDonDao daoHD = new HoaDonDao();
    CTHoaDonDao daoct = new CTHoaDonDao();
    NhanVien nvac = Auth.user;

    /**
     * Creates new form BanHangJPanel
     */
    public BanHangJPanel() {
        initComponents();
        init();
        fillTableSanPham();
        fillTableHoaDon(0);

    }

    private void init() {
//        getDateNow();
        ClockThread th = new ClockThread(lblNgayTao);
        th.start();
        lblNhanVien.setText(nvac.getHo_ten());
        maTuTang();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        pmnCTHD = new javax.swing.JPopupMenu();
        mniSua = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTHoaDon = new javax.swing.JTable();
        btnClearGioHang = new javax.swing.JButton();
        btnXoaCTHD = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnCapNhattt = new javax.swing.JButton();
        txtTkHD = new javax.swing.JTextField();
        btnTkHD = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTKSanPham = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        txtTKKH = new javax.swing.JTextField();
        btnTimKH = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        txtSDTKH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jpnThanhToan = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtKhachTra = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rdbTienMat1 = new javax.swing.JRadioButton();
        rdbChuyenKhoan1 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txtGhiChu1 = new javax.swing.JTextField();
        jckChoTT = new javax.swing.JCheckBox();
        btnThanhToan = new javax.swing.JButton();
        btnTaoMoi1 = new javax.swing.JButton();
        jpnGiaohang = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblTongTien2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblKhachCanTra = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTienShip = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        rdbTienMat2 = new javax.swing.JRadioButton();
        rdbChuyenKhoan2 = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        txtGhiChu2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtadiachi = new javax.swing.JTextArea();
        btnGiaoHang = new javax.swing.JButton();
        btnTaoMoi2 = new javax.swing.JButton();

        mniSua.setText("Sửa");
        mniSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSuaActionPerformed(evt);
            }
        });
        pmnCTHD.add(mniSua);

        setBackground(new java.awt.Color(255, 204, 204));
        setPreferredSize(new java.awt.Dimension(1200, 890));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblCTHoaDon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCTHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblCTHoaDon.setComponentPopupMenu(pmnCTHD);
        tblCTHoaDon.setRowHeight(22);
        tblCTHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHoaDonMouseClicked(evt);
            }
        });
        tblCTHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCTHoaDonKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTHoaDon);

        btnClearGioHang.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnClearGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_reset.png"))); // NOI18N
        btnClearGioHang.setText("Làm mới giỏ hàng");
        btnClearGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHangActionPerformed(evt);
            }
        });

        btnXoaCTHD.setBackground(new java.awt.Color(255, 255, 255));
        btnXoaCTHD.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnXoaCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_delete.png"))); // NOI18N
        btnXoaCTHD.setText("Bỏ khỏi giỏ hàng");
        btnXoaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTHDActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_screen.png"))); // NOI18N
        jButton5.setText("Quét mã");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(btnClearGioHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaCTHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Tên khách hàng", "Thành tiền", "Trạng thái", "GhiChú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setRowHeight(22);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        cbbTrangThai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hóa đơn chờ", "Đã thanh toán", "Chờ lấy hàng", "Đang giao", "Giao thành công", "Hủy" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Trạng thái");

        btnCapNhattt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCapNhattt.setText("Cập nhật trạng thái");
        btnCapNhattt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatttActionPerformed(evt);
            }
        });

        btnTkHD.setText("Tìm kiếm");
        btnTkHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTkHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhattt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(txtTkHD, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnTkHD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTkHD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTkHD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCapNhattt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tblSanPham.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Màu", "Size", "Loại hàng", "Đơn vị", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setRowHeight(22);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTKSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTKSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo hóa đơn"));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chung"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Nhân viên:");

        lblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNhanVien.setText("nv1");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Ngày tạo:");

        lblNgayTao.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblNgayTao.setText("dd/MM/yyyy");

        txtTKKH.setToolTipText("");

        btnTimKH.setBackground(new java.awt.Color(153, 255, 51));
        btnTimKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_search1x.png"))); // NOI18N
        btnTimKH.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });

        btnThemKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_add1x.png"))); // NOI18N
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Họ tên:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("SDT:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Mã hóa đơn:");

        lblMaHD.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblMaHD.setText("hd1");
        lblMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblMaHDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(txtSDTKH))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThemKhachHang))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTKKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKH)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Tổng tiền hàng:");

        lblTongTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTongTien.setText("0");
        lblTongTien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblTongTienKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setText("Khách thanh toán:");

        txtKhachTra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtKhachTra.setText("0");
        txtKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachTraKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Tiền thừa:");

        lblTienThua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 0, 0));
        lblTienThua.setText("0");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setText("Hình thức thanh toán:");

        buttonGroup3.add(rdbTienMat1);
        rdbTienMat1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdbTienMat1.setSelected(true);
        rdbTienMat1.setText("Tiền mặt");

        buttonGroup3.add(rdbChuyenKhoan1);
        rdbChuyenKhoan1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdbChuyenKhoan1.setText("Chuyển khoản");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel18.setText("Ghi chú:");

        jckChoTT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jckChoTT.setText("Chờ thanh toán");
        jckChoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jckChoTTActionPerformed(evt);
            }
        });
        jckChoTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jckChoTTKeyReleased(evt);
            }
        });

        btnThanhToan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoMoi1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTaoMoi1.setText("Tạo mới");
        btnTaoMoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnThanhToanLayout = new javax.swing.GroupLayout(jpnThanhToan);
        jpnThanhToan.setLayout(jpnThanhToanLayout);
        jpnThanhToanLayout.setHorizontalGroup(
            jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(23, 23, 23)
                        .addComponent(txtKhachTra))
                    .addGroup(jpnThanhToanLayout.createSequentialGroup()
                        .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jckChoTT)
                            .addComponent(txtGhiChu1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThanhToanLayout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoMoi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(rdbTienMat1)
                .addGap(29, 29, 29)
                .addComponent(rdbChuyenKhoan1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnThanhToanLayout.setVerticalGroup(
            jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThanhToanLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel17)
                .addGap(31, 31, 31)
                .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTienMat1)
                    .addComponent(rdbChuyenKhoan1))
                .addGap(31, 31, 31)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGhiChu1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jckChoTT)
                .addGap(18, 18, 18)
                .addGroup(jpnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(btnTaoMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("Thanh toán", jpnThanhToan);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setText("Tổng tiền hàng:");

        lblTongTien2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblTongTien2.setText("0");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setText("Khách cần trả:");

        lblKhachCanTra.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblKhachCanTra.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("Tiền ship");

        txtTienShip.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtTienShip.setText("0");
        txtTienShip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienShipKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setText("Hình thức thanh toán:");

        buttonGroup4.add(rdbTienMat2);
        rdbTienMat2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdbTienMat2.setSelected(true);
        rdbTienMat2.setText("Tiền mặt");

        buttonGroup4.add(rdbChuyenKhoan2);
        rdbChuyenKhoan2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rdbChuyenKhoan2.setText("Chuyển khoản");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setText("Ghi chú:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("Địa chỉ");

        jtadiachi.setColumns(20);
        jtadiachi.setRows(5);
        jScrollPane4.setViewportView(jtadiachi);

        btnGiaoHang.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGiaoHang.setText("Giao hàng");
        btnGiaoHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoHangActionPerformed(evt);
            }
        });

        btnTaoMoi2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnTaoMoi2.setText("Tạo mới");
        btnTaoMoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoi2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnGiaohangLayout = new javax.swing.GroupLayout(jpnGiaohang);
        jpnGiaohang.setLayout(jpnGiaohangLayout);
        jpnGiaohangLayout.setHorizontalGroup(
            jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGiaohangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGhiChu2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnGiaohangLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnGiaohangLayout.createSequentialGroup()
                        .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnGiaohangLayout.createSequentialGroup()
                                .addComponent(btnGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaoMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnGiaohangLayout.createSequentialGroup()
                                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnGiaohangLayout.createSequentialGroup()
                                        .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel24))
                                        .addGap(23, 23, 23)
                                        .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblTongTien2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblKhachCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTienShip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel27)
                                    .addGroup(jpnGiaohangLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(rdbTienMat2)
                                        .addGap(29, 29, 29)
                                        .addComponent(rdbChuyenKhoan2))
                                    .addComponent(jLabel28))
                                .addGap(0, 51, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jScrollPane4)))
        );
        jpnGiaohangLayout.setVerticalGroup(
            jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGiaohangLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblTongTien2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblKhachCanTra))
                .addGap(26, 26, 26)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTienMat2)
                    .addComponent(rdbChuyenKhoan2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGhiChu2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnGiaohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTaoMoi2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btnGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabs.addTab("Giao hàng", jpnGiaohang);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabs)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabs))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static String MaSP;
    public static int SoLuong = 1;
    public static boolean Huy = false;
    public static String GhiChu;

    private void tblCTHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHoaDonMouseClicked

    }//GEN-LAST:event_tblCTHoaDonMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        MaSP = tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString();
        String tenSp = tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 1).toString();
        if (evt.getClickCount() >= 1) {
            addSanPhamJDialog jdl = new addSanPhamJDialog(null, true);
            jdl.setVisible(true);
            if (Huy == false) {
                return;
            }

            float thanhTien, donGia;
            donGia = Xmoney.ChuyenTien(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 6).toString());
            thanhTien = donGia * SoLuong;
            addCTHD(MaSP, tenSp, SoLuong, donGia, thanhTien);
            lblTongTien.setText(Xmoney.DinhDangTien(TinhTien()));
            lblTongTien2.setText(Xmoney.DinhDangTien(TinhTien()));
            Huy = false;

        }


    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        // TODO add your handling code here:
        HoaDon hd = daoHD.selectPhone(txtTKKH.getText());
        if (hd != null) {
            txtTenKH.setText(hd.getHo_tenkh());
            txtSDTKH.setText(hd.getSdt_kh());
            jtadiachi.setText(hd.getDiaChi());
        } else {
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
            return;
        }

    }//GEN-LAST:event_btnTimKHActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        themKhachHnagJFrame frame = new themKhachHnagJFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void txtKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachTraKeyReleased
        tinhTienThoi();
    }//GEN-LAST:event_txtKhachTraKeyReleased

    private void mniSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSuaActionPerformed

        int vitri = tblCTHoaDon.getSelectedRow();
        SoLuong = Integer.parseInt(tblCTHoaDon.getValueAt(vitri, 3).toString());
        MaSP = tblCTHoaDon.getValueAt(vitri, 1).toString();
        addSanPhamJDialog jdl = new addSanPhamJDialog(null, true);
        jdl.setResizable(false);
        jdl.setLocationRelativeTo(null);
        jdl.setVisible(true); 

        System.out.println(SoLuong);
        tblCTHoaDon.setValueAt(String.valueOf(SoLuong), vitri, 3);
        float thanhtien = SoLuong * Float.parseFloat(tblCTHoaDon.getValueAt(vitri, 4).toString());
        tblCTHoaDon.setValueAt(String.valueOf(thanhtien), vitri, 5);
        lblTongTien.setText(Xmoney.DinhDangTien(TinhTien()));
        lblTongTien2.setText(Xmoney.DinhDangTien(TinhTien()));
    }//GEN-LAST:event_mniSuaActionPerformed

    private void btnXoaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTHDActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) tblCTHoaDon.getModel();
        int row = tblCTHoaDon.getSelectedRow();
        if (row >= 0) {
            tblModel.removeRow(row);
            for (int i = 0; i < tblCTHoaDon.getRowCount(); i++) {
                tblCTHoaDon.setValueAt(i + 1, i, 1);
            }
        }
        lblTongTien.setText(String.valueOf(TinhTien()));
    }//GEN-LAST:event_btnXoaCTHDActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (jckChoTT.isSelected() == true) {
            insertHoaDon1();
            jckChoTT.setSelected(false);
            btnThanhToan.setText("Thanh toán");
            clearForm1();
            clearForm2();
            return;
        }
        if (btnThanhToan.getText().equals("Cập nhật thanh toán")) {
            if (valiadteForm1(true)) {
                updateHoaDon();
            }

            return;
        }
        if (valiadteForm1(true)) {
            ThanhToanTC();
        }


    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed

        int index = cbbTrangThai.getSelectedIndex();
        System.out.println(index);
        fillTableHoaDon(index);

    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    private void btnCapNhatttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatttActionPerformed
        int row = tblHoaDon.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn.");
            return;
        } else {
            String maCapNhat = tblHoaDon.getValueAt(row, 0).toString();
            HoaDon hoa_don = daoHD.selectID(maCapNhat);
            if (hoa_don.getTrangThai() == 1 || hoa_don.getTrangThai() == 4) {
                JOptionPane.showMessageDialog(this, "Hóa đơn không được phép cập nhật.");
                return;
            }
            CapNhatTTJDialog jdl = new CapNhatTTJDialog(null, true, hoa_don);
            jdl.setVisible(true);
            this.fillTableHoaDon(cbbTrangThai.getSelectedIndex());
        }


    }//GEN-LAST:event_btnCapNhatttActionPerformed

    private void txtTienShipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienShipKeyReleased
        float tien_ship = Float.parseFloat(txtTienShip.getText());
        float tongTien = Xmoney.ChuyenTien(lblTongTien2.getText());
        float khachcantra = tien_ship + tongTien;
        lblKhachCanTra.setText(Xmoney.DinhDangTien(khachcantra));
    }//GEN-LAST:event_txtTienShipKeyReleased

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        if (evt.getClickCount() >= 2) {
            int row = tblHoaDon.getSelectedRow();
            String maHD = tblHoaDon.getValueAt(row, 0).toString();
            fillTableCThoaDon(maHD);
            this.setCapNhat(maHD);
            this.edit(maHD);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnGiaoHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoHangActionPerformed

        if (btnGiaoHang.getText().equals("Cập nhật giao hàng")) {
            if (valiadteForm2(true)) {
                updateDatHang();
            }
            return;
        }
        if (valiadteForm2(true)) {
            GiaoHangTC();
        }


    }//GEN-LAST:event_btnGiaoHangActionPerformed

    private void jckChoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jckChoTTActionPerformed
        if (jckChoTT.isSelected()) {
            btnThanhToan.setText("Tạo hóa đơn chờ");
        } else {
            btnThanhToan.setText("Thanh toán");
        }
    }//GEN-LAST:event_jckChoTTActionPerformed

    private void jckChoTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jckChoTTKeyReleased

    }//GEN-LAST:event_jckChoTTKeyReleased

    private void tblCTHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCTHoaDonKeyReleased
        int row = tblCTHoaDon.getSelectedRow();
        float thanhTien, donGia;
        donGia = Float.parseFloat(tblCTHoaDon.getValueAt(tblCTHoaDon.getSelectedRow(), 4).toString());
        thanhTien = donGia * SoLuong;
        tblCTHoaDon.setValueAt(thanhTien, row, 5);
        lblTongTien.setText(String.valueOf(TinhTien()));
        lblTongTien2.setText(String.valueOf(TinhTien()));
    }//GEN-LAST:event_tblCTHoaDonKeyReleased

    private void lblMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblMaHDKeyReleased
        List<HoaDon> list = daoHD.selectAll();
        for (HoaDon hd : list) {
            if (lblMaHD.getText().equals(hd.getMaHd())) {
                if (hd.getTrangThai() == 0) {
                    btnThanhToan.setText("Cập nhật thanh toán");
                } else if (hd.getTrangThai() == 2) {
                    btnGiaoHang.setText("Giao hàng");
                } else {
                    btnThanhToan.enable();
                    btnGiaoHang.enable();
                    tblCTHoaDon.enable();
                }

            }
        }

    }//GEN-LAST:event_lblMaHDKeyReleased

    private void btnTaoMoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoi2ActionPerformed
        this.clearForm1();
    }//GEN-LAST:event_btnTaoMoi2ActionPerformed

    private void btnTaoMoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoi1ActionPerformed
        this.clearForm2();
    }//GEN-LAST:event_btnTaoMoi1ActionPerformed

    private void btnClearGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHangActionPerformed
        clearCTHD();
    }//GEN-LAST:event_btnClearGioHangActionPerformed

    private void lblTongTienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblTongTienKeyReleased

    }//GEN-LAST:event_lblTongTienKeyReleased

    private void btnTkHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTkHDActionPerformed
        fillTableHoaDonTK(txtTKKH.getText());
    }//GEN-LAST:event_btnTkHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhattt;
    private javax.swing.JButton btnClearGioHang;
    private javax.swing.JButton btnGiaoHang;
    private javax.swing.JButton btnTaoMoi1;
    private javax.swing.JButton btnTaoMoi2;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnTimKH;
    private javax.swing.JButton btnTkHD;
    private javax.swing.JButton btnXoaCTHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JCheckBox jckChoTT;
    private javax.swing.JPanel jpnGiaohang;
    private javax.swing.JPanel jpnThanhToan;
    private javax.swing.JTextArea jtadiachi;
    private javax.swing.JLabel lblKhachCanTra;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTien2;
    private javax.swing.JMenuItem mniSua;
    private javax.swing.JPopupMenu pmnCTHD;
    private javax.swing.JRadioButton rdbChuyenKhoan1;
    private javax.swing.JRadioButton rdbChuyenKhoan2;
    private javax.swing.JRadioButton rdbTienMat1;
    private javax.swing.JRadioButton rdbTienMat2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblCTHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGhiChu1;
    private javax.swing.JTextField txtGhiChu2;
    private javax.swing.JTextField txtKhachTra;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtTKKH;
    private javax.swing.JTextField txtTKSanPham;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienShip;
    private javax.swing.JTextField txtTkHD;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel modelfilltableSanPham;

    public void fillTableSanPham() {
        modelfilltableSanPham = (DefaultTableModel) tblSanPham.getModel();
        modelfilltableSanPham.setRowCount(0);

        try {
            List<SanPham> list = daoSP.selectAll();
            for (SanPham sp : list) {
                modelfilltableSanPham.addRow(new Object[]{
                    sp.getMaSp(), daoDM.selectID(sp.getMaDm()).getTenDm(), daoMS.selectID(sp.getMaMau()).getTenMau(),
                    daoSize.selectID(sp.getMaSize()).getTenSize(), daoLH.selectID(sp.getMaLH()).getTenLoai(), daoDv.selectID(sp.getMaDv()).getTenDon_vi(), Xmoney.DinhDangTien(sp.getDonGia()), sp.getSoLuong()
                });
            }
        } catch (Exception e) {
            System.out.println("Lỗi ở GUI");
        }
    }

    private void addCTHD(String maSp, String tenSp, int soLuong, float donGia, float thanhTien) {
        DefaultTableModel tbModel = (DefaultTableModel) tblCTHoaDon.getModel();
        Object obj[] = new Object[7];
        obj[0] = tbModel.getRowCount() + 1;
        obj[1] = maSp;
        obj[2] = tenSp;
        obj[3] = String.valueOf(soLuong);
        obj[4] = Xmoney.DinhDangTien(donGia);
        obj[5] = Xmoney.DinhDangTien(thanhTien);
        tbModel.addRow(obj);
    }

    private float TinhTien() {
        float tongTien = 0;
        for (int i = 0; i < tblCTHoaDon.getRowCount(); i++) {
            tongTien += Xmoney.ChuyenTien(tblCTHoaDon.getValueAt(i, 5).toString());
        }
        return tongTien;
    }

    public void tinhTienThoi() {
        float tienKT = Float.parseFloat(txtKhachTra.getText());
        float tongTien = Xmoney.ChuyenTien(lblTongTien.getText());
        if (tienKT > tongTien) {
            float tienThoi = tienKT - tongTien;
            lblTienThua.setText(Xmoney.DinhDangTien(tienThoi));
        } else {
            lblTienThua.setText("0 VND");
        }
    }

    public void getDateNow() {
        Date date = new Date();
        String day = XDate.toString(date, "dd/MM/yyyy - hh:mm:ss a");
        lblNgayTao.setText(day);
    }

    private HoaDon getForm1() {
        HoaDon hd = new HoaDon();
        hd.setMaKh(daoKH.selectByPhone(txtSDTKH.getText()).getMaKh());
        hd.setMaNv(nvac.getMaNv());
        hd.setNgayTao(null);
        hd.setHtThanhToan(rdbTienMat1.isSelected());
        hd.setTrangThai(0);
        hd.setTienShip(0);
        hd.setDiaChi("");
        hd.setTongTien(Float.parseFloat(lblTongTien.getText()));
        hd.setGhiChu(txtGhiChu1.getText());

        return hd;
    }

    private void setForm1(HoaDon hd) {
        lblMaHD.setText(hd.getMaHd());
        lblNhanVien.setText(nvac.getHo_ten());
//        txtTenKH.setText(daoKH.selectID(hd.getMaKh()).getHoTen());
//        txtSDTKH.setText(daoKH.selectID(hd.getMaKh()).getPhone());
        lblNgayTao.setText(hd.getNgayTao().toString());
        lblTongTien.setText(Xmoney.DinhDangTien(hd.getTongTien()));
        txtGhiChu1.setText(hd.getGhiChu());
        rdbTienMat1.setSelected(hd.isHtThanhToan());
        rdbChuyenKhoan1.setSelected(hd.isHtThanhToan());
    }

    private void setForm2(HoaDon hd) {
        lblMaHD.setText(hd.getMaHd());
        lblNhanVien.setText(nvac.getHo_ten());
        txtTenKH.setText(hd.getHo_tenkh());
        txtSDTKH.setText(hd.getSdt_kh());
        lblNgayTao.setText(hd.getNgayTao().toString());
        lblTongTien2.setText(String.valueOf(hd.getTongTien()));
        txtTienShip.setText(String.valueOf(hd.getTienShip()));
        jtadiachi.setText(hd.getDiaChi());
        txtGhiChu2.setText(hd.getGhiChu());
        rdbTienMat2.setSelected(hd.isHtThanhToan());
        rdbChuyenKhoan2.setSelected(hd.isHtThanhToan());
    }

    private void clearForm1() {
        txtTenKH.setText("");
        txtSDTKH.setText("");
        lblTongTien.setText("");
        txtGhiChu1.setText("");
        lblNhanVien.setText(nvac.getHo_ten());
        txtTKKH.setText("");
        txtKhachTra.setText("");
        DefaultTableModel tbModel = (DefaultTableModel) tblCTHoaDon.getModel();
        tbModel.setRowCount(0);
        maTuTang();
    }

    private void clearForm2() {
        txtTenKH.setText("");
        txtSDTKH.setText("");
        lblNhanVien.setText(nvac.getHo_ten());
        lblTongTien2.setText("");
        txtGhiChu2.setText("");
        txtTienShip.setText("");
        jtadiachi.setText("");
        txtGhiChu2.setText("");
        DefaultTableModel tbModel = (DefaultTableModel) tblCTHoaDon.getModel();
        tbModel.setRowCount(0);
        maTuTang();
    }

    public void clearCTHD() {
        DefaultTableModel tbModel = (DefaultTableModel) tblCTHoaDon.getModel();
        tbModel.setRowCount(0);
    }

    public void maTuTang() {
        if (daoHD.selectAll().isEmpty()) {
            lblMaHD.setText("HD1");
        } else {
            lblMaHD.setText("HD" + (daoHD.select_Max_id_java() + 1));
        }
    }

    void insertHoaDon1() {
        try {
            HoaDon hd = new HoaDon();
            hd.setMaHd(lblMaHD.getText());
            hd.setMaKh(null);
            hd.setMaNv(nvac.getMaNv());
            hd.setHo_tenkh(txtTenKH.getText());
            hd.setSdt_kh(txtSDTKH.getText());
            hd.setNgayTao(XDate.toDate1(lblNgayTao.getText(), "dd/MM/yyyy - hh:mm:ss a"));
            hd.setHtThanhToan(rdbTienMat1.isSelected());
            hd.setTrangThai(0);
            hd.setTienShip(0);
            hd.setDiaChi("");
            hd.setTongTien(Xmoney.ChuyenTien(lblTongTien.getText()));
            hd.setGhiChu(txtGhiChu1.getText());
            daoHD.insert(hd);
            insertCTHD(lblMaHD.getText());
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insertHoaDonGH2() {
        try {
            HoaDon hd = new HoaDon();
            hd.setMaHd(lblMaHD.getText());
            hd.setMaKh(null);
            hd.setMaNv(nvac.getMaNv());
            hd.setHo_tenkh(txtTenKH.getText());
            hd.setSdt_kh(txtSDTKH.getText());
            hd.setNgayTao(XDate.toDate1(lblNgayTao.getText(), "dd/MM/yyyy - hh:mm:ss a"));
            hd.setHtThanhToan(rdbTienMat1.isSelected());
            hd.setTrangThai(2);
            hd.setTienShip(Float.parseFloat(txtTienShip.getText()));
            hd.setDiaChi(jtadiachi.getText());
            hd.setTongTien(Xmoney.ChuyenTien(lblKhachCanTra.getText()));
            hd.setGhiChu(txtGhiChu2.getText());
            daoHD.insert(hd);
            insertCTHD(lblMaHD.getText());
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertCTHD(String id) {
        HoaDon hd = daoHD.selectID(id);
        String maHD = hd.getMaHd();
        for (int i = 0; i < tblCTHoaDon.getRowCount(); i++) {
            CTHoaDon ct = new CTHoaDon();
            ct.setMa_sanpham(tblCTHoaDon.getValueAt(i, 1).toString());
            ct.setMa_hoadon(maHD);;
            ct.setSo_luong(Integer.parseInt(tblCTHoaDon.getValueAt(i, 3).toString()));
            ct.setDon_gia(Xmoney.ChuyenTien(tblCTHoaDon.getValueAt(i, 4).toString()));
            ct.setThanh_tien(Xmoney.ChuyenTien(tblCTHoaDon.getValueAt(i, 5).toString()));
            ct.setDonVi("");
            ct.setTrang_thai(true);
            ct.setGhi_chu("");
            daoct.insert(ct);
        }
    }

    private void fillTableHoaDon(int trang_thai) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblHoaDon.getModel();
        tblmodel.setRowCount(0);
        try {
            List<HoaDon> list = daoHD.selectByTrangThai(trang_thai);
            for (HoaDon hd : list) {
                tblmodel.addRow(new Object[]{
                    hd.getMaHd(), hd.getNgayTao(), hd.getHo_tenkh(), Xmoney.DinhDangTien(hd.getTongTien()),
                    hd.getTrangThai() < 1 ? "Hóa đơn chờ"
                    : hd.getTrangThai() < 2 ? "Đã thanh toán"
                    : hd.getTrangThai() < 3 ? "Chờ lấy hàng"
                    : hd.getTrangThai() < 4 ? "Đang giao"
                    : hd.getTrangThai() < 5 ? "Đã nhận hàng" : "Hủy", hd.getGhiChu()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở bảng này");
        }
    }

    private void fillTableCThoaDon(String id) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblCTHoaDon.getModel();
        tblmodel.setRowCount(0);
        try {
            List<CTHoaDon> list = daoct.selectByIdHoaDon(id);
            for (CTHoaDon ct : list) {
                tblmodel.addRow(new Object[]{
                    tblmodel.getRowCount() + 1, ct.getMa_sanpham(), daoDM.selectID(daoSP.selectID(ct.getMa_sanpham()).getMaDm()).getTenDm(), ct.getSo_luong(), Xmoney.DinhDangTien(ct.getDon_gia()), Xmoney.DinhDangTien(ct.getThanh_tien())

                });
            }
        } catch (Exception e) {
            System.out.println("Lỗi ở GUI");
        }
    }

    private HoaDon getInformation1() {
        HoaDon hd = new HoaDon();
        hd.setMaHd(lblMaHD.getText());
        hd.setMaKh(null);
        hd.setMaNv(nvac.getMaNv());
        hd.setHo_tenkh(txtTenKH.getText());
        hd.setSdt_kh(txtSDTKH.getText());
        hd.setNgayTao(XDate.toDate1(lblNgayTao.getText(), "dd/MM/yyyy - hh:mm:ss a"));
        hd.setTongTien(Xmoney.ChuyenTien(lblTongTien.getText()));
        hd.setHtThanhToan(rdbTienMat1.isSelected());
        hd.setTienShip(0);
        hd.setDiaChi("");
        hd.setGhiChu(txtGhiChu1.getText());
        hd.setTrangThai(2);
        return hd;
    }

    private HoaDon getInformation2() {
        HoaDon hd = new HoaDon();
        hd.setMaHd(lblMaHD.getText());
        hd.setMaKh(null);
        hd.setMaNv(nvac.getMaNv());
        hd.setHo_tenkh(txtTenKH.getText());
        hd.setSdt_kh(txtSDTKH.getText());
        hd.setNgayTao(XDate.toDate1(lblNgayTao.getText(), "dd/MM/yyyy - hh:mm:ss a"));
        hd.setTongTien(Xmoney.ChuyenTien(lblKhachCanTra.getText()));
        hd.setHtThanhToan(rdbTienMat2.isSelected());
        hd.setTienShip(Float.parseFloat(txtTienShip.getText()));
        hd.setDiaChi(jtadiachi.getText());
        hd.setGhiChu(txtGhiChu2.getText());
        hd.setTrangThai(3);
        return hd;
    }

    private void updateHoaDon() {
        try {
            HoaDon hd = getInformation1();
            hd.setTrangThai(1);
            daoct.deleteHD(hd.getMaHd());
            insertCTHD(hd.getMaHd());
            daoHD.update(hd);
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDatHang() {
        try {
            HoaDon hd = getInformation2();
            hd.setTrangThai(3);
            daoct.deleteHD(hd.getMaHd());
            insertCTHD(hd.getMaHd());
            daoHD.update(hd);
            JOptionPane.showMessageDialog(this, "Cập nhật đặt hàng thành công");
            clearForm2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ThanhToanTC() {
        try {
            HoaDon hd = new HoaDon();
            hd.setMaHd(lblMaHD.getText());
            hd.setMaKh(null);
            hd.setMaNv(nvac.getMaNv());
            hd.setHo_tenkh(txtTenKH.getText());
            hd.setSdt_kh(txtSDTKH.getText());
            hd.setNgayTao(XDate.toDate1(lblNgayTao.getText(), "dd/MM/yyyy - hh:mm:ss a"));
            hd.setHtThanhToan(rdbTienMat1.isSelected());
            hd.setTrangThai(1);
            hd.setTienShip(0);
            hd.setDiaChi("");
            hd.setTongTien(Xmoney.ChuyenTien(lblTongTien.getText()));
            hd.setGhiChu(txtGhiChu1.getText());
            daoHD.insert(hd);
            insertCTHD(lblMaHD.getText());
            JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            clearForm1();
            clearForm2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void GiaoHangTC() {
        try {
            HoaDon hd = getInformation2();
            hd.setTrangThai(2);
            daoHD.insert(hd);
            JOptionPane.showMessageDialog(this, "Giao hàng thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validateForm(boolean chk) {

        List<HoaDon> list = daoHD.selectAll();
        if (chk) {
            for (HoaDon hd : list) {
                if (lblMaHD.getText().equals(hd.getMaHd())) {
                    MsgBox.alert(this, "Mã hóa đơn học đã tồn tại");
                    return false;
                }
            }
        }
        return chk;
    }

    public void setCapNhat(String id) {
        HoaDon hd = daoHD.selectID(id);
        if (hd.getTrangThai() == 0) {
            btnThanhToan.setText("Cập nhật thanh toán");
            jckChoTT.enable();
        } else if (hd.getTrangThai() == 2) {
            btnThanhToan.setText("Cập nhật giao hàng");
            jckChoTT.enable();
        } else if (hd.getTrangThai() == 1 || hd.getTrangThai() == 3 || hd.getTrangThai() == 4 || hd.getTrangThai() == 5) {
            tblCTHoaDon.enable();
            btnGiaoHang.enable();
            btnThanhToan.enable();
        }
    }

    public void edit(String maHd) {
        HoaDon hd = daoHD.selectID(maHd);
        if (hd.getTrangThai() == 0) {
            this.setForm1(hd);
            tabs.setSelectedIndex(0);
            btnThanhToan.setText("Cập nhật thanh toán");
        } else if (hd.getTrangThai() == 2) {
            this.setForm1(hd);
            tabs.setSelectedIndex(1);
            btnGiaoHang.setText("Cập nhật giao hàng");
        } else if (hd.getTrangThai() == 1) {
            this.setForm1(hd);
            tabs.setSelectedIndex(0);
            btnXoaCTHD.setEnabled(false);
            btnClearGioHang.setEnabled(false);
            btnThanhToan.setEnabled(false);
            tblCTHoaDon.setEnabled(false);
        } else if (hd.getTrangThai() == 3) {
            this.setForm2(hd);
            tabs.setSelectedIndex(0);
            btnXoaCTHD.setEnabled(false);
            btnClearGioHang.setEnabled(false);
            btnGiaoHang.setEnabled(false);
            tblSanPham.setEnabled(false);
            tblCTHoaDon.setEnabled(false);
        } else if (hd.getTrangThai() == 4) {
            this.setForm2(hd);
            tabs.setSelectedIndex(0);
            btnXoaCTHD.setEnabled(false);
            btnClearGioHang.setEnabled(false);
            btnGiaoHang.setEnabled(false);
            tblSanPham.setEnabled(false);
            tblCTHoaDon.setEnabled(false);
        } else if (hd.getTrangThai() == 5) {
            this.setForm2(hd);
            tabs.setSelectedIndex(0);
            btnXoaCTHD.setEnabled(false);
            btnClearGioHang.setEnabled(false);
            btnGiaoHang.setEnabled(false);
            tblSanPham.setEnabled(false);
            tblCTHoaDon.setEnabled(false);
        }
    }

    private boolean valiadteForm1(boolean chk) {
        if (txtKhachTra.getText().length() == 0) {
            MsgBox.alert(this, "Không được phép để trống tiền khách trả!");
            txtKhachTra.requestFocus();
            return false;
        }
        return true;
    }

    private boolean valiadteForm2(boolean chk) {
        if (txtTenKH.getText().length() == 0) {
            MsgBox.alert(this, "Không được phép để trống tên khách hàng!");
            txtKhachTra.requestFocus();
            return false;
        }else if (txtSDTKH.getText().length() == 0) {
            MsgBox.alert(this, "Không được phép để trống số điện thoại!");
            txtKhachTra.requestFocus();
            return false;
        } else if (!txtSDTKH.getText().matches("((84)|(0))\\d{9}")) {
            MsgBox.alert(this, "Không đúng định dạng số điện thoại!");
            txtSDTKH.requestFocus();
            return false;
        } else if (jtadiachi.getText().length() == 0) {
            MsgBox.alert(this, "Không được phép để trống địa chỉ!");
            jtadiachi.requestFocus();
            return false;
        } else if (txtTienShip.getText().length() == 0) {
            MsgBox.alert(this, "Không được phép để trống tiền ship!");
            txtTienShip.requestFocus();
            return false;
        }
        return true;
    }

    private void fillTableHoaDonTK(String maHD) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblHoaDon.getModel();
        tblmodel.setRowCount(0);
        try {
            List<HoaDon> list = daoHD.selectByMAHD(maHD);
            for (HoaDon hd : list) {
                tblmodel.addRow(new Object[]{
                    hd.getMaHd(), hd.getNgayTao(), hd.getHo_tenkh(), Xmoney.DinhDangTien(hd.getTongTien()),
                    hd.getTrangThai() < 1 ? "Hóa đơn chờ"
                    : hd.getTrangThai() < 2 ? "Đã thanh toán"
                    : hd.getTrangThai() < 3 ? "Chờ lấy hàng"
                    : hd.getTrangThai() < 4 ? "Đang giao"
                    : hd.getTrangThai() < 5 ? "Đã nhận hàng" : "Hủy", hd.getGhiChu()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở bảng này");
        }
    }
}
