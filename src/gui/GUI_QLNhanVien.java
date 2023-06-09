package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import dao.CanCuocCongDan_DAO;
import dao.NhanVien_DAO;
import entity.CanCuocCongDan;
import entity.LoaiXe;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.NhanVienHanhChinh;
import entity.NhanVienKiThuat;
import entity.XeMay;

import javax.swing.JCheckBox;

public class GUI_QLNhanVien extends JPanel implements ActionListener, MouseListener, ItemListener {

	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtMucLuongKT;
	private JTextField txtBacTho;
	private JTextField txtNamKinhNghiem;
	private JTextField txtTrinhDoHocVan;
	private JComboBox cbxLoaiNhanVien;
	private JPanel pNhanVienHanhChinh;
	private JPanel pNhanVienKyThuat;
	private JPanel pThongTinCongViec;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private NhanVien_DAO nhanVien_dao;
	private CanCuocCongDan_DAO cCCD_dao;
	private JCheckBox chckbxGioiTinh;
	private JTextField txtCCCD;
	private JTextField txtMaMVHC;
	private JTextField txtMaMVKT;
	private JTextField txtMucLuongHC;
	private JComboBox cbxPhongBan;
	private JComboBox cbxChucVuHC;
	private JComboBox cbxChucVuKT;
	private JButton btnLoc;
	private JLabel lblLoiTimKiem;
	private JDateChooser dchNgaySinh;
	private JDateChooser dchVaoLamKT;
	private JDateChooser dchVaoLamHC;

	/**
	 * Create the panel.
	 */
	public GUI_QLNhanVien() {

		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		nhanVien_dao = new NhanVien_DAO();
		cCCD_dao = new CanCuocCongDan_DAO();
		setLayout(null);

		JPanel pThongTinXeMay = new JPanel();
		pThongTinXeMay.setBounds(0, 0, 568, 248);
		add(pThongTinXeMay);
		pThongTinXeMay.setLayout(null);
		pThongTinXeMay.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin cá nhân"));

		JPanel pHo = new JPanel();
		pHo.setBounds(17, 40, 273, 45);
		pThongTinXeMay.add(pHo);
		pHo.setLayout(null);
		JLabel lblNewLabel = new JLabel("Họ:");
		lblNewLabel.setBounds(0, 12, 80, 14);
		pHo.add(lblNewLabel);
		txtHo = new JTextField();
		txtHo.setBounds(73, 5, 200, 29);
		pHo.add(txtHo);
		txtHo.setColumns(10);

		JPanel pMaNV_1 = new JPanel();
		pMaNV_1.setLayout(null);
		pMaNV_1.setBounds(316, 40, 242, 45);
		pThongTinXeMay.add(pMaNV_1);

		JLabel lblNewLabel_1 = new JLabel("Tên:");
		lblNewLabel_1.setBounds(0, 12, 80, 14);
		pMaNV_1.add(lblNewLabel_1);

		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(50, 5, 186, 29);
		pMaNV_1.add(txtTen);

		JPanel pMaNV_2 = new JPanel();
		pMaNV_2.setLayout(null);
		pMaNV_2.setBounds(17, 84, 273, 45);
		pThongTinXeMay.add(pMaNV_2);

		JLabel lblNewLabel_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2.setBounds(0, 12, 80, 14);
		pMaNV_2.add(lblNewLabel_2);

		dchNgaySinh = new JDateChooser(new Date());
		dchNgaySinh.setBounds(76, 8, 197, 29);
		dchNgaySinh.setDateFormatString("dd/MM/yyyy");
		pMaNV_2.add(dchNgaySinh);
		dchNgaySinh.setDate(null);

		JPanel pMaNV_3_1 = new JPanel();
		pMaNV_3_1.setLayout(null);
		pMaNV_3_1.setBounds(17, 180, 273, 45);
		pThongTinXeMay.add(pMaNV_3_1);

		JLabel lblNewLabel_3_1 = new JLabel("Địa chỉ:");
		lblNewLabel_3_1.setBounds(0, 12, 80, 14);
		pMaNV_3_1.add(lblNewLabel_3_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(76, 5, 197, 29);
		pMaNV_3_1.add(txtDiaChi);

		JPanel pMaNV_3_2 = new JPanel();
		pMaNV_3_2.setLayout(null);
		pMaNV_3_2.setBounds(17, 130, 273, 45);
		pThongTinXeMay.add(pMaNV_3_2);

		JLabel lblNewLabel_3_2 = new JLabel("Số điện thoại:");
		lblNewLabel_3_2.setBounds(0, 12, 80, 14);
		pMaNV_3_2.add(lblNewLabel_3_2);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(76, 5, 197, 29);
		pMaNV_3_2.add(txtSDT);

		JPanel pMaNV_3_3 = new JPanel();
		pMaNV_3_3.setLayout(null);
		pMaNV_3_3.setBounds(315, 130, 243, 45);
		pThongTinXeMay.add(pMaNV_3_3);

		JLabel lblNewLabel_3_3 = new JLabel("Email");
		lblNewLabel_3_3.setBounds(0, 12, 80, 14);
		pMaNV_3_3.add(lblNewLabel_3_3);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(52, 5, 184, 29);
		pMaNV_3_3.add(txtEmail);

		JPanel pMaNV_1_1 = new JPanel();
		pMaNV_1_1.setLayout(null);
		pMaNV_1_1.setBounds(316, 84, 242, 45);
		pThongTinXeMay.add(pMaNV_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1.setBounds(0, 12, 56, 14);
		pMaNV_1_1.add(lblNewLabel_1_1);

		chckbxGioiTinh = new JCheckBox("Nam");
		chckbxGioiTinh.setBounds(49, 8, 187, 23);
		pMaNV_1_1.add(chckbxGioiTinh);

		JPanel pMaNV_3_1_1 = new JPanel();
		pMaNV_3_1_1.setLayout(null);
		pMaNV_3_1_1.setBounds(313, 180, 243, 45);
		pThongTinXeMay.add(pMaNV_3_1_1);

		JLabel lblNewLabel_3_1_2 = new JLabel("CCCD:");
		lblNewLabel_3_1_2.setBounds(0, 12, 80, 14);
		pMaNV_3_1_1.add(lblNewLabel_3_1_2);

		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(55, 5, 184, 29);
		pMaNV_3_1_1.add(txtCCCD);

		pThongTinCongViec = new JPanel();
		pThongTinCongViec.setBounds(567, 0, 613, 248);
		add(pThongTinCongViec);
		pThongTinCongViec.setLayout(null);
		pThongTinCongViec.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Thông tin công việc"));

		JPanel pLoaiNhanVien = new JPanel();
		pLoaiNhanVien.setLayout(null);
		pLoaiNhanVien.setBounds(10, 22, 254, 45);
		pThongTinCongViec.add(pLoaiNhanVien);
		JLabel lblNewLabel_3_1_1 = new JLabel("Loại nhân viên:");
		lblNewLabel_3_1_1.setBounds(0, 12, 116, 14);
		pLoaiNhanVien.add(lblNewLabel_3_1_1);
		cbxLoaiNhanVien = new JComboBox();
		cbxLoaiNhanVien.setBounds(102, 6, 152, 26);
		pLoaiNhanVien.add(cbxLoaiNhanVien);
		cbxLoaiNhanVien.addItem("Nhân viên hành chính");
		cbxLoaiNhanVien.addItem("Nhân viên kỹ thuật");

//		themGiaoDienLoaiNhanVien();
		taoNhanVienHanhChinh(pThongTinCongViec);
		taoNhanVienKyThuat(pThongTinCongViec);

		pNhanVienKyThuat.setVisible(false);
		pNhanVienHanhChinh.setVisible(true);

		Box bTable = Box.createVerticalBox();
		bTable.setBounds(0, 305, 1180, 294);
		add(bTable);
		bTable.add(Box.createRigidArea(new Dimension(0, 5)));
		String head[] = { "Mã nhân viên", "CCCD", "Họ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ thường trú", "SĐT",
				"Email", "Ngày vào làm", "Mức lương", "Chức vụ", "Trình độ học vấn", "Phòng ban", "Bậc thợ",
				"Số năm kinh nghiệm" };
		tableModel = new DefaultTableModel(head, 0);
		table = new JTable(tableModel);
		bTable.add(new JScrollPane(table));

		ArrayList<NhanVien> dsNhanVien = nhanVien_dao.getAllNhanVien();
		docDanhSachNhanVienVaoTable(dsNhanVien);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("data//lamMoi.png"));
		btnLamMoi.setBounds(414, 259, 122, 37);
		add(btnLamMoi);
		btnLamMoi.setForeground(new Color(128, 0, 0));
		btnLamMoi.setBackground(new Color(75, 209, 254));

		btnSua = new JButton("Sửa");
		btnSua.setBounds(282, 259, 98, 37);
		add(btnSua);
		btnSua.setIcon(new ImageIcon("data//sua.png"));
		btnSua.setForeground(new Color(128, 0, 0));
		btnSua.setBackground(new Color(75, 209, 254));

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(154, 259, 98, 37);
		add(btnXoa);
		btnXoa.setIcon(new ImageIcon("data//xoa.png"));
		btnXoa.setForeground(new Color(128, 0, 0));
		btnXoa.setBackground(new Color(75, 209, 254));

		btnThem = new JButton("Thêm");
		btnThem.setBounds(30, 259, 98, 37);
		add(btnThem);
		btnThem.setIcon(new ImageIcon("data//them.png"));
		btnThem.setBackground(new Color(75, 209, 254));
		btnThem.setForeground(new Color(128, 0, 0));

		cbxLoaiNhanVien.addActionListener(this);
		cbxLoaiNhanVien.addItemListener(this);

		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);

		btnLoc = new JButton("Lọc");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoc.setIcon(new ImageIcon("data//filter.png"));
		btnLoc.setForeground(new Color(128, 0, 0));
		btnLoc.setBackground(new Color(75, 209, 254));
		btnLoc.setBounds(641, 259, 175, 37);
		add(btnLoc);

		lblLoiTimKiem = new JLabel("");
		lblLoiTimKiem.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLoiTimKiem.setForeground(new Color(255, 0, 0));
		lblLoiTimKiem.setBounds(826, 259, 354, 35);
		add(lblLoiTimKiem);

		btnLoc.addActionListener(this);

	}

