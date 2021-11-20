package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.Khoa;
import models.Lop;
import models.SinhVien;
import utils.DBConnection;

public class sinhvienDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<SinhVien> getAll() {
		List<SinhVien> ds = new ArrayList<SinhVien>();
		String sql = "SELECT sv.maSV, sv.tenSV, sv.diachi, sv.sdt, sv.email, sv.email, l.maLop, l.tenLop, k.maKhoa, k.tenKhoa, k.lienheKhoa " + 
				"FROM sinhvien as sv JOIN lop as l ON sv.maLop = l.maLop " + 
				"JOIN khoa as k ON l.maKhoa = k.maKhoa";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Khoa khoa = new Khoa(rs.getString("maKhoa"), rs.getString("tenKhoa"), rs.getString("lienheKhoa"));
				Lop lop = new Lop(rs.getInt("maLop"), rs.getString("tenLop"), khoa);
				
				ds.add(new SinhVien(rs.getString("maSV"), rs.getString("tenSV"), rs.getString("diachi"), rs.getInt("sdt"), rs.getString("email")
						, lop));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public int addSV(SinhVien sv) {
		int res = 0;
		String sql = "INSERT INTO `sinhvien`( `maSV`, `tenSV`, `diachi`, `sdt`, `email`, `maLop`) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, sv.getMaSV());
			pst.setString(2, sv.getTenSV());
			pst.setString(3, sv.getDiachi());
			pst.setInt(4, sv.getSdt());
			pst.setString(5, sv.getEmail());
			pst.setInt(6, sv.getLop().getMaLop());
			
			res = pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int editSV(SinhVien sv) {
		int res = 0;
		String sql = "UPDATE `sinhvien` SET `tenSV`= ?,`diachi`= ?,`sdt`= ?,`email`= ? WHERE maSV = ?";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, sv.getTenSV());
			pst.setString(2, sv.getDiachi());
			pst.setInt(3, sv.getSdt());
			pst.setString(4, sv.getEmail());
			pst.setString(5, sv.getMaSV());
			
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int deleteSV(String msv) {
		int rs = 0;
		String sql="DELETE FROM `sinhvien` WHERE maSV = ?";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, msv);
			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
