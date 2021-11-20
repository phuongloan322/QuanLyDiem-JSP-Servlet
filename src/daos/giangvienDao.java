package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.GiangVien;
import utils.DBConnection;

public class giangvienDao {
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection cnn = DBConnection.getConnection();
	
	public List<GiangVien> getAll() {
		List<GiangVien> ds = new ArrayList<GiangVien>();
		String sql = "SELECT `maGV`, `tenGV`, `diachi`, `sdt`, `email` FROM `giangvien` WHERE 1";
		
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new GiangVien(rs.getString("maGV"), rs.getString("tenGV"), rs.getString("diachi"), rs.getInt("sdt"), rs.getString("email")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public int addGV(GiangVien gv) {
		int res = 0;
		String sql = "INSERT INTO `giangvien`(`maGV`, `tenGV`, `diachi`, `sdt`, `email`) VALUES (?,?,?,?,?)";
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, gv.getMaGV());
			pst.setString(2, gv.getTenGV());
			pst.setString(3, gv.getDiachi());
			pst.setInt(4, gv.getSdt());
			pst.setString(5, gv.getEmail());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