	public void createIconImage(JLabel x, int W, int H, String path) {
		ImageIcon image = new ImageIcon(
				new ImageIcon(path).getImage().getScaledInstance(W, H, java.awt.Image.SCALE_SMOOTH));
		x.setIcon(image);
		repaint();
		revalidate();
	}

	private void taoNhanVienHanhChinh(JPanel pThongTinCongViec) {
		pNhanVienHanhChinh = new JPanel();
		pNhanVienHanhChinh.setBounds(10, 66, 593, 177);
		pThongTinCongViec.add(pNhanVienHanhChinh);
		pNhanVienHanhChinh.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Nhân viên hành chính"));
		pNhanVienHanhChinh.setLayout(null);

		JPanel pMaNV = new JPanel();
		pMaNV.setLayout(null);
		pMaNV.setBounds(47, 26, 254, 45);
		pNhanVienHanhChinh.add(pMaNV);
		JLabel lblNewLabel_3_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_1_2.setBounds(0, 12, 80, 14);
		pMaNV.add(lblNewLabel_3_1_2);
		txtMaMVHC = new JTextField();
		txtMaMVHC.setColumns(10);
		txtMaMVHC.setBounds(77, 5, 177, 29);
		pMaNV.add(txtMaMVHC);

		JPanel pNgayVaoLam = new JPanel();
		pNgayVaoLam.setLayout(null);
		pNgayVaoLam.setBounds(47, 70, 254, 45);
		pNhanVienHanhChinh.add(pNgayVaoLam);
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Ngày vào làm:");
		lblNewLabel_3_1_2_1.setBounds(0, 12, 80, 14);
		pNgayVaoLam.add(lblNewLabel_3_1_2_1);
		dchVaoLamHC = new JDateChooser(new Date());
		dchVaoLamHC.setBounds(77, 5, 177, 29);
		dchVaoLamHC.setDateFormatString("dd/MM/yyyy");
		pNgayVaoLam.add(dchVaoLamHC);
		dchVaoLamHC.setDate(null);

		JPanel pMucLuong = new JPanel();
		pMucLuong.setLayout(null);
		pMucLuong.setBounds(47, 115, 254, 45);
		pNhanVienHanhChinh.add(pMucLuong);
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Mức lương:");
		lblNewLabel_3_1_2_2.setBounds(0, 12, 80, 14);
		pMucLuong.add(lblNewLabel_3_1_2_2);
		txtMucLuongHC = new JTextField();
		txtMucLuongHC.setColumns(10);
		txtMucLuongHC.setBounds(77, 5, 177, 29);
		pMucLuong.add(txtMucLuongHC);

		JPanel pPhongBan = new JPanel();
		pPhongBan.setLayout(null);
//		pPhongBan.setBackground(Color.WHITE);
		pPhongBan.setBounds(311, 26, 272, 45);
		pNhanVienHanhChinh.add(pPhongBan);
		JLabel lblNewLabel_3_1_2_3 = new JLabel("Phòng ban:");
		lblNewLabel_3_1_2_3.setBounds(0, 12, 80, 14);
		pPhongBan.add(lblNewLabel_3_1_2_3);

		pPhongBan.add(cbxPhongBan = new JComboBox());
		cbxPhongBan.setBounds(94, 5, 178, 29);
		cbxPhongBan.addItem("");
		cbxPhongBan.addItem("Tài chính");
		cbxPhongBan.addItem("Kế toán");
		cbxPhongBan.addItem("Nhân sự");

		JPanel pHocVan = new JPanel();
		pHocVan.setLayout(null);
//		pHocVan.setBackground(Color.WHITE);
		pHocVan.setBounds(311, 70, 272, 45);
		pNhanVienHanhChinh.add(pHocVan);
		JLabel lblNewLabel_3_1_2_4 = new JLabel("Trình độ học vấn:");
		lblNewLabel_3_1_2_4.setBounds(0, 12, 98, 14);
		pHocVan.add(lblNewLabel_3_1_2_4);
		txtTrinhDoHocVan = new JTextField();
		txtTrinhDoHocVan.setColumns(10);
		txtTrinhDoHocVan.setBounds(95, 5, 177, 29);
		pHocVan.add(txtTrinhDoHocVan);

		JPanel pMaNV_8 = new JPanel();
		pMaNV_8.setLayout(null);
		pMaNV_8.setBounds(311, 115, 272, 45);
		pNhanVienHanhChinh.add(pMaNV_8);
		JLabel lblNewLabel_3_1_2_5 = new JLabel("Chức vụ:");
		lblNewLabel_3_1_2_5.setBounds(10, 12, 80, 14);
		pMaNV_8.add(lblNewLabel_3_1_2_5);
		cbxChucVuHC = new JComboBox();
		cbxChucVuHC.setBounds(94, 8, 178, 29);
		pMaNV_8.add(cbxChucVuHC);
		cbxChucVuHC.addItem("");
		cbxChucVuHC.addItem("Trưởng phòng");
		cbxChucVuHC.addItem("Phó phòng KT");
		cbxChucVuHC.addItem("Quản lý");
		cbxChucVuHC.addItem("Nhân viên");
		cbxChucVuHC.addItem("Thực tập");
		cbxChucVuHC.addItem("Thợ máy");
	}

