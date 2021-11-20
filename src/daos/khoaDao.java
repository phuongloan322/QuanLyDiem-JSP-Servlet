package daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.Khoa;
import utils.DBConnection;

public class khoaDao {
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	private Connection cnn = DBConnection.getConnection();
	
	public List<Khoa> getAll() {
		List<Khoa> ds = new ArrayList<Khoa>();
		String sql ="SELECT `maKhoa`, `tenKhoa`, `lienheKhoa` FROM `khoa` WHERE 1";
		try {
			st = (Statement) cnn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ds.add(new Khoa(rs.getString("maKhoa"), rs.getString("tenKhoa"), rs.getString("lienheKhoa")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ds;
	}
	
	public int addKhoa(Khoa k) {
		
		String sql = "INSERT INTO `khoa`(`maKhoa`, `tenKhoa`, `lienheKhoa`) VALUES (?,?,?)";
		int res = 0;
		try {
			pst = (PreparedStatement) cnn.prepareStatement(sql);
			pst.setString(1, k.getMaKhoa());
			pst.setString(2, k.getTenKhoa());
			pst.setString(3, k.getLienheKhoa());
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
