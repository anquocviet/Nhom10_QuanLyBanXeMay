package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.CanCuocCongDan;
import entity.KhachHang;
import entity.NhanVien;

public class KhachHang_DAO {
	private CanCuocCongDan_DAO cccd_dao;

	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String sql = "SELECT * FROM KhachHang";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String maCCCD = rs.getString("MaCCCD");
				String sdt = rs.getString("SoDienThoai");
				CanCuocCongDan c = new CanCuocCongDan(maCCCD);
				KhachHang kh = new KhachHang(maKH, sdt, c);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dskh;
	}

	public KhachHang getKhachHangTheoMaKH(String maKhachHang) {
		KhachHang kh = null;
		Connection con = ConnectDB.getInstance().getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();

			String sql = "SELECT * FROM KhachHang WHERE MaKH = '" + maKhachHang + "'";
			
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String maCCCD = rs.getString("MaCCCD");
				String sdt = rs.getString("SoDienThoai");
				cccd_dao = new CanCuocCongDan_DAO();
				CanCuocCongDan cc = cccd_dao.getCCCD(maCCCD);
				kh = new KhachHang(maKH, sdt, cc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kh;
	}

}