	private void taoNhanVienKyThuat(JPanel pThongTinCongViec) {
		pNhanVienKyThuat = new JPanel();
		pNhanVienKyThuat.setBounds(10, 66, 593, 177);
		pThongTinCongViec.add(pNhanVienKyThuat);
		pNhanVienKyThuat.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Nhân viên kỹ thuật"));
		pNhanVienKyThuat.setLayout(null);

		JPanel pMaNV = new JPanel();
		pMaNV.setLayout(null);
		pMaNV.setBounds(47, 26, 254, 45);
		pNhanVienKyThuat.add(pMaNV);
		JLabel lblNewLabel_3_1_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_3_1_2.setBounds(0, 12, 80, 14);
		pMaNV.add(lblNewLabel_3_1_2);
		txtMaMVKT = new JTextField();
		txtMaMVKT.setColumns(10);
		txtMaMVKT.setBounds(77, 5, 177, 29);
		pMaNV.add(txtMaMVKT);

		JPanel pMaNV_4 = new JPanel();
		pMaNV_4.setLayout(null);
		pMaNV_4.setBounds(47, 70, 254, 45);
		pNhanVienKyThuat.add(pMaNV_4);
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Ngày vào làm:");
		lblNewLabel_3_1_2_1.setBounds(0, 12, 80, 14);
		pMaNV_4.add(lblNewLabel_3_1_2_1);
		dchVaoLamKT = new JDateChooser(new Date());
		dchVaoLamKT.setBounds(77, 5, 177, 29);
		dchVaoLamKT.setDateFormatString("dd/MM/yyyy");
		pMaNV_4.add(dchVaoLamKT);
		dchVaoLamKT.setDate(null);

		JPanel pMaNV_5 = new JPanel();
		pMaNV_5.setLayout(null);
		pMaNV_5.setBounds(47, 115, 254, 45);
		pNhanVienKyThuat.add(pMaNV_5);
		JLabel lblNewLabel_3_1_2_2 = new JLabel("Mức lương:");
		lblNewLabel_3_1_2_2.setBounds(0, 12, 80, 14);
		pMaNV_5.add(lblNewLabel_3_1_2_2);
		txtMucLuongKT = new JTextField();
		txtMucLuongKT.setColumns(10);
		txtMucLuongKT.setBounds(77, 5, 177, 29);
		pMaNV_5.add(txtMucLuongKT);

		JPanel pBacTho = new JPanel();
		pBacTho.setLayout(null);
		pBacTho.setBounds(311, 26, 272, 45);
		pNhanVienKyThuat.add(pBacTho);
		JLabel lblNewLabel_3_1_2_3 = new JLabel("Bậc thợ:");
		lblNewLabel_3_1_2_3.setBounds(0, 12, 80, 14);
		pBacTho.add(lblNewLabel_3_1_2_3);
		txtBacTho = new JTextField();
		txtBacTho.setColumns(10);
		txtBacTho.setBounds(95, 5, 177, 29);
		pBacTho.add(txtBacTho);

		JPanel pMaNV_7 = new JPanel();
		pMaNV_7.setLayout(null);
		pMaNV_7.setBounds(311, 70, 272, 45);
		pNhanVienKyThuat.add(pMaNV_7);
		JLabel lblNewLabel_3_1_2_4 = new JLabel("Số năm KN:");
		lblNewLabel_3_1_2_4.setBounds(0, 12, 98, 14);
		pMaNV_7.add(lblNewLabel_3_1_2_4);
		txtNamKinhNghiem = new JTextField();
		txtNamKinhNghiem.setColumns(10);
		txtNamKinhNghiem.setBounds(95, 5, 177, 29);
		pMaNV_7.add(txtNamKinhNghiem);

		JPanel pMaNV_8 = new JPanel();
		pMaNV_8.setLayout(null);
		pMaNV_8.setBounds(311, 115, 272, 45);
		pNhanVienKyThuat.add(pMaNV_8);
		JLabel lblNewLabel_3_1_2_5 = new JLabel("Chức vụ:");
		lblNewLabel_3_1_2_5.setBounds(10, 12, 80, 14);
		pMaNV_8.add(lblNewLabel_3_1_2_5);
		cbxChucVuKT = new JComboBox();
		cbxChucVuKT.setBounds(94, 8, 178, 29);
		pMaNV_8.add(cbxChucVuKT);
		cbxChucVuKT.addItem("");
		cbxChucVuKT.addItem("Trưởng phòng KT");
		cbxChucVuKT.addItem("Phó phòng KT");
		cbxChucVuKT.addItem("Quản lý");
		cbxChucVuKT.addItem("Nhân viên");
		cbxChucVuKT.addItem("Thực tập");
		cbxChucVuKT.addItem("Thợ máy");
	}

	private void themGiaoDienLoaiNhanVien() {
		int i = cbxLoaiNhanVien.getSelectedIndex();
		if (i == 1) {
			pNhanVienHanhChinh.setVisible(false);
			pNhanVienKyThuat.setVisible(true);
		} else if (i == 0) {
			pNhanVienKyThuat.setVisible(false);
			pNhanVienHanhChinh.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			themNhanVien();
		}
		if (o.equals(btnXoa)) {
			xoaNhanVien();
		}
		if (o.equals(btnSua)) {
			capNhatNhanVien();
		}
		if (o.equals(btnLamMoi)) {
			lamMoi();
		}
		if (o.equals(btnLoc)) {
			locNhanVien();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tableModel.getValueAt(row, 4).toString());
			dchNgaySinh.setDate(date);
			if (tableModel.getValueAt(row, 12).toString() != "") {
				cbxLoaiNhanVien.setSelectedIndex(0);
				txtMaMVHC.setText(tableModel.getValueAt(row, 0).toString());
				date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tableModel.getValueAt(row, 9).toString());
				dchVaoLamHC.setDate(date);
				txtMucLuongHC.setText(tableModel.getValueAt(row, 10).toString());
				cbxChucVuHC.setSelectedItem(tableModel.getValueAt(row, 11).toString());
				txtTrinhDoHocVan.setText(tableModel.getValueAt(row, 12).toString());
				cbxPhongBan.setSelectedItem(tableModel.getValueAt(row, 13).toString());
			} else {
				cbxLoaiNhanVien.setSelectedIndex(1);
				txtMaMVKT.setText(tableModel.getValueAt(row, 0).toString());
				date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tableModel.getValueAt(row, 9).toString());
				dchVaoLamKT.setDate(date);
				txtMucLuongKT.setText(tableModel.getValueAt(row, 10).toString());
				cbxChucVuKT.setSelectedItem(tableModel.getValueAt(row, 11).toString());
				txtBacTho.setText(tableModel.getValueAt(row, 14).toString());
				txtNamKinhNghiem.setText(tableModel.getValueAt(row, 15).toString());
			}

			txtCCCD.setText(tableModel.getValueAt(row, 1).toString());
			txtHo.setText(tableModel.getValueAt(row, 2).toString());
			txtTen.setText(tableModel.getValueAt(row, 3).toString());
			if (tableModel.getValueAt(row, 5).toString() == "Nam") {
				chckbxGioiTinh.setSelected(true);
			} else
				chckbxGioiTinh.setSelected(false);
			txtDiaChi.setText(tableModel.getValueAt(row, 6).toString());
			txtSDT.setText(tableModel.getValueAt(row, 7).toString());
			txtEmail.setText(tableModel.getValueAt(row, 8).toString());

		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Không tìm thấy");
//			Logger.getLogger(Java_JTable_And_JDateChooser.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void docDanhSachNhanVienVaoTable(ArrayList<NhanVien> dsNhanVien) {
		sapXepNhanVien(dsNhanVien);
		DecimalFormat df = new DecimalFormat("0.##");
		CanCuocCongDan cCCD;
		for (NhanVien nhanVien : dsNhanVien) {
			cCCD = cCCD_dao.getCCCDTheoMa(nhanVien.getCccd().getMaCCCD());
			if (nhanVien instanceof NhanVienHanhChinh) {
				tableModel.addRow(
						new Object[] { nhanVien.getMaNhanVien(), cCCD.getMaCCCD(), cCCD.getHo() + " " + cCCD.getHoDem(),
								cCCD.getTen(), cCCD.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
								cCCD.isGioiTinh() ? "Nam" : "Nữ", cCCD.getThuongTru(), nhanVien.getSoDienThoai(),
								nhanVien.getEmail(),
								nhanVien.getNgayVaoLamViec().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
								df.format(nhanVien.getLuong()), nhanVien.getChucVu(),
								((NhanVienHanhChinh) nhanVien).getTrinhDoHocVan(),
								((NhanVienHanhChinh) nhanVien).getPhongBan(), "", "" });
			} else if (nhanVien instanceof NhanVienKiThuat) {
				tableModel.addRow(new Object[] { nhanVien.getMaNhanVien(), cCCD.getMaCCCD(), cCCD.getHo(),
						cCCD.getTen(), cCCD.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						cCCD.isGioiTinh() ? "Nam" : "Nữ", cCCD.getThuongTru(), nhanVien.getSoDienThoai(),
						nhanVien.getEmail(),
						nhanVien.getNgayVaoLamViec().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						df.format(nhanVien.getLuong()), nhanVien.getChucVu(), "", "",
						((NhanVienKiThuat) nhanVien).getBacTho(), ((NhanVienKiThuat) nhanVien).getSoNamKN() });
			}

		}
	}

	private void xoaDuLieuTrongTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();
	}

	private void lamMoi() {
		cbxLoaiNhanVien.setSelectedIndex(0);
		txtMaMVHC.setText("");
		txtNamKinhNghiem.setText("");
		txtTrinhDoHocVan.setText("");
		cbxPhongBan.setSelectedIndex(0);
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtHo.setText("");
		txtMaMVKT.setText("");
		txtMucLuongHC.setText("");
		cbxChucVuHC.setSelectedIndex(0);
		txtSDT.setText("");
		txtTen.setText("");
		txtMaMVKT.setText("");
		txtBacTho.setText("");
		cbxChucVuKT.setSelectedIndex(0);
		txtMucLuongKT.setText("");
		txtCCCD.setText("");
		chckbxGioiTinh.setSelected(false);
		dchNgaySinh.setDate(null);
		dchVaoLamHC.setDate(null);
		dchVaoLamKT.setDate(null);
		lblLoiTimKiem.setText("");

		ArrayList<NhanVien> dsNhanVien = nhanVien_dao.getAllNhanVien();
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsNhanVien);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		themGiaoDienLoaiNhanVien();
	}

	private void themNhanVien() {
		if (!kiemTraRong())
			return;
		String cc = txtCCCD.getText();
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		// kt ngày sinh
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate ngayString;
		Date ngaySinh = dchNgaySinh.getDate();
		if (ngaySinh != null)

			ngayString = LocalDate.parse(dateFormat.format(ngaySinh));
		else {
			JOptionPane.showMessageDialog(this, "Ngày sinh không được rỗng");
			return;
		}
		if (LocalDate.now().getYear() - ngayString.getYear() < 18) {
			JOptionPane.showMessageDialog(this, "Nhân viên phải trên 18 tuổi!");
			return;
		}
		boolean gioiTinh = chckbxGioiTinh.isSelected();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		if (!kiemTraSDT(sdt))
			return;
		String email = txtEmail.getText();
		if (!kiemTraEmail(email))
			return;
		String maNV;
		LocalDate ngayVaoLam;
		double mucLuong;
		String chucVu;
		String trinhDo;
		String phongBan;
		String ho_hoDem[] = ho.split(" ");
		ho = ho_hoDem[0];
		String tenDem = "";
		for (int i = 1; i < ho_hoDem.length; i++) {
			tenDem += ho_hoDem[i] + " ";
		}
		CanCuocCongDan cccd = null;
		// kiem tra căn cước công dân có trùng hay không
		if (!kiemTraCCCDTrung(cc)) {
			JOptionPane.showMessageDialog(this, "Mã căn cước công dân không được phép trung!");
			txtCCCD.selectAll();
			txtCCCD.requestFocus();
			return;
		}
		if (!kiemTraMaCCCD(cc, ngayString, gioiTinh))
			return;
		try {
			cccd = new CanCuocCongDan(cc, ho, tenDem, ten, gioiTinh, ngayString, diaChi, diaChi);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e);
			return;
		}
		// nếu là nhân viên văn phòng
		if (cbxLoaiNhanVien.getSelectedIndex() == 0) {
			trinhDo = txtTrinhDoHocVan.getText();
			phongBan = cbxPhongBan.getSelectedItem().toString();

			if (!txtMaMVHC.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Không được nhập mã nhân viên vì mã nhân viên là trường được thêm tự động!!");
			}
			taoMaNhanVien(txtMaMVHC);
			maNV = txtMaMVHC.getText();
			txtMaMVHC.selectAll();

			Date ngayVaoLamDate = new Date();
			ngayVaoLam = LocalDate.parse(dateFormat.format(ngayVaoLamDate));
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy")
						.parse(ngayVaoLam.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Ngày vào làm không hợp lệ!");
				return;
			}
			dchVaoLamHC.setDate(ngayVaoLamDate);

			mucLuong = Double.parseDouble(txtMucLuongHC.getText());
			chucVu = cbxChucVuHC.getSelectedItem().toString();
			try {
				NhanVienHanhChinh nv = new NhanVienHanhChinh(maNV, cccd, ngayVaoLam, sdt, email, chucVu, mucLuong,
						trinhDo, phongBan);
				xoaDuLieuTrongTable();
				nhanVien_dao.themNhanVienHanhChinh(nv, cccd);
				ArrayList<NhanVien> ds = nhanVien_dao.getAllNhanVien();
				docDanhSachNhanVienVaoTable(ds);

			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, e);
				return;
			}

			lblLoiTimKiem.setText("Thêm thành công");
		}
		// nếu là nhân viên kỹ thuật
		else {
			int bacTho = Integer.parseInt(txtBacTho.getText());
			int namKinhNghiem = Integer.parseInt(txtNamKinhNghiem.getText());
			if (!txtMaMVKT.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Không được nhập mã nhân viên vì mã nhân viên là trường được thêm tự động!!");
			}
			taoMaNhanVien(txtMaMVKT);
			maNV = txtMaMVKT.getText();
			txtMaMVKT.selectAll();
			Date ngayVaoLamDate = new Date();
			ngayVaoLam = LocalDate.parse(dateFormat.format(ngayVaoLamDate));
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy")
						.parse(ngayVaoLam.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Ngày vào làm không hợp lệ!");
				return;
			}
			dchVaoLamKT.setDate(ngayVaoLamDate);

			mucLuong = Double.parseDouble(txtMucLuongKT.getText());
			chucVu = cbxChucVuKT.getSelectedItem().toString();

			try {
				NhanVienKiThuat nv = new NhanVienKiThuat(maNV, cccd, ngayVaoLam, sdt, email, chucVu, mucLuong, bacTho,
						namKinhNghiem);
				xoaDuLieuTrongTable();
				nhanVien_dao.themNhanVienKyThuat(nv, cccd);
				ArrayList<NhanVien> ds = nhanVien_dao.getAllNhanVien();
				docDanhSachNhanVienVaoTable(ds);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, e);
				return;
			}
		}
		lblLoiTimKiem.setText("Thêm thành công!");
	}

	private boolean kiemTraChonHangNhanVienTable(int row) {
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng dòng trên table");
			return false;
		} else {
			return true;
		}
	}

	private void xoaNhanVien() {
		int row = table.getSelectedRow();
		if (kiemTraChonHangNhanVienTable(row)) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không !!!");
			if (result == JOptionPane.NO_OPTION) {
				lamMoi();
				return;
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return;
			} else {
				String maNV = tableModel.getValueAt(row, 0).toString();
				if (cbxLoaiNhanVien.getSelectedIndex() == 0) {
					nhanVien_dao.xoaNhanVienHanhChinh(maNV);
				} else
					nhanVien_dao.xoaNhanVienKyThuat(maNV);
				xoaDuLieuTrongTable();
				ArrayList<NhanVien> ds = nhanVien_dao.getAllNhanVien();
				docDanhSachNhanVienVaoTable(ds);
			}
		}
		lblLoiTimKiem.setText("Xóa thành công");
	}

	private boolean kiemTraMaNhanVienTrung(String maNV) {
		ArrayList<NhanVien> dsNhanViens = nhanVien_dao.getAllNhanVien();
		for (NhanVien nv : dsNhanViens) {
			if (maNV.trim().equals(nv.getMaNhanVien())) {
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraCCCDTrung(String maCCCD) {
		ArrayList<CanCuocCongDan> dsCCCD = cCCD_dao.getAllCCCD();
		for (CanCuocCongDan cc : dsCCCD) {
			if (maCCCD.trim().equals(cc.getMaCCCD())) {
				return false;
			}
		}
		return true;
	}

	private boolean kiemTraMaCCCD(String maCCCD, LocalDate ngaySinh, boolean gioiTinh) {
		if (maCCCD.length() < 12) {
			JOptionPane.showMessageDialog(this, "Mã CCCD phải có đủ 12 kí tự số!");
			txtCCCD.selectAll();
			txtCCCD.requestFocus();
			return false;
		}
		int namSinh = ngaySinh.getYear();
		char gioiTinhMa = maCCCD.charAt(3);
		if (namSinh >= 1900 && namSinh < 2000) {
			if (gioiTinh) {
				if (!(gioiTinhMa == '0')) {
					JOptionPane.showMessageDialog(this, "Giới tính nam sinh từ 1900-1999 có mã CCCD(vị trí thứ 4) là 0!");
					txtCCCD.selectAll();
					txtCCCD.requestFocus();
					return false;
				}
			} else {
				if (!(gioiTinhMa == '1')) {
					JOptionPane.showMessageDialog(this, "Giới tính nữ sinh từ 1900-1999 có mã CCCD(vị trí thứ 4) là 1!");
					txtCCCD.selectAll();
					txtCCCD.requestFocus();
					return false;
				}
			}
		} else if (namSinh >= 2000 && namSinh < 2099) {
			if (gioiTinh) {
				if (!(gioiTinhMa == '2')) {
					JOptionPane.showMessageDialog(this, "Giới tính nam sinh từ 2000-2099 có mã CCCD(vị trí thứ 4) là 2!");
					txtCCCD.selectAll();
					txtCCCD.requestFocus();
					return false;
				}
			} else {
				if (!(gioiTinhMa == '3')) {
					JOptionPane.showMessageDialog(this, "Giới tính nữ sinh từ 2000-2099 có mã CCCD(vị trí thứ 4) là 3!");
					txtCCCD.selectAll();
					txtCCCD.requestFocus();
					return false;
				}
			}
		}
		String haiSoCuoiNgaySinh = String.valueOf(namSinh);
		haiSoCuoiNgaySinh = haiSoCuoiNgaySinh.substring(2);
		String maNgaySinh = maCCCD.substring(4, 6);
		if (!haiSoCuoiNgaySinh.equals(maNgaySinh)) {
			JOptionPane.showMessageDialog(this, "Mã CCCD(Vị trí 5-6) phải là 2 kí tự cuôi năm sinh!");
			txtCCCD.selectAll();
			txtCCCD.requestFocus();
			return false;
		}
		if (!maCCCD.matches("(0([0-8][0-9]|9[0-6])([0-9])([0-9]){2}([0-9]){6})")) {
			JOptionPane.showMessageDialog(this, "Mã căn cước công dân không hợp lệ!");
			txtCCCD.selectAll();
			txtCCCD.requestFocus();
			return false;
		}

		return true;
	}

	private boolean kiemTraSDT(String sdt) {
		if (sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		if (!sdt.matches("[0-9]{10}")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại chứa 10 kí số!");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		return true;
	}

	private boolean kiemTraEmail(String eMail) {
		if (eMail.equals("")) {
			JOptionPane.showMessageDialog(this, "Email không được rỗng");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		if (!eMail.matches("([A-Za-z0-9]+@[A-Za-z0-9]+\\.com)")) {
			JOptionPane.showMessageDialog(this, "Email phải có dạng phannnhu981@gmail.com");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}


	private void capNhatNhanVien() {
		int row = table.getSelectedRow();
		if (kiemTraChonHangNhanVienTable(row)) {
			int result = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không !!!");
			if (result == JOptionPane.NO_OPTION) {
				lamMoi();
				return;
			} else if (result == JOptionPane.CANCEL_OPTION) {
				return;
			} else {
				if (!kiemTraRong())
					return;
				String cc = txtCCCD.getText();
				String ho = txtHo.getText();
				String ten = txtTen.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				LocalDate ngayString;
				Date ngaySinh = dchNgaySinh.getDate();
				try {

					ngayString = LocalDate.parse(dateFormat.format(ngaySinh));
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Ngày sinh không được rỗng");
					return;
				}
				boolean gioiTinh = chckbxGioiTinh.isSelected();
				String diaChi = txtDiaChi.getText();
				String sdt = txtSDT.getText();
				if (!kiemTraSDT(sdt))
					return;
				String email = txtEmail.getText();
				if (!kiemTraEmail(email))
					return;
				String maNV;
				LocalDate ngayVaoLam;
				double mucLuong;
				String chucVu;
				String trinhDo;
				String phongBan;
				String ho_hoDem[] = ho.split(" ");
				ho = ho_hoDem[0];
				String tenDem = "";
				for (int i = 1; i < ho_hoDem.length; i++) {
					tenDem += ho_hoDem[i] + " ";
				}
				CanCuocCongDan cccd = null;
				// kiem tra căn cước công dân có trùng hay không
				if (kiemTraCCCDTrung(cc)) {
					JOptionPane.showMessageDialog(this, "Mã căn cước công dân không được phép đổi!");
					txtCCCD.setText(tableModel.getValueAt(row, 1).toString());
					return;
				}
				try {
					cccd = new CanCuocCongDan(cc, ho, tenDem, ten, gioiTinh, ngayString, diaChi, diaChi);
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, e);
					return;
				}
				// nếu là nhân viên hành chính
				if (cbxLoaiNhanVien.getSelectedIndex() == 0) {
					trinhDo = txtTrinhDoHocVan.getText();
//					phongBan = txtPhongBan.getText();
					phongBan = cbxPhongBan.getSelectedItem().toString();
					maNV = txtMaMVHC.getText();
					try {
						ngayVaoLam = LocalDate.parse(dateFormat.format(dchVaoLamHC.getDate()));
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Ngày vào làm hành chính không được rỗng");
						return;
					}
					mucLuong = Double.parseDouble(txtMucLuongHC.getText());
//					chucVu = txtChucVuHC.getText();
					chucVu = cbxChucVuHC.getSelectedItem().toString();
					if (kiemTraMaNhanVienTrung(maNV)) {
						JOptionPane.showMessageDialog(this, "Mã nhân viên không được phép đổi!");
						txtMaMVHC.setText(tableModel.getValueAt(row, 0).toString());
						txtMaMVHC.requestFocus();
						return;
					}
					try {
						NhanVienHanhChinh nv = new NhanVienHanhChinh(maNV, cccd, ngayVaoLam, sdt, email, chucVu,
								mucLuong, trinhDo, phongBan);
						xoaDuLieuTrongTable();
						nhanVien_dao.updateNhanVienHanhChinh(nv, cccd);
						ArrayList<NhanVien> ds = nhanVien_dao.getAllNhanVien();
						docDanhSachNhanVienVaoTable(ds);

					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, e);
						return;
					}
				}
				// nếu là nhân viên kỹ thuật
				else {
					int bacTho = Integer.parseInt(txtBacTho.getText());
					int namKinhNghiem = Integer.parseInt(txtNamKinhNghiem.getText());
					maNV = txtMaMVKT.getText();
					try {
						ngayVaoLam = LocalDate.parse(dateFormat.format(dchVaoLamKT.getDate()));
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Ngày vào làm không được rỗng");
						return;
					}
					mucLuong = Double.parseDouble(txtMucLuongKT.getText());
//					chucVu = txtChucVuKT.getText();
					chucVu = cbxChucVuKT.getSelectedItem().toString();
					if (kiemTraMaNhanVienTrung(maNV)) {
						JOptionPane.showMessageDialog(this, "Mã nhân viên không được phép đổi!");
						txtMaMVKT.setText(tableModel.getValueAt(row, 0).toString());
						txtMaMVKT.requestFocus();
						return;
					}
					try {
						NhanVienKiThuat nv = new NhanVienKiThuat(maNV, cccd, ngayVaoLam, sdt, email, chucVu, mucLuong,
								bacTho, namKinhNghiem);
						xoaDuLieuTrongTable();
						nhanVien_dao.updateNhanVienKyThuat(nv, cccd);
						ArrayList<NhanVien> ds = nhanVien_dao.getAllNhanVien();
						docDanhSachNhanVienVaoTable(ds);
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, e);
						return;
					}
				}
			}
			lblLoiTimKiem.setText("Cập nhật thành công");
		}
	}

	private boolean kiemTraRong() {
		if (txtHo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Họ nhân viên khong được rỗng");
			txtHo.selectAll();
			txtHo.requestFocus();
			return false;
		}
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên nhân viên khong được rỗng");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}
		if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ nhân viên khong được rỗng");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		}
		if (cbxLoaiNhanVien.getSelectedIndex() == 0) {
			if (cbxPhongBan.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng ban");
				return false;
			}
			if (txtTrinhDoHocVan.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Trình độ học vấn khong được rỗng");
				txtTrinhDoHocVan.selectAll();
				txtTrinhDoHocVan.requestFocus();
				return false;
			}
			if (txtMucLuongHC.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mức lương nhân viên khong được rỗng");
				txtMucLuongHC.selectAll();
				txtMucLuongHC.requestFocus();
				return false;
			}
			if (cbxChucVuHC.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ");
				return false;
			}
		} else {
			if (txtBacTho.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Bậc thợ khong được rỗng");
				txtBacTho.selectAll();
				txtBacTho.requestFocus();
				return false;
			}
			if (txtNamKinhNghiem.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Năm kinh nghiệm khong được rỗng");
				txtNamKinhNghiem.selectAll();
				txtNamKinhNghiem.requestFocus();
				return false;
			}
			if (txtMucLuongKT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mức lương nhân viên khong được rỗng");
				txtMucLuongKT.selectAll();
				txtMucLuongKT.requestFocus();
				return false;
			}
			if (cbxChucVuKT.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ");
				return false;
			}
		}
		return true;
	}

	private void locNhanVien() {
		int result = JOptionPane.showConfirmDialog(this, "Bạn đã làm mới trang trước khi chọn lọc chưa??!", "Xác nhận",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.NO_OPTION) {
			return;
		} else {
			xoaDuLieuTrongTable();
			ArrayList<NhanVien> ds = nhanVien_dao.getAllNhanVien();
			docDanhSachNhanVienVaoTable(ds);
			// loc theo can cuoc cong dan
			locNhanVienTheoHoDem();
			locNhanVienTheoTen();
			locNhanVienTheoSDT();
			locNhanVienTheoLoaiNhanVien();
			locNhanVienTheoEmail();
			locNhanVienDiaChi();
			locNhanVienMaCCCD();
			// loc hanh chinh
			locNhanVienTheoMaHanhChinh();
			locNhanVienTheoNgayVaoLamHC();
			locNhanVienTheoPhongBan();
			locNhanVienTheoChucVu();
			locNhanVienTheoMucLuong();
			locNhanVienTheoTrinhDo();
			// loc kĩ thuat
			locNhanVienTheoMaKyThuat();
			locNhanVienTheoNgayVaoLamKT();
			locNhanVienTheoMucLuongKT();
			locNhanVienTheoChucVuKT();
			locNhanVienTheoBacTho();
			locNhanVienTheoNamKN();
			if (table.getRowCount() <= 0) {
				lblLoiTimKiem.setText("Không tìm thấy dữ liệu bạn tìm kiếm!!");
			} else
				lblLoiTimKiem.setText("Tìm thấy!");
		}
	}

	private ArrayList<NhanVien> layDSNhanVienHC() {
		ArrayList<NhanVien> dsNhanVienHC = new ArrayList<NhanVien>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			if (!tableModel.getValueAt(i, 12).equals("")) {
				NhanVien nvhc = nhanVien_dao.getNhanVienHanhChinhTheoMaNV(tableModel.getValueAt(i, 0).toString());
				dsNhanVienHC.add(nvhc);
			}
		}
		return dsNhanVienHC;
	}

	private ArrayList<NhanVien> layDSNhanVienKT() {
		ArrayList<NhanVien> dsNhanVienHC = new ArrayList<NhanVien>();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			if (tableModel.getValueAt(i, 12).equals("")) {
				NhanVien nvhc = nhanVien_dao.getNhanVienKyThuatTheoMaNV(tableModel.getValueAt(i, 0).toString());
				dsNhanVienHC.add(nvhc);
			}
		}
		return dsNhanVienHC;
	}

	private void locNhanVienTheoLoaiNhanVien() {
		if (cbxLoaiNhanVien.getSelectedIndex() == 0) {
			ArrayList<NhanVien> ds = layDSNhanVienHC();
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		} else {
			ArrayList<NhanVien> ds = layDSNhanVienKT();
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}

	private void locNhanVienTheoMaHanhChinh() {
		if (txtMaMVHC.getText().trim().equals("")) {
			return;
		} else {
			NhanVien nv = nhanVien_dao.getNhanVienTheoMaNV(txtMaMVHC.getText());
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			ds.add(nv);
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}

	private void locNhanVienTheoNgayVaoLamHC() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate ngayVaoLam;
		Date ngayVaoLamDate = dchVaoLamHC.getDate();
		try {
			ngayVaoLam = LocalDate.parse(dateFormat.format(ngayVaoLamDate));
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		ArrayList<NhanVien> dsNhanVien = layDSNhanVienHC();
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		for (NhanVien nv : dsNhanVien) {
			if (ngayVaoLam.equals(nv.getNgayVaoLamViec())) {
				ds.add(nv);
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(ds);
	}

	private void locNhanVienTheoTrinhDo() {
		if (txtTrinhDoHocVan.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien = layDSNhanVienHC();
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			for (NhanVien nv : dsNhanVien) {
				if (nv instanceof NhanVienHanhChinh) {
					if (((NhanVienHanhChinh) nv).getTrinhDoHocVan().equals(txtTrinhDoHocVan.getText())) {
						ds.add(nv);
					}
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}

	private void locNhanVienTheoMaKyThuat() {
		if (txtMaMVKT.getText().trim().equals("")) {
			return;
		} else {
			NhanVien nv = nhanVien_dao.getNhanVienTheoMaNV(txtMaMVKT.getText());
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			ds.add(nv);
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}

	private void locNhanVienTheoPhongBan() {
		ArrayList<NhanVien> ds = layDSNhanVienHC();
		ArrayList<NhanVien> dsPhongBan = new ArrayList<NhanVien>();
		if (cbxPhongBan.getSelectedIndex() == 0)
			return;
		else {
			for (NhanVien nv : ds) {
				if (nv instanceof NhanVienHanhChinh) {
					if (((NhanVienHanhChinh) nv).getPhongBan().equals(cbxPhongBan.getSelectedItem().toString())) {
						dsPhongBan.add(nv);
					}
				}
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsPhongBan);
	}

	private void locNhanVienTheoChucVu() {
		ArrayList<NhanVien> ds = layDSNhanVienHC();
		ArrayList<NhanVien> dsChucVu = new ArrayList<NhanVien>();
		if (cbxChucVuHC.getSelectedIndex() == 0)
			return;
		else {
			for (NhanVien nv : ds) {
				if (nv instanceof NhanVienHanhChinh) {
					if (((NhanVienHanhChinh) nv).getChucVu().equals(cbxChucVuHC.getSelectedItem().toString())) {
						dsChucVu.add(nv);
					}
				}
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsChucVu);
	}

	/**
	 * có thể nhập số hoặc kí tự đầu tiên là >, <, ""
	 */
	private void locNhanVienTheoMucLuong() {
		String luong = txtMucLuongHC.getText();
		if (luong.trim().equals(""))
			return;
		ArrayList<NhanVien> dsNhanVien = layDSNhanVienHC();
		ArrayList<NhanVien> dsLoc = new ArrayList<NhanVien>();
		int lon_be = 0; // nếu bắt đầu bằng đấu lớn thì lon_be=1, dấu bé lon_be=-1, dấu bằng lon_be=0
		if (luong.charAt(0) == '>')
			lon_be = 1;
		if (luong.charAt(0) == '<')
			lon_be = -1;
		int nam;
		if (lon_be == 0)
			nam = Integer.parseInt(luong);
		else
			nam = Integer.parseInt(luong.substring(1));
		for (NhanVien nv : dsNhanVien) {
			if (lon_be == 0) {
				if (nam == nv.getLuong())
					dsLoc.add(nv);
			} else if (lon_be == -1) {
				if (nam > nv.getLuong())
					dsLoc.add(nv);
			} else if (lon_be > 0) {
				if (nam < nv.getLuong())
					dsLoc.add(nv);
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsLoc);
	}

	private void locNhanVienTheoNgayVaoLamKT() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate ngayVaoLam;
		Date ngayVaoLamDate = dchVaoLamKT.getDate();
		try {
			ngayVaoLam = LocalDate.parse(dateFormat.format(ngayVaoLamDate));
		} catch (Exception e) {
			// TODO: handle exception
			return;
		}
		ArrayList<NhanVien> dsNhanVien = layDSNhanVienKT();
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		for (NhanVien nv : dsNhanVien) {
			if (ngayVaoLam.equals(nv.getNgayVaoLamViec())) {
				ds.add(nv);
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(ds);
	}

	/**
	 * có thể nhập số hoặc kí tự đầu tiên là >, <, ""
	 */
	private void locNhanVienTheoMucLuongKT() {
		String luong = txtMucLuongKT.getText();
		if (luong.trim().equals(""))
			return;
		ArrayList<NhanVien> dsNhanVien = layDSNhanVienKT();
		ArrayList<NhanVien> dsLoc = new ArrayList<NhanVien>();
		int lon_be = 0; // nếu bắt đầu bằng đấu lớn thì lon_be=1, dấu bé lon_be=-1, dấu bằng lon_be=0
		if (luong.charAt(0) == '>')
			lon_be = 1;
		if (luong.charAt(0) == '<')
			lon_be = -1;
		int nam;
		if (lon_be == 0)
			nam = Integer.parseInt(luong);
		else
			nam = Integer.parseInt(luong.substring(1));
		for (NhanVien nv : dsNhanVien) {
			if (lon_be == 0) {
				if (nam == nv.getLuong())
					dsLoc.add(nv);
			} else if (lon_be == -1) {
				if (nam > nv.getLuong())
					dsLoc.add(nv);
			} else if (lon_be > 0) {
				if (nam < nv.getLuong())
					dsLoc.add(nv);
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsLoc);
	}

	private void locNhanVienTheoChucVuKT() {
		ArrayList<NhanVien> ds = layDSNhanVienKT();
		ArrayList<NhanVien> dsChucVu = new ArrayList<NhanVien>();
		if (cbxChucVuKT.getSelectedIndex() == 0)
			return;
		else {
			for (NhanVien nv : ds) {
				if (nv instanceof NhanVienKiThuat) {
					if (((NhanVienKiThuat) nv).getChucVu().equals(cbxChucVuKT.getSelectedItem().toString())) {
						dsChucVu.add(nv);
					}
				}
			}
		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsChucVu);
	}

	private void locNhanVienTheoBacTho() {
		String bacTho = txtBacTho.getText();
		if (bacTho.trim().equals(""))
			return;
		ArrayList<NhanVien> dsNhanVien = layDSNhanVienKT();
		ArrayList<NhanVien> dsLoc = new ArrayList<NhanVien>();
		int lon_be = 0; // nếu bắt đầu bằng đấu lớn thì lon_be=1, dấu bé lon_be=-1, dấu bằng lon_be=0
		if (bacTho.charAt(0) == '>')
			lon_be = 1;
		if (bacTho.charAt(0) == '<')
			lon_be = -1;
		int nam;
		if (lon_be == 0)
			nam = Integer.parseInt(bacTho);
		else
			nam = Integer.parseInt(bacTho.substring(1));
		for (NhanVien nv : dsNhanVien) {
			if (nv instanceof NhanVienKiThuat) {
				if (lon_be == 0) {
					if (nam == ((NhanVienKiThuat) nv).getBacTho())
						dsLoc.add(nv);
				} else if (lon_be == -1) {
					if (nam > ((NhanVienKiThuat) nv).getBacTho())
						dsLoc.add(nv);
				} else if (lon_be > 0) {
					if (nam < ((NhanVienKiThuat) nv).getBacTho())
						dsLoc.add(nv);
				}
			}

		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsLoc);
	}

	private void locNhanVienTheoNamKN() {
		String namKN = txtNamKinhNghiem.getText();
		if (namKN.trim().equals(""))
			return;
		ArrayList<NhanVien> dsNhanVien = layDSNhanVienKT();
		ArrayList<NhanVien> dsLoc = new ArrayList<NhanVien>();
		int lon_be = 0; // nếu bắt đầu bằng đấu lớn thì lon_be=1, dấu bé lon_be=-1, dấu bằng lon_be=0
		if (namKN.charAt(0) == '>')
			lon_be = 1;
		if (namKN.charAt(0) == '<')
			lon_be = -1;
		int nam;
		if (lon_be == 0)
			nam = Integer.parseInt(namKN);
		else
			nam = Integer.parseInt(namKN.substring(1));
		for (NhanVien nv : dsNhanVien) {
			if (nv instanceof NhanVienKiThuat) {
				if (lon_be == 0) {
					if (nam == ((NhanVienKiThuat) nv).getSoNamKN())
						dsLoc.add(nv);
				} else if (lon_be == -1) {
					if (nam > ((NhanVienKiThuat) nv).getSoNamKN())
						dsLoc.add(nv);
				} else if (lon_be > 0) {
					if (nam < ((NhanVienKiThuat) nv).getSoNamKN())
						dsLoc.add(nv);
				}
			}

		}
		xoaDuLieuTrongTable();
		docDanhSachNhanVienVaoTable(dsLoc);
	}

	private void locNhanVienTheoHoDem() {
		if (txtHo.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien ;
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			if (cbxLoaiNhanVien.getSelectedIndex() == 0)
				dsNhanVien = layDSNhanVienHC();
			else
				dsNhanVien = layDSNhanVienKT();
			String hoDem;
			for (NhanVien nv : dsNhanVien) {
				if (nv.getCccd().getHoDem() == null || nv.getCccd().getHoDem().equals(""))
					hoDem = nv.getCccd().getHo();
				else
					hoDem = nv.getCccd().getHo() + " " + nv.getCccd().getHoDem().trim();
				if (txtHo.getText().equalsIgnoreCase(hoDem)) {
					ds.add(nv);
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}

	private void locNhanVienTheoTen() {
		if (txtTen.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien ;
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			if (cbxLoaiNhanVien.getSelectedIndex() == 0)
				dsNhanVien = layDSNhanVienHC();
			else
				dsNhanVien = layDSNhanVienKT();
			for (NhanVien nv : dsNhanVien) {
				if (txtTen.getText().equals(nv.getCccd().getTen())) {
					ds.add(nv);
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}
	
	private void locNhanVienTheoSDT() {
		if (txtSDT.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien ;
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			if (cbxLoaiNhanVien.getSelectedIndex() == 0)
				dsNhanVien = layDSNhanVienHC();
			else
				dsNhanVien = layDSNhanVienKT();
			for (NhanVien nv : dsNhanVien) {
				if (txtSDT.getText().equals(nv.getSoDienThoai())) {
					ds.add(nv);
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}

	private void locNhanVienTheoEmail() {
		if (txtEmail.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien ;
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			if (cbxLoaiNhanVien.getSelectedIndex() == 0)
				dsNhanVien = layDSNhanVienHC();
			else
				dsNhanVien = layDSNhanVienKT();
			for (NhanVien nv : dsNhanVien) {
				if (txtEmail.getText().equals(nv.getEmail())) {
					ds.add(nv);
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}
	
	private void locNhanVienDiaChi() {
		if (txtDiaChi.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien ;
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			if (cbxLoaiNhanVien.getSelectedIndex() == 0)
				dsNhanVien = layDSNhanVienHC();
			else
				dsNhanVien = layDSNhanVienKT();
			for (NhanVien nv : dsNhanVien) {
				if (txtDiaChi.getText().equals(nv.getCccd().getThuongTru())) {
					ds.add(nv);
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}
	
	private void locNhanVienMaCCCD() {
		if (txtCCCD.getText().trim().equals(""))
			return;
		else {
			ArrayList<NhanVien> dsNhanVien ;
			ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
			if (cbxLoaiNhanVien.getSelectedIndex() == 0)
				dsNhanVien = layDSNhanVienHC();
			else
				dsNhanVien = layDSNhanVienKT();
			for (NhanVien nv : dsNhanVien) {
				if (txtCCCD.getText().equals(nv.getCccd().getMaCCCD())) {
					ds.add(nv);
				}
			}
			xoaDuLieuTrongTable();
			docDanhSachNhanVienVaoTable(ds);
		}
	}
	
	
	private void sapXepNhanVien(ArrayList<NhanVien> dsNhanVien) {
		Collections.sort(dsNhanVien, new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				if (o1 != null && o2 != null)
					return o1.getMaNhanVien().compareTo(o2.getMaNhanVien());
				return 0;
			}
		});
	}

	private void taoMaNhanVien(JTextField txtMaNV) {
		String maNV = "NV";
		LocalDate ngayHT = LocalDate.now();
		int maSoNV = nhanVien_dao.countNhanVienTheoNgay(ngayHT);
		DecimalFormat df = new DecimalFormat("00");
		maNV += df.format(++maSoNV);
		maNV += ngayHT.format(DateTimeFormatter.ofPattern("ddMMyy"));
		txtMaNV.setText(maNV);
	}

}
